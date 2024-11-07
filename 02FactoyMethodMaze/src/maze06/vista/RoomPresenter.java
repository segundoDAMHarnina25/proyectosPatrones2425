package maze06.vista;

import maze06.model.Polar;
import maze06.model.Room;
import maze06.model.products.Side;

public interface RoomPresenter {
	public void introduceSide(Polar polarEnum,Side side);

	public void introduceRoom(Room room);
}
