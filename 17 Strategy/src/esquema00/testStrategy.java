package esquema00;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testStrategy {

	@Test
	void test() {
		Context context=new Context(new Data());
		context.setStrategy(new ConcreteStrategyA());
		context.doThis();
		context.setStrategy(new ConcreteStrategyB());
		context.doThis();
	}

}
