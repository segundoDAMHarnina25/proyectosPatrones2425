package maze06.Test;

import org.junit.jupiter.api.Test;

import maze06.control.MazeTraveler;
import maze06.model.Maze;
import maze06.vista.RoomPresenterConsole;

class Roomtest {

	@Test
	void test() {
		Maze maze=new Maze(4,new RoomPresenterConsole());
		MazeTraveler traveler=new MazeTraveler();
		traveler.travel(maze);
	}

}
