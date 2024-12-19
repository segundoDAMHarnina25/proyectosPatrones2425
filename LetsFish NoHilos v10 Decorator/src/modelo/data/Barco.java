// Clase abstracta Barco
package modelo.data;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import modelo.enums.EspeciePez;
import modelo.enums.TipoBarco;

public class Barco implements Pesquero, PropertyChangeListener, Actuable{
	protected String nombre;
	public Coordenada posicionActual;
	protected Puerto puertoBase;
	protected int capacidad;
	private int pescaActual = 0;
	protected Optional<Cardumen> objetivo;
	protected int velocidad;
	private ServicioSatelite servicioSatélite;
	private TipoBarco tipo;
	private Mar mar;
	private boolean pescando;
	
	public Barco(String nombre, Coordenada posicionActual, Puerto puertoBase, int capacidad, int velocidad,
			ServicioSatelite servicioSatélite, TipoBarco tipoBarco,Mar mar) {
		super();
		this.nombre = nombre;
		this.puertoBase = puertoBase;
		this.capacidad = capacidad;
		this.posicionActual = posicionActual;
		this.velocidad = velocidad;
		this.servicioSatélite = servicioSatélite;
		this.tipo = tipoBarco;
		this.mar=mar;
		this.pescando=false;
	}

	public TipoBarco getTipo() {
		return tipo;
	}

	private boolean isSuitableBoat(Cardumen cardumen) {
		return cardumen.isSuitable(getTipo());
	}

	@Override
	public void decidirCardumen(List<Cardumen> cardumenes) {
		objetivo = cardumenes.stream().filter(this::isSuitableBoat)
				.filter(c -> c.getPeso() > capacidad * (1 - c.getFactorBiologico()))
				.min(Comparator.comparingDouble(c -> posicionActual.distanciaA(servicioSatélite.getPosicion(c))));
	}

	public Optional<Cardumen> getObjetivo() {
		return objetivo;
	}

	@Override
	public void moverse() {
		Cardumen cardumen = objetivo.get();
		posicionActual.avanzarHacia(servicioSatélite.getPosicion(cardumen), velocidad);
	}

	@Override
	public void realizarTarea() {
		this.pescando=true;
		Cardumen cardumen = objetivo.get();
		pescaActual = 0;
		while (pescaActual < capacidad && !cardumen.isLimiteAlcanzado()&&pescando) {
			cardumen.setEnPesca(true);
			pescaActual += cardumen.pescar();
		}
		cardumen.setEnPesca(false);
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getPescaActual() {
		return pescaActual;
	}

	@Override
	public void regresarAPuerto() {
		posicionActual = puertoBase.getSitio();
		puertoBase.compraPescado(new InfoPesca(objetivo.get().getEspecie(),pescaActual,this,mar.getToday()));
	}
	
	public boolean isInPort() {
		return puertoBase.getSitio().equals(posicionActual);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(((EspeciePez)evt.getNewValue()).equals(objetivo.get().getEspecie())) {
			pescando=false;
			this.pescaActual=0;
		}
	}

	@Override
	public Barco desmontarBarco() {
		return this;
	}

}