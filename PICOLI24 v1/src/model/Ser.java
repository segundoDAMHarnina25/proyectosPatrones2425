package model;

import utiles.Utiles;

public class Ser {
	private static final int vidaMax = 120;
	private static final int vidaMin = 0;
	private static final int edadAdulto = 18;
	protected static final int edadAnciano = 65;

	protected float esperanzaVida;
	protected int edad = 0;
	protected int necesidadVital = 100;

	public Ser(float esperanzaVida) {
		super();
		this.esperanzaVida = esperanzaVida;
	}

	public Ser() {
		super();
		esperanzaVida = calculaEsperanzaVida(vidaMin, vidaMax);
	}

	public Ser(Ser ser) {
		this.edad = ser.edad;
		this.esperanzaVida = ser.esperanzaVida;
		this.necesidadVital = ser.necesidadVital;
	}

	public float getEsperanzaVida() {
		return esperanzaVida;
	}

	public void setEsperanzaVida(float esperanzaVida) {
		this.esperanzaVida = esperanzaVida;
	}

	private int calculaEsperanzaVida(int minimo, int maximo) {
		return Utiles.dameNumero(maximo);
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	private boolean envejecer() {
		if (isAlive())
			this.edad++;
		// TODO tengo que ver si un menor pasa a ser adulto o no
		// y para que pase de adulto a anciano
		return isAlive();
	}

	public boolean isAlive() {
		return this.edad <= this.esperanzaVida;
	}

	public boolean vivir(int sueldo) {
		this.alimentar(sueldo);
		return this.envejecer();
	}

	protected void recalcularEsperanzaDeVida(int sueldo) {
		float porcentaje = sueldo * 100 / this.necesidadVital;
		float porcenMax = 99;
		float porcenMin = 33;
		float periodoMin = 1f;
		if (porcentaje <= porcenMax && porcentaje >= porcenMin) {
			this.esperanzaVida -= periodoMin;
		} else if (porcentaje <= porcenMin) {
			float periodoMax = 2f;
			this.esperanzaVida -= periodoMax;
		}
	}

	private void alimentar(int sueldo) {
		recalcularEsperanzaDeVida(sueldo);
	}

	public boolean pasaAAnciano() {
		return isAlive() && edad == 65;
	}

	public boolean pasaAAdulto() {
		return isAlive() && edad == 18;
	}

	public int getNecesidadVital() {
		return necesidadVital;
	}
}
