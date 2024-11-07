package maze06.model.creators;

import maze06.model.products.Side;
import maze06.model.products.Wall;

public class WallCreator implements CreatorAbstract {

	@Override
	public Side factoryMethod() {
		return new Wall();
	}

}
