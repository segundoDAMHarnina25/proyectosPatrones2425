package tienda01enum;

import java.util.function.Function;

public enum Descuento {
	sinDescuento((precio)->{return precio;}),
	fijo((precio)->{return precio-decuentofijo();}),
	porcentual((precio)->{return precio-descuentoX();}),
	temporada((precio)->{return precio-descuentoT();});
	public Function<Double,Double> aplicarDescuento;

	private Descuento(Function<Double,Double> aplicarDescuento) {
		this.aplicarDescuento = aplicarDescuento;
	}

	static double decuentofijo() {
		return 10;
	}
	static double descuentoT() {
		return 10;
	}

	static double  descuentoX() {
		return 10;
	}

	
	
}
