package esquema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Client {

	@Test
	void test() {
		Command copy=new CopyCommand("editor");
		Invoker button=new Invoker();
		button.setCommand(copy);
		button.executeCommand();
		//cambiando
		Receiver receiver=new Receiver();
		copy=new CommandOne(receiver,"commandOne");
		button.setCommand(copy);
		button.executeCommand();
	}

}
