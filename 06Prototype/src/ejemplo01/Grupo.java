package ejemplo01;

import java.util.Objects;

public class Grupo implements Cloneable{
	private Rectangulo miREc = new Rectangulo(0);
	private String nombre;
	private Circulo circulo=new Circulo(99);
	
	public Grupo(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	private Grupo(Grupo grupo) throws CloneNotSupportedException {
		this.nombre=new String(grupo.nombre);
		this.miREc=grupo.getMiREc().clone();
		this.circulo=grupo.getCirculo().clone();
	}

	@Override
	protected Grupo clone() throws CloneNotSupportedException {
		Grupo grupo = new Grupo(this);
		return grupo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(circulo, miREc, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(circulo, other.circulo) && Objects.equals(miREc, other.miREc)
				&& Objects.equals(nombre, other.nombre);
	}
	public Rectangulo getMiREc() {
		return miREc;
	}
	public void setMiREc(Rectangulo miREc) {
		this.miREc = miREc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Circulo getCirculo() {
		return circulo;
	}
	public void setCirculo(Circulo circulo) {
		this.circulo = circulo;
	}

	public void setMirecLado(int i) {
		this.miREc.setLado(i);
		
	}
	
}
