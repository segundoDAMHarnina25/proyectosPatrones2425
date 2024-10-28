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

	@Override
	public Personaje decrementaArmadura() {
		Personaje decrementaArmadura = personaje.decrementaArmadura();
		if (personaje.getClass() != Armadura.class) {
			return this;
		}
		return decrementaArmadura;
	}
}
