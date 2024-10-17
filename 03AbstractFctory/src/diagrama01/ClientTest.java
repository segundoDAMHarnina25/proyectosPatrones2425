package diagrama01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {

	@Test
	void test() {
		AbstractFactory miAbstractFactory;
		//cliente elige una factoria concreta
		miAbstractFactory=new ConcreteFactoryOne();
		//con la misma factoria tiene multiples productos de la misma familia
		AbstractProductA createProductA = miAbstractFactory.createProductA();
		AbstractProductB createProductB = miAbstractFactory.createProductB();
	}

}
