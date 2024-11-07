package maze06.model;

import java.util.HashMap;
import java.util.Set;

import maze06.model.creators.DoorCreator;
import maze06.model.creators.ProductManager;
import maze06.model.products.Side;
import maze06.vista.RoomPresenter;

public class Room {
	private final int size = 4;
	private HashMap<Polar, Side> sides = new HashMap<>(size);
	private RoomPresenter roomPresenter;
	private Polar exitDoor;
	private Polar entranceDoor;
	
	public Room(Polar entranceDoor,RoomPresenter roomPresenter) {
		super();
		this.entranceDoor=entranceDoor;
		sides.put(entranceDoor, ProductManager.getProduct(new DoorCreator()));
		exitDoor=Polar.getRandomPolar(entranceDoor);
		sides.put(exitDoor, ProductManager.getProduct(new DoorCreator()));
		Polar sideOne=Polar.getRandomPolar(entranceDoor,exitDoor);
		sides.put(sideOne, ProductManager.getRandomProductNoDoor());
		Polar sideTwo=Polar.getRandomPolar(entranceDoor,exitDoor,sideOne);
		sides.put(sideTwo, ProductManager.getRandomProductNoDoor());
		this.roomPresenter=roomPresenter;
	}

	public void explore() {
		roomPresenter.introduceRoom(this);
	}
	public Polar getExitDoor() {
		return exitDoor;
	}
	public Polar getEntranceDoor() {
		return entranceDoor;
	}

	public Side getSide(Polar polar) {
		return sides.get(polar);
	}

	
}
