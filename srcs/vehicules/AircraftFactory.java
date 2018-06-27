package srcs.vehicules;
import	srcs.vehicules.*;
import	srcs.exceptions.CustomException;

public class AircraftFactory
{
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws CustomException
	{
		type = type.toLowerCase();
		if (longitude < 0 || latitude < 0 || height < 0)
			throw new CustomException("Latitude, Longitude and Height must be Positive numbers.");
		if (height > 100)
			throw new CustomException("Height must be in the 0-100 range.");
		if (type.equals("baloon"))
		{
			return (new Baloon(name, new Coordinates(longitude, latitude, height)));
		}
		else if (type.equals("helicopter"))
		{
			return (new Helicopter(name, new Coordinates(longitude, latitude, height)));
		}
		else
		{
			return (new JetPlane(name, new Coordinates(longitude, latitude, height)));
		}
	}
}
