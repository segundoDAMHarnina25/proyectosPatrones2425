package modelo.data;

public class BarcoCientifico implements Actuable {
	Barco barco;
	MuestraCientifica muestraCientifica;
	
	public BarcoCientifico(Barco barco) {
		this.barco=barco;
	}

	@Override
	public void realizarTarea() {
		barco.realizarTarea();
		this.recogerMuestraCientifica(barco.getObjetivo().get());
	}

	private void recogerMuestraCientifica(Cardumen cardumen) {
		// TODO Auto-generated method stub
	}

	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}
	
	public Barco desmontarBarco() {
		return barco;
	}

}
