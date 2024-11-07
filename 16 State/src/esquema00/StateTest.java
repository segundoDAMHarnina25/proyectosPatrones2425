package esquema00;
import org.junit.jupiter.api.Test;

class StateTest {

	@Test
	void test() {
		State initialState=new ConcreteStateA();
		Context context=new Context(initialState);
		context.doThis();
		ConcreteStateB concreteStateB = new ConcreteStateB();
		concreteStateB.setContext(context);
		context.changeState(concreteStateB);
		context.doThis();
	}

}
