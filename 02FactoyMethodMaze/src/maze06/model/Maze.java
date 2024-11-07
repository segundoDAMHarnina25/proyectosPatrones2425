package maze06.model;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Set;

import maze06.vista.RoomPresenter;

public class Maze {
	private int amountOfRooms=2;
	private LinkedList<Room> rooms;
	private Polar initialPolarEnum;
	private RoomPresenter roomPresenter;
	
	public Maze(int amountOfRooms,RoomPresenter roomPresenter) {
		super();
		this.amountOfRooms = amountOfRooms;
		this.roomPresenter=roomPresenter;
		rooms=new LinkedList<>();
		initialPolarEnum=Polar.getRandomPolar();
		createMaze(initialPolarEnum);
	}

	private void createMaze(Polar currentPolarEnum) {
		for (int i = 0; i < amountOfRooms; i++) {
			Room currentRoom = new Room(currentPolarEnum,roomPresenter);
			currentPolarEnum=Polar.getOppositePolar(currentRoom.getExitDoor());
			rooms.add(currentRoom);
		}
	}

	public Maze(RoomPresenter roomPresenter) {
		this(2,roomPresenter);
	}
	
	public Polar getInitialPolarEnum() {
		return initialPolarEnum;
	}

	private void setInitialPolarEnum(Polar initialPolarEnum) {
		this.initialPolarEnum = initialPolarEnum;
	}

	public Room enteringMaze() {
		return rooms.get(0);
	}

	public Optional<Room> enteringNextRoom(Room room) {
		return Optional.ofNullable(rooms.get(rooms.indexOf(room)+1));
	}
	
}
