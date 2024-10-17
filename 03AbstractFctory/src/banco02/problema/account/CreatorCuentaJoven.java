package banco02.problema.account;

public class CreatorCuentaJoven implements AbstractAccountCreator{

	@Override
	public AbstractProductAccount factoryMethod() {
		return new CuentaJoven(3f) ;
	}

}
