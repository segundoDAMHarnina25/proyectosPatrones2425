package ejemploPersonaje;

public class Fuerza extends Caracteristica {

	public Fuerza(Personaje aldeano) {
		super(aldeano);
	}

	@Override
	public int mostrarArmadura() {
		return this.personaje.mostrarArmadura();
	}

	@Override
	public int mostrarFuerza() {
		return this.personaje.mostrarFuerza() + 150;
	}

}
