package modelo.repositorios;

import java.io.Serializable;

public abstract class CompactDataAbstract<P,T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private T savedObjects;
	private P deletedObjects;
	private float wasteFactor;

	public CompactDataAbstract(float wasteFactor) {
		super();
		this.wasteFactor = wasteFactor;
	}

	public abstract T addObjects(T amount);

	public abstract P deleteObjects(P amount) ;

	public abstract boolean isCritical();
	
	public T getSavedObjects() {
		return savedObjects;
	}

	public P getDeletedObjects() {
		return deletedObjects;
	}

}
