package banco02.problema.account;

public class CuentaJoven extends AbstractProductAccount {

	public CuentaJoven(float comission) {
		super(comission);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		System.out.println("soy una cuenta joven");

	}

}
