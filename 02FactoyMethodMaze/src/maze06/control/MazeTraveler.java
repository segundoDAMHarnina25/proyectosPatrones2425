package maze06.control;

import maze06.model.Maze;
import maze06.model.Room;

public class MazeTraveler {

	public void travel(Maze maze) {

		Room room;
		room = maze.enteringMaze();
		do {
			room.explore();
			room = maze.enteringNextRoom(room).orElse(null);
		} while (room != null);
	}

	
}
