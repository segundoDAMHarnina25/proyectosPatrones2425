package model.operation;

import model.company.Company;

public abstract class Trade {
	private Long id;
	private Company companySource;
	private boolean completed;
	private boolean closed;
	////////////construtores
	//////////propios
	public abstract void operate();
	/////////////objeto
	private Long getId() {
		return id;
	}

	public Company getCompany() {
		return companySource;
	}

	private boolean isCompleted() {
		return completed;
	}
	public boolean isClosed() {
		return closed;
	}
	
}
