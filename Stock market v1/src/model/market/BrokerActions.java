package model.market;

import java.util.List;

import model.operation.Purchase;
import model.operation.Sale;

public interface BrokerActions {
 void findSaleTrade(Purchase compra, List<Sale> ventas);
}
