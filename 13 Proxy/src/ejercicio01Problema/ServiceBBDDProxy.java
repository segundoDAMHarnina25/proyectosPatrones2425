package ejercicio01Problema;

public class ServiceBBDDProxy implements ServiceableBBDD{
	ServicioBBDD bbdd;
	
	
	
	public ServiceBBDDProxy(ServicioBBDD bbdd) {
		super();
		this.bbdd = bbdd;
	}
	
	public ServiceBBDDProxy() {
		super();
		
	}





	@Override
	public void operation() {
		if(bbdd==null) bbdd=new ServicioBBDD();
		bbdd.operation();
	}

}
