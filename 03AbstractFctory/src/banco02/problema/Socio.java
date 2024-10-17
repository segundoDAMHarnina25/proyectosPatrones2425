package banco02.problema;

import banco02.problema.account.AbstractAccountCreator;
import banco02.problema.account.AbstractProductAccount;
import banco02.problema.debitcard.AbstractDebitCard;
import banco02.problema.debitcard.AbstractDebitCardCreator;

public class Socio {
	private int id;
	private AbstractProductAccount cuenta;
	private AbstractDebitCard tarjetaDebito;

	public Socio(int id, AbstractAccountCreator creatorAC,AbstractDebitCardCreator creatorDC) {
		super();
		this.id = id;
		this.cuenta = creatorAC.factoryMethod();
		this.tarjetaDebito=creatorDC.factoryMethod();
	}

	public int getId() {
		return id;
	}

	public AbstractProductAccount getCuenta() {
		return cuenta;
	}

	public AbstractDebitCard getTarjetaDebito() {
		return tarjetaDebito;
	}
	

}
