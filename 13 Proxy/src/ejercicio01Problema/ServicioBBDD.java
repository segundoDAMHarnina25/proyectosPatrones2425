package ejercicio01Problema;

public class ServicioBBDD implements ServiceableBBDD {

	public ServicioBBDD() {
		super();
		System.out.println("empezando a arrancar");
		//Tarda un monton en arrancar
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("terminando de arrancar");
	}
	@Override
	public void operation() {
		System.out.println("operado en la bbdd");
	}
}
