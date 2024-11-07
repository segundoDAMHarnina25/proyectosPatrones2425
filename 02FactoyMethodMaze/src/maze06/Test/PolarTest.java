package maze06.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import maze06.model.Polar;

class PolarTest {

	@Test
	void testGetOppositePolar() {
		assertEquals(Polar.North,Polar.getOppositePolar(Polar.South));
		assertEquals(Polar.South,Polar.getOppositePolar(Polar.North));
		assertEquals(Polar.East,Polar.getOppositePolar(Polar.West));
		assertEquals(Polar.West,Polar.getOppositePolar(Polar.East));
	}

}
