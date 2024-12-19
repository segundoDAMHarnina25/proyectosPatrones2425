// Clase Cardumen
package modelo.data;

import java.awt.Dimension;

import javax.swing.text.Utilities;

import modelo.enums.EspeciePez;
import modelo.enums.TipoBarco;

public class Cardumen {
	private EspeciePez especie;
	private Coordenada posicion;
	private int peso;
	private double factorBiologico;
	private int pesoInicial;
	private double velocidadRegeneracion;
	private int velocidadMovimiento;
	private boolean enPesca;
	private Dimension dimension;

	private Cardumen(Builder builder) {
		this.especie=builder.especie;
		this.posicion=builder.posicion;
		this.peso=builder.pesoInicial;
		this.factorBiologico=builder.factorBiologico;
		this.pesoInicial=builder.pesoInicial;
		this.velocidadRegeneracion=builder.velocidadRegeneracion;
		this.velocidadMovimiento=builder.velocidadMovimiento;
		this.enPesca=builder.enPesca;
		this.dimension=builder.dimension;
	}

	public EspeciePez getEspecie() {
		return especie;
	}

	public synchronized void moverEnMapa() {
		if (!enPesca) {
			this.posicion.setRandomDelta(velocidadMovimiento, dimension.width, dimension.height);
		}
	}

	public synchronized Coordenada getPosicion() {
		return posicion;
	}

	public void regenerar() {
		if (peso < pesoInicial) {
			peso += velocidadRegeneracion;
		}
	}

	public boolean isSuitable(TipoBarco tipo) {
		return especie.isSuitable(tipo);
	}

	public double getPeso() {
		return peso;
	}

	public double getPesoInicial() {
		return pesoInicial;
	}

	public synchronized int pescar() {
		int cantidad = 1;
		if (!isLimiteAlcanzado()) {
			peso -= cantidad;
			return cantidad;
		}
		return 0;
	}

	public boolean isLimiteAlcanzado() {
		return peso <= pesoInicial * factorBiologico;
	}

	public double getFactorBiologico() {
		return factorBiologico;
	}

	public boolean isEnPesca() {
		return enPesca;
	}

	public void setEnPesca(boolean enPesca) {
		this.enPesca = enPesca;
	}

	public static class Builder {
		private EspeciePez especie;
		private Coordenada posicion;
		private int peso;
		private double factorBiologico;
		private int pesoInicial;
		private double velocidadRegeneracion;
		private int velocidadMovimiento;
		private boolean enPesca;
		private Dimension dimension;
		
		public Builder(EspeciePez especie, int peso, Dimension dimension) {
			super();
			this.especie = especie;
			this.peso = peso;
			this.pesoInicial=peso;
			this.dimension = dimension;
			this.velocidadRegeneracion=2;
			this.factorBiologico=.25;
			this.velocidadMovimiento=1;
			this.enPesca=false;
			//TODO posicion aleatoria
		}
		public Builder posicion(Coordenada posicion) {
			this.posicion=posicion;
			return this;
		}
		public Builder factorBiologico(double factor) {
			this.factorBiologico=factor;
			return this;
		}
		public Builder velocidadRegeneracion(double velocidad) {
			this.velocidadRegeneracion=velocidad;
			return this;
		}
		public Cardumen build() {
			Cardumen cardumen=new Cardumen(this);
			return cardumen;
		}
	}
}
