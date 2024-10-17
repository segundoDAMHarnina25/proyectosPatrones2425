package banco02.problema.account;

import banco02.problema.Showable;

public abstract class AbstractProductAccount implements Showable {

	public float comission;
	
	public AbstractProductAccount(float comission) {
		super();
		this.comission = comission;
	}

}
