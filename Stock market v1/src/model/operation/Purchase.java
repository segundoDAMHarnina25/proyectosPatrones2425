package model.operation;

import java.math.BigDecimal;

import model.market.Investor;

public class Purchase extends Trade {
	private BigDecimal amount;
	private Investor investor;
	//////////////constructor
	//////////////propios
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		
	}
	///////////////de objeto
	public BigDecimal getAmount() {
		return amount;
	}
	private Investor getInvestor() {
		return investor;
	}
	
	
}
