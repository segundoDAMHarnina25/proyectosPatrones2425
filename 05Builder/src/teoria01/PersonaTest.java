package teoria01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test
	void test() {
		Persona persona=
				new Persona.Builder(1, "jaime", "ros").color("verde").build();
		persona=
				new Persona.Builder(1, "jaime", "ros").build();
				
	}

}
