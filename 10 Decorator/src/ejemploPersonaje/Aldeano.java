package ejemploPersonaje;

public class Aldeano implements Personaje {

	public int mostrarArmadura() {
		return 0;

	}

	public Personaje decrementaElemento() {
		return this;
	}

	public int mostrarFuerza() {

		return 0;
	}

	public Personaje degradaTotal() {
		return this;
	}

}
