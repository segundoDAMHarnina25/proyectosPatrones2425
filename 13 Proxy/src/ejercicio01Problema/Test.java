package ejercicio01Problema;

public class Test {
	public static void main(String[] args) {
//		ServicioBBDD servicioBBDD=new ServicioBBDD();
		ServiceBBDDProxy serviceBBDDProxy=new ServiceBBDDProxy();
		Client client = new Client(serviceBBDDProxy);
		Client client2 = new Client(serviceBBDDProxy);
		// hago muchas cosas
		client.operarEnOtroSitio();
		// y tardo mucho en comenzar a trabajar con la bbdd
		// igual ni siquiera lo hago
//		client.operarEnBBDD();
		//debemos crear un proxy
	}
}
