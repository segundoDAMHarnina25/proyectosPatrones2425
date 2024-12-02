package solucion01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testClon1 {

	@Test
	void test() {
		Persona persona=new Persona();
		persona.id=1;
		persona.nombre="Enriquito";
		Contrato contrato=new Contrato();
		contrato.id=123;
		contrato.empresa="telefonica";
		contrato.persona=persona;
		Contrato clon = contrato.clon();
		System.out.println();
		persona.nombre="arturo";
		System.out.println(clon.persona.nombre);
		contrato.empresa="movistar";
		System.out.println(clon.empresa);
		
	}

}
