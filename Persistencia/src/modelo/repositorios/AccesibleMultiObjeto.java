package modelo.repositorios;

import java.util.Optional;

public interface AccesibleMultiObjeto<T,Q extends Number> {

	Optional<T> load(Q offset);

	Optional<Q> save(T t);

	void undo();
	
	void setPath(String path);

}