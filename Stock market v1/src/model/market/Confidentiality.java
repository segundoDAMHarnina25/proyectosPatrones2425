package model.market;

import model.company.CompanyKnowledge;

public enum Confidentiality {
	   PUBLIC(CompanyKnowledge.BASIC),
	    INTERNAL(CompanyKnowledge.MEDIUM),
	    RESTRICTED(CompanyKnowledge.HIGH),
	    SECRET(CompanyKnowledge.EXPERT);

	    private final CompanyKnowledge companyKnowledge;

	    Confidentiality(CompanyKnowledge companyKnowledge) {
	        this.companyKnowledge = companyKnowledge;
	    }

	    public CompanyKnowledge getCompanyKnowledge() {
	        return companyKnowledge;
	    }
	}