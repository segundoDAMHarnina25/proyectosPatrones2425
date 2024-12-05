package facadecommand.interfaces;

public interface FacadeCommand<T,S> {
	public void grabar(T t);

	public void borrar(S s);
}
