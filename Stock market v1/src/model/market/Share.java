package model.market;

import java.math.BigDecimal;

public class Share {
	private Long id;
	private String id_Company;
	//Se usa para especificar con exactitud valores con decimales
	private BigDecimal percentageCapital;
	private BigDecimal currentValue;
	private Long getId() {
		return id;
	}
	private String getId_Company() {
		return id_Company;
	}
	private BigDecimal getPercentageCapital() {
		return percentageCapital;
	}
	BigDecimal getCurrentValue() {
		return currentValue;
	}
	
}
