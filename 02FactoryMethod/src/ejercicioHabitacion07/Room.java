package ejercicioHabitacion07;

import java.util.HashMap;

public class Room {
	private final int size = 4;
	private HashMap<PolarEnum, Side> sides = new HashMap<>();
	private PolarEnum entranceDoor;
	private PolarEnum exitDoor;
	
	public Room(PolarEnum entranceDoor) {
		super();
		this.entranceDoor = entranceDoor;
		//seleccionar la puerta de salida
		//seleccionar el resto de paredes
	}
	
	
}
