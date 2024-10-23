package ejercicio01;

import java.util.Random;

public class Cuenta {
	private String numero;
	private float saldo;
	public Cuenta(String numero) {
		super();
		this.numero = numero;
		this.saldo=new Random().nextInt(100000);
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getNumero() {
		return numero;
	}
	@Override
	public String toString() {
		return super.toString()+numero;
	}
}
