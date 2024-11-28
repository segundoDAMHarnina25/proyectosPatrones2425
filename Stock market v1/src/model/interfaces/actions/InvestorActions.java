package model.interfaces.actions;

import model.market.NewInfo;
import model.operation.Purchase;

public interface InvestorActions {
	//Si sale una orden de compra 
	//no tiene sentido que reciba una noticia
	//que pueda ser mala.
	//debe recibir informacion de la newInfo 
	//pero la newinfo debe ser positiva
	void compraSimple(NewInfo info);
}
