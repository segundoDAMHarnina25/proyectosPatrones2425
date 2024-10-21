package modelo.repositorios;

import java.io.IOException;
import java.util.Optional;

import exceptions.CompaqDataNotAccesibleException;
import exceptions.IndexNotAccsibleException;
import exceptions.NotFolderPath;

//no usar extends para los tipos parametrizados en la herencia de una clase
public class RepositorioFicheroIndexadoCompactable<T extends KeyAccesible<S>,S,Q extends Number> 
	extends RepositorioFicheroIndexado<T,S,Q>{

	// Para la compactacion
	public CompactDataCounter<T,S> compactData;
	private AccesibleUnicoObjeto<CompactDataCounter> accesoUnicoObjetoCompactData;
	private CleanerMapsRandomAccess<T,S,Q> cleaner=new CleanerMapsRandomAccess<>();
	private String compaqFile;
	private float wasteLevel = .2f;

	public RepositorioFicheroIndexadoCompactable(String pathFolder, 
			AccesibleMultiObjeto accesoMultiObjeto)
			throws 
				NotFolderPath, 
				IndexNotAccsibleException, 
				CompaqDataNotAccesibleException {
		super(pathFolder, accesoMultiObjeto);
		createPathsCompaq();
		if(!loadCompaqFile()) throw new CompaqDataNotAccesibleException();
	}

	private void createPathsCompaq() {
		compaqFile= "./" + pathFolder + "/compaq.data";
	}
	
	private boolean loadCompaqFile() {
		try {
			accesoUnicoObjetoCompactData = new AccesoFicheroSerializadoUnicoObjeto<CompactDataCounter>(compaqFile);
			compactData = accesoUnicoObjetoCompactData.load().orElse(new CompactDataCounter(wasteLevel));
			accesoUnicoObjetoCompactData.save(compactData);
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void cleanCritical() {
		if(compactData.isCritical()) {
			cleaner.clean(accesoMultiObjeto, index);
		}
	}
	
	
	@Override
	public boolean add(T objeto) {
		boolean retorno = super.add(objeto);
		if(retorno) {
			compactData.addObjects(1l);
			cleanCritical();
		}
		return retorno;
	}

	
	@Override
	public Optional<T> delete(S key) {
		//la parte compaq
		Optional<T> delete = super.delete(key);
		delete.ifPresent((k)->{
			compactData.deleteObjects(1l);	
			cleanCritical();
		});
		return delete;
		
	}

}
