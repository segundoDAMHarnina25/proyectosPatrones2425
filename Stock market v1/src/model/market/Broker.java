package model.market;

import model.interfaces.actions.BrokerActions;
import model.operation.Purchase;
import model.operation.Sale;

public class Broker implements BrokerActions {
	private Long id;
	Market market;
	
	@Override
	public Sale findSaleTrade(Purchase compra) {
		//Analizando el purchase
		//busca entre las Sales del market la adecuada
		//cuando la encuentra. le asigna las shares al comprador
		//y el capital al vendedor y se lo resta al comprador
		//da por cerradas las ordenes de compra y venta.
		//TODO
		return null;
		
	}
}
