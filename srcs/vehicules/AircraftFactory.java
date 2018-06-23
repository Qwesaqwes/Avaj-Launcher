package srcs.vehicules;
import srcs.vehicules.*;

public class AircraftFactory
{
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		type = type.toLowerCase();
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (type == "baloon")
		{
			return (new Baloon(name, coordinates));
		}
		return (null);
	}
}
