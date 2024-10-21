package teoria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class ClienteTest {

	@Ignore
	void testUseClon() {
		new Cliente().useClon(new ConcretePrototypeOneSub());
	}

	@Test
	void testClonar() {
		ConcretePrototypeOne concretePrototypeOne = new ConcretePrototypeOne();
		concretePrototypeOne.fieldOne=99;
		Prototype clonar = concretePrototypeOne.clonar();
		assertNotEquals(concretePrototypeOne , clonar);
		assertEquals(concretePrototypeOne.fieldOne, ((ConcretePrototypeOne) clonar).fieldOne);
	}
	
}
