package modelo.repositorios;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import exceptions.IndexNotAccsibleException;
import exceptions.NotFolderPath;

public class RepositorioFicheroIndexado<T extends KeyAccesible<S>, S,Q extends Number> implements Repository<T, S> {

	protected String pathFolder;
	private String indexFile, objectFile;
	protected Map<S, Q> index;
	private AccesibleUnicoObjeto<Map<S, Q>> accesoUnicoObjetoMapa;
	protected AccesibleMultiObjeto<T,Q> accesoMultiObjeto;
	
	
	public RepositorioFicheroIndexado(String pathFolder
			, AccesibleMultiObjeto<T,Q> accesoMultiObjeto)
		throws 
			NotFolderPath, 
			IndexNotAccsibleException 
			 {
		super();
		this.pathFolder = pathFolder;
		checkPath(pathFolder);
		createPaths();
		if (!loadIndex()) throw new IndexNotAccsibleException();
		
		this.accesoMultiObjeto = accesoMultiObjeto;
		this.accesoMultiObjeto.setPath(objectFile);
	}

	private void createPaths() {
		indexFile = "./" + pathFolder + "/index.data";
		objectFile = "./" + pathFolder + "/objects.data";
	}

	private boolean loadIndex() {
		try {
			accesoUnicoObjetoMapa = new AccesoFicheroSerializadoUnicoObjeto<Map<S, Q>>(indexFile);
			index = accesoUnicoObjetoMapa.load().orElse(new HashMap<>());
			if (index.size() == 0)
				accesoUnicoObjetoMapa.save(index);
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void checkPath(String pathFolder) throws NotFolderPath {
		File folder = new File(pathFolder);
		// si existe y es un directorio
		boolean exists = folder.exists();
		if (exists && !folder.isDirectory())
			throw new NotFolderPath();
		if (!exists) {
			folder.mkdir();
		}
	}

	@Override
	public boolean add(T objeto) {
		if (index.containsKey(objeto.getKey()))
			return false;
		Optional<Q> save = accesoMultiObjeto.save(objeto);
		if (save.isEmpty()) {
			return undoingChanges();
		}
		index.put(objeto.getKey(), save.get());
		try {
			accesoUnicoObjetoMapa.save(index);
		} catch (Exception e) {
			index.remove(objeto.getKey());
			return undoingChanges();
		}
		return true;
	}

	private boolean undoingChanges() {
		accesoMultiObjeto.undo();
		return false;
	}

	@Override
	public Optional<T> getByKey(S key) {
		Q long1 = index.get(key);
		if (long1 != null) {
			return accesoMultiObjeto.load(long1);
		}
		return Optional.empty();
	}

	@Override
	public boolean update(T objeto) {
		Optional<T> delete = delete(objeto.getKey());
		if(delete.isPresent()) {
			return add(objeto);
		}
		return false;
	}

	@Override
	public Optional<T> delete(S key) {
		Optional<T> byKey = getByKey(key);
		if(byKey.isPresent()) {
			index.remove(key);
			return byKey;
		}
		return Optional.empty();
	}

}
