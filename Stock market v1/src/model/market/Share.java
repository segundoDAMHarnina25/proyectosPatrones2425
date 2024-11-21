package model.market;

import java.math.BigDecimal;

public class Share {
	private Long id;
	private String id_Company;
	//Se usa para especificar con exactitud valores con decimales
	private BigDecimal percentageCapital;
	private BigDecimal currentValue;
}
