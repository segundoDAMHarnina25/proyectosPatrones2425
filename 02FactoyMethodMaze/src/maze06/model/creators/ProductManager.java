package maze06.model.creators;

import java.util.List;
import java.util.Random;

import maze06.model.products.Door;
import maze06.model.products.Side;
import maze06.model.products.Wall;
import maze06.model.products.Window;

public class ProductManager {
	public static Side getProduct(CreatorAbstract creator) {
		return creator.factoryMethod();
	}

	public static Side getRandomProductNoDoor() {
		List<Side> lista = List.of(new Wall(),new Window());
		return lista.get(new Random().nextInt(lista.size()));
	}
}
