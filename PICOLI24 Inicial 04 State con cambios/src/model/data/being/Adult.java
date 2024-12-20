package model.data.being;

public class Adult implements Behaviour{
	private long savings;
	private boolean active;
	private Being being;

	public Adult(Being being) {
		savings=0;
		active=false;
		this.being=being;
	}

	// Esto solo los adultos
	// nv 100
	// ahorros 10
	// sueldo 80
	public void feed(int amount) {
		int total = 0;
		if (being.getCurrentAge() < being.ancientAge) {
			// sueldo es la cantidad
			int resto = amount - being.getVitalNecesity();
			// resto sera -20
			this.savings += resto;
			// ahorros -10
			if (savings < 0) {
				total = (int) (being.getVitalNecesity() - savings);
				this.savings = 0;
			}
		} else {
			total = amount;
		}
		being.recalculateLifeExpectancy(total);
	}

	@Override
	public boolean live(int salary) {
		this.feed(salary);
		return being.aging();
	}

	@Override
	public Behaviour check() {
		if(being.isAncientAge()) return new Ancient(being);
		return this;
	}

}
