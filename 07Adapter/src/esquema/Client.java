package esquema;

public class Client {

	ClientInterface adaptador;

	public Client(ClientInterface adaptador) {
		super();
		this.adaptador = adaptador;
	}
	
	public SpecialData setDataService(Data data) {
		return adaptador.method(data);
	}
	
}
