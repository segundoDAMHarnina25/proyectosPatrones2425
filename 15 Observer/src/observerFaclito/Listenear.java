package observerFaclito;

public class Listenear {
	public static void main(String[] args) {
		Vigilante vigilante = new Vigilante();
		Espectador espectador = new Espectador();
		vigilante.addPropertyChangeListener(espectador);
		vigilante.setValue("Locaza");
		vigilante.setValue("nuevo valor");
	}
}