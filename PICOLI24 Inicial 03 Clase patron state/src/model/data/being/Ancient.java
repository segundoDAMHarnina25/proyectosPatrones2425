package model.data.being;

public class Ancient implements Behavior {
	
	private Being being;
	

	public Ancient(Being being) {
		super();
		this.being = being;
	}


	@Override
	public boolean live(int salary) {
		being.feed(salary);
		return being.aging();
	}


	@Override
	public Behavior check() {
		return this;
	}
}
