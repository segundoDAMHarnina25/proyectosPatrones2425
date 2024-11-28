package model.interfaces.actions;

import java.util.List;

import model.operation.Purchase;
import model.operation.Sale;

public interface BrokerActions {
 Sale findSaleTrade(Purchase compra);
}
