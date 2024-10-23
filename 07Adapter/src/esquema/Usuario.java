package esquema;


public class Usuario {
	public static void main(String[] args) {
		Client cliente=new Client(new Adapter(new Service()));
		Data data=new Data();
		data.aString="16";
		SpecialData setDataService = cliente.setDataService(data);
		System.out.println(setDataService.integer);
	}
}
