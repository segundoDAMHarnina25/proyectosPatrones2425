package dc;

public class Director {
	public Builder builder;

	public Director(Builder builder) {
		super();
		this.builder = builder;
	}
	
	public void construct() {
		this.builder.buildPart();
	}
	
}
