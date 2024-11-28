package model.market;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import model.company.Company;
import model.interfaces.actions.InvestorActions;
import model.operation.Purchase;
import model.operation.Seller;

public class Investor implements InvestorActions,Seller {
	private String id;
	private BigDecimal initialCapital;
	private BigDecimal avalaibleLiquid;
	private Map<Company, List<Share>> sharesByCompany;
	private Broker broker;
	//////////////contructores/////////////////////////////
	////////////////////metodos propios///////////////
	@Override
	public void compraSimple(NewInfo info) {
		// TODO La info para una simple necesita de una empresa
		// de alguna manera debo saber cuanto quiero/puedo comprar
		// con una logica que no conozco
		broker.findSaleTrade(new Purchase());
	}
	public BigDecimal getCapitalSharesByCompany(Company company) {
		sharesByCompany.get(company).stream()
		.map(share->{return share.getCurrentValue();})
		.reduce(BigDecimal.ZERO,BigDecimal::add);
		return BigDecimal.ZERO;
	}
	@Override
	public BigDecimal getCapitalAfterTrade() {
		return avalaibleLiquid;
	}
	
	////////////////metodos del objeto/////////////////////////////
	private String getId() {
		return id;
	}
	private BigDecimal getInitialCapital() {
		return initialCapital;
	}
	public BigDecimal getAvalaibleLiquid() {
		return avalaibleLiquid;
	}
	private Map<Company, List<Share>> getSharesByCompany() {
		return sharesByCompany;
	}
	private Broker getBroker() {
		return broker;
	}

	
}
