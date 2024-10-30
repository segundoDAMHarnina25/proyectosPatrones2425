package ejercicio01Problema;

public class Client {
	ServiceableBBDD servicioBBDD;

	public Client(ServiceableBBDD servicioBBDD) {
		super();
		this.servicioBBDD = servicioBBDD;
		System.out.println("arrancando el servicio de bbdd");
	}

	public void operarEnOtroSitio() {
		System.out.println("no tiene que ver con la bbdd");
	}
	
	public void operarEnBBDD() {
		System.out.println("operando en base ");
		servicioBBDD.operation();
	}
}
