package easy;

public class ClienteResponse {
	private String nombre;
	private float saldo;
	public ClienteResponse(String nombre, float saldo) {
		super();
		this.nombre = nombre;
		this.saldo = saldo;
	}
	public String getNombre() {
		return nombre;
	}
	public float getSaldo() {
		return saldo;
	}
	@Override
	public String toString() {
		return nombre+" "+saldo;
	}
}
