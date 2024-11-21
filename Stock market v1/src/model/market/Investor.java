package model.market;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Investor {
	private String id;
	private BigDecimal initialCapital;
	private BigDecimal avalaibleLiquid;
	private Map<Long,List<Share>> sharesByCompany; 
}
