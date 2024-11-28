package model.company;

import java.math.BigDecimal;

import model.interfaces.actions.CompanyActions;
import model.operation.Sale;
import model.operation.Seller;

public class Company implements CompanyActions,Seller {
	private Long id;
	private Long initialValueBeforeStocks;
	private Sector productiveSector;
	
	@Override
	public Sale sellAllShares() {
		return null;
	}

	@Override
	public BigDecimal getCapitalAfterTrade() {
		return new BigDecimal(initialValueBeforeStocks);
	}

}
