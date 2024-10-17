package diagrama01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {

	@Test
	void test() {
		AbstractFactory miAbstractFactory;
		//cliente elige una concreta
		miAbstractFactory=new ConcreteFactoryOne();
		AbstractProductA createProductA = miAbstractFactory.createProductA();
		AbstractProductB createProductB = miAbstractFactory.createProductB();
	}

}
