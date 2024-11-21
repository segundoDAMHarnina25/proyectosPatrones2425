package model.company;

import model.market.Confidentiality;

public enum CompanyKnowledge {
	BASIC(Confidentiality.PUBLIC),
    MEDIUM(Confidentiality.INTERNAL),
    HIGH(Confidentiality.RESTRICTED),
    EXPERT(Confidentiality.SECRET);

    private final Confidentiality confidentiality;

    CompanyKnowledge(Confidentiality confidentiality) {
        this.confidentiality = confidentiality;
    }

    public Confidentiality getConfidentiality() {
        return confidentiality;
    }
}