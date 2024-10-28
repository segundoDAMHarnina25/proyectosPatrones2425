package esquema00;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlyWeightFactoryTest {

	@Test
	void testFlyWeightFactory() {
		FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
		String repeting = "hola";
		FlyWeight flyWeight = flyWeightFactory.getFlyWeight(repeting);
		String repeting2 = new String(repeting);
		FlyWeight flyWeight2 = flyWeightFactory.getFlyWeight(repeting2);
	}

}
