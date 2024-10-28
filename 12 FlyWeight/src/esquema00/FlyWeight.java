package esquema00;

public class FlyWeight {
	String repeating;
	
	public FlyWeight(String repeating) {
		super();
		this.repeating = repeating;
	}

	public void operation(String unique) {
		System.out.println(repeating+" "+unique);
	}

	public boolean contains(String repeating) {
		return repeating.equals(this.repeating);
	}
}
