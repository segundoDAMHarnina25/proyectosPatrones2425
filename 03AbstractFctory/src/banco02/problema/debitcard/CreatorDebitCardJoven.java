package banco02.problema.debitcard;

public class CreatorDebitCardJoven implements AbstractDebitCardCreator{

	@Override
	public AbstractDebitCard factoryMethod() {
		return new DebitCardJoven(50f);
	}

}
