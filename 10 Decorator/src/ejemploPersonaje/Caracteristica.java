package ejemploPersonaje;

public abstract class Caracteristica implements Personaje {
	Personaje personaje;
	
	public Caracteristica(Personaje personaje) {
		super();
		this.personaje = personaje;
	}

	public Personaje degradaTotal() {
		return personaje.degradaTotal();
	}

}
