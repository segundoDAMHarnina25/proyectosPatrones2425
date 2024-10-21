package modelo.repositorios;

import java.io.Serializable;
import java.util.Map;

public class CompactDataCounter<T,S> extends CompactDataAbstract<Long, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long savedObjects = 0l;
	private Long deletedObjects = 0l;
	private float wasteFactor;

	public CompactDataCounter(float wasteFactor) {
		super(wasteFactor);
		this.wasteFactor = wasteFactor;
	}

	
	public Long addObjects(Long amount) {
		Long long1 = savedObjects+=amount;
		return long1;
	}

	public Long deleteObjects(Long amount) {
		savedObjects-= amount;
		Long long1 = deletedObjects+=amount;
		return long1;
	}

	public boolean isCritical() {
		// clausula de guarda
		if (savedObjects == 0)
			return false;
		float ratio = (float) deletedObjects / savedObjects;
		return ratio >= wasteFactor;
	}
	
	public Long getSavedObjects() {
		return savedObjects;
	}

	public Long getDeletedObjects() {
		return deletedObjects;
	}

}
