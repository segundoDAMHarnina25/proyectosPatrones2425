package maze06.model.creators;

import maze06.model.products.Door;
import maze06.model.products.Side;

public class DoorCreator implements CreatorAbstract {

	@Override
	public Side factoryMethod() {
		return new Door();
	}

}
