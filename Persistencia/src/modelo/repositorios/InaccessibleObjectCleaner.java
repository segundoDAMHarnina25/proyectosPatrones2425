package modelo.repositorios;

public interface InaccessibleObjectCleaner<S,Q> {

	public void clean(S objectFile, Q index);
}
