package ejemploPersonaje;

public class Golpe {
	int fuerza;

	public Golpe(int fuerza) {
		super();
		this.fuerza = fuerza;
	}

	public Personaje golpear(Personaje personaje) {
		int acumulado = 0;
		Personaje decrementaArmadura;
		int mostrarArmadura ;
		do {
			int mostrarArmadura2 = personaje.mostrarArmadura();
			personaje = personaje.decrementaArmadura();
			mostrarArmadura = personaje.mostrarArmadura();
			acumulado = mostrarArmadura2 - mostrarArmadura;
		} while (acumulado >= fuerza && mostrarArmadura < fuerza);
		return personaje;

	}
}
