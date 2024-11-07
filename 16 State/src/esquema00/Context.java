package esquema00;

public class Context implements State {
	public State state;

	public Context(State state) {
		super();
		this.state = state;
	}

	public void changeState(State state) {
		this.state = state;
	}

	@Override
	public void doThis() {
		state.doThis();
	}

	@Override
	public void doThat() {
		state.doThat();
	}

}
