package ejemplo01;

import java.util.Objects;

public class Circulo implements Cloneable{
	private float radio;

	public Circulo(float radio) {
		super();
		this.radio = radio;
	}

	@Override
	protected Circulo clone() throws CloneNotSupportedException {
		return new Circulo(this);
	}
	public Circulo(Circulo circulo) {
		this.radio=circulo.radio;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(radio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		return Float.floatToIntBits(radio) == Float.floatToIntBits(other.radio);
	}
	
}
