package srcs.vehicules;
import srcs.vehicules.*;

public class AircraftFactory
{
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		type = type.toLowerCase();
		if (type.equals("baloon"))
		{
			return (new Baloon(name, new Coordinates(longitude, latitude, height)));
		}
		return (null);
	}
}
