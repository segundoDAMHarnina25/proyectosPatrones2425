package modelo.repositorios;

import java.util.Optional;

public class AccesoSecuencialFicheroSerializadoMultiObjeto<T> implements AccesibleMultiObjeto<T,Integer> {

	@Override
	public Optional<T> load(Integer offset) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Integer> save(T t) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPath(String path) {
		// TODO Auto-generated method stub
		
	}

	
}
