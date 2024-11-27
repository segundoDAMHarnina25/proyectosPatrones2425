package model.operation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import model.company.Company;
import model.market.Broker;
import model.market.Share;

public abstract class Trade {
	private Long id;
	private Company companyId;
	private boolean completed;
	private Broker broker;
	private Optional<List<Share>> shares;
	
	public abstract void operate();
}
