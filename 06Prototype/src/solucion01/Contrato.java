package solucion01;

public class Contrato implements Clonable<Contrato> {
	 int id;
	 String empresa;
	 Persona persona;
	
	@Override
	public Contrato clon() {
		Contrato contrato=new Contrato();
		contrato.id=this.id;
		contrato.empresa=this.empresa;
		contrato.persona=this.persona.clon();
		return contrato;
	}
}
