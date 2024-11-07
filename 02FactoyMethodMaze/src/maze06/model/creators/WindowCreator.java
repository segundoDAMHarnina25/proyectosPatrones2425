package maze06.model.creators;

import maze06.model.products.Side;
import maze06.model.products.Window;

public class WindowCreator implements CreatorAbstract{

	@Override
	public Side factoryMethod() {
		return new Window();
	}

}
