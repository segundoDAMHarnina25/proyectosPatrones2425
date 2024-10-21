package modelo.repositorios;

import java.util.Map;

public class CleanerMapsRandomAccess<T,S,Q extends Number> implements InaccessibleObjectCleaner<AccesibleMultiObjeto<T,Q>, Map<S, Q>>{

	@Override
	public void clean(AccesibleMultiObjeto<T,Q> objectFile, Map<S, Q> index) {
		System.out.println("arreglando despues de Asociar a Abstractos");
		
	} 

}
