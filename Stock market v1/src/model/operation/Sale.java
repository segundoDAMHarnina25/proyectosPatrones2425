package model.operation;

import java.util.List;
import java.util.Optional;

import model.market.Share;

public class Sale extends Trade {
	private List<Share> shares;
	private Seller seller;
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		
	}
	public List<Share> getShares() {
		return shares;
	}
	public Seller getSeller() {
		return seller;
	}

}
