package ejemplo01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClon {

	@Test
	void testGrupo() {
		Grupo grupo=new Grupo("primero");
		try {
			Grupo clone = grupo.clone();
			assertFalse(grupo==clone);
			assertEquals(grupo.getMiREc(), clone.getMiREc());
//			assertFalse(grupo.getMiREc()==clone.getMiREc());
			int i = 56;
			clone.setMirecLado(i);
			assertFalse(grupo.getMiREc().getLado()==i);
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void test() {
		Rectangulo rectangulo=new Rectangulo(99);
		try {
			Rectangulo clon = rectangulo.clone();
			assertFalse(rectangulo==clon);
			assertEquals(rectangulo, clon);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
