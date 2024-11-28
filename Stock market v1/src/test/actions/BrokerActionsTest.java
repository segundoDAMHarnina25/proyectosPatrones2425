package test.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.interfaces.actions.BrokerActions;
import model.market.Broker;
import model.market.Investor;
import model.market.Market;
import model.operation.Purchase;
import model.operation.Sale;

class BrokerActionsTest {
	
	Market market;
	BrokerActions broker;
	Purchase purchase;
	Investor investor;
	
	@BeforeEach
	void before() {
		market=new Market();
		broker=new Broker();
		purchase=new Purchase();
		investor=new Investor();
	}

	@Test
	void testFindSaleTrade() {
		BigDecimal avalaibleLiquidBeforeTrade = investor.getAvalaibleLiquid();
		BigDecimal capitalInCompanyBeforeTrade=investor.getCapitalSharesByCompany(purchase.getCompany());
		Sale saleTrade = broker.findSaleTrade(purchase);
		assertTrue(purchase.isClosed());
		//TODO Es probable que haya un delta, es decir, que no se compre
		// tanto como queriamos (que coincida exactamente no se como se hace)
		assertEquals(avalaibleLiquidBeforeTrade,investor.getAvalaibleLiquid().add(purchase.getAmount()));
		assertEquals(capitalInCompanyBeforeTrade,
				investor.getCapitalSharesByCompany(purchase.getCompany()).subtract(purchase.getAmount()));
		BigDecimal capitalAfterTrade = saleTrade.getSeller().getCapitalAfterTrade();
		assertTrue(saleTrade.getShares().size()==0);
	}

	@Test
	void testLoadSaleTrade() {
		fail("Not yet implemented");
	}

}
