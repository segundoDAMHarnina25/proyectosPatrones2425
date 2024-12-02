package solucion01;

public class Persona implements Clonable<Persona>{
	int id;
	String nombre;
	
	@Override
	public Persona clon() {
		Persona cllon=new Persona();
		cllon.id=this.id;
		cllon.nombre=this.nombre;
		return cllon;
	}
}
