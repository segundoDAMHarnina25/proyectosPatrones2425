package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.CompaqDataNotAccesibleException;
import exceptions.IndexNotAccsibleException;
import exceptions.NotFolderPath;
import modelo.dominio.Articulo;
import modelo.repositorios.AccesoAleatorioFicheroSerializadoMultiObjeto;
import modelo.repositorios.RepositorioFicheroIndexadoCompactable;
import modelo.repositorios.Repository;
import modelo.repositorios.om.ArticuloOM;

class RepositorioFicheroIndexadoCompaqTest {
	Repository<Articulo,Long> articulosRepositorio;
	String pathFolder="articuloscompactos";
	
	@BeforeEach
	void before() {
		try {
			try {
				articulosRepositorio=
						articulosRepositorio=new RepositorioFicheroIndexadoCompactable<Articulo,Long,Long>
				(pathFolder, new AccesoAleatorioFicheroSerializadoMultiObjeto<Articulo>());
			} catch (CompaqDataNotAccesibleException e) {
				e.printStackTrace();
			}
		} catch (NotFolderPath e) {
			e.printStackTrace();
		} catch (IndexNotAccsibleException e) {
			e.printStackTrace();
		}
	}
	@Test
	void test() {
		
		ArticuloOM articuloOM = new ArticuloOM();
		List<Articulo> elementos = articuloOM.getElementos();
		assertEquals(articuloOM.cantidad, elementos.size());
		elementos.stream().forEach((art)->{
			articulosRepositorio.add(art);
		});
		assertTrue(elementos.stream().noneMatch((art)->articulosRepositorio.getByKey(art.getKey()).isEmpty()));
		//vamos a borrar menos de un 20%
		int veintePorCiento=(int) (articuloOM.cantidad*.2);
		IntStream.range(0, veintePorCiento).boxed().forEach((index)->{
			Optional<Articulo> delete = articulosRepositorio.delete(elementos.get(index).getKey());
			assertTrue(delete.isPresent());
			assertEquals(delete.get(), elementos.get(index));
		});
		assertEquals(((RepositorioFicheroIndexadoCompactable)articulosRepositorio).compactData.getSavedObjects(), elementos.size()-veintePorCiento);
		int index = veintePorCiento+1;
		Optional<Articulo> delete = articulosRepositorio.delete(elementos.get(index).getKey());
		assertTrue(delete.isPresent());
		assertEquals(delete.get(), elementos.get(index));
	}
	
	@AfterEach
	void after() {
		File file=new File(pathFolder);
		if(file.exists()&&file.isDirectory()) {
			Arrays.asList(file.listFiles()).forEach(actual->actual.delete());
			file.delete();
		}
	}
}
