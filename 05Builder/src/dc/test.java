package dc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		Director director=new Director(new ProductBuilder());
		director.construct();
		Product part = director.builder.buildPart();
	}

}
