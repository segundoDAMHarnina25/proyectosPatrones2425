package banco02.problema.account;

public class CreatorCuentaOro implements AbstractAccountCreator{

	@Override
	public AbstractProductAccount factoryMethod() {
		return new CuentaOro(5f) ;
	}

}
