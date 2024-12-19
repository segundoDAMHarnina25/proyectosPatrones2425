package modelo.enums;

public enum EspeciePez {
    ATUN(500,TipoBarco.PALANGRE,1000),     // Tamaño en kilogramos
    SARDINA(1,TipoBarco.CERCO,800),
    MERLUZA(3,TipoBarco.CERCO,700),
    BACALAO(15,TipoBarco.CERCO,500),
    PEZ_ESPADA(300,TipoBarco.PALANGRE,1200);

    private final int tamano; // Tamaño del pez en kilogramos
    private TipoBarco tipoBarco;
    private long maximaCantidadPorTipo;
   
    
	
    private EspeciePez(int tamano, TipoBarco tipoBarco, long maximaCantidadPorTipo) {
		this.tamano = tamano;
		this.tipoBarco = tipoBarco;
		this.maximaCantidadPorTipo = maximaCantidadPorTipo;
	}

	public int getTamano() {
        return tamano;
    }

    @Override
    public String toString() {
        return name() + " (Tamaño: " + tamano + " kg)";
    }

	public boolean isSuitable(TipoBarco tipo) {
		return this.tipoBarco.equals(tipo);
	}

	public TipoBarco getTipoBarco() {
		return tipoBarco;
	}

	public long getMaximaCantidadPorTipo() {
		return maximaCantidadPorTipo;
	}
}
