package modelo.data;

import java.util.List;

import modelo.enums.Dimensiones;
import modelo.oms.BarcosOM;
import modelo.oms.CardumenOM;
import modelo.oms.PuertosOM;

public class Mundo {
	Mar mar;
	List<Puerto> puertos;
	List<Cardumen> cardumenes;
	List<Barco> barcos;
	ServicioSatelite servicioSatelite;

	public Mundo() {
		super();
		mar = new Mar(Dimensiones.small.getDimension());
		int cantidadPuertos=5;
		puertos = PuertosOM.getAll(mar,cantidadPuertos);
		int cantidadCardumenes=2;
		cardumenes = CardumenOM.getAll(mar.getDimension(),cantidadCardumenes);
		mar.setCardumenes(cardumenes);
		int cantidadBarcos=20;
		barcos=BarcosOM.getAll(cantidadBarcos);
		setPuertos();
		servicioSatelite=ServicioSatelite.getInstance(mar);
	}

	private void createDiaPesca() {
		//arrancar los cardumenes
		//arrancar los barcos
		//si todos los barcos vuelven a puerto entonces pasamos al siguiente dia
	}
	
	private void setPuertos() {
		// TODO Auto-generated method stub
		//asociar un puerto a cada barco
	}

}
