package ejemplo01;

public class Rectangulo implements Cloneable  {
	private int lado;

	public Rectangulo() {
		super();
	}

	public Rectangulo(Rectangulo rectangulo) {
		this.lado=rectangulo.lado;
	}
	public Rectangulo(int lado) {
		super();
		this.lado = lado;
	}

	@Override
	protected Rectangulo clone() throws CloneNotSupportedException {
		return new Rectangulo(this);
	}
	
	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lado;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		if (lado != other.lado)
			return false;
		return true;
	}

}
