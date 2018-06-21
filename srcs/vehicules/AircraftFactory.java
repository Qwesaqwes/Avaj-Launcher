package srcs.vehicules;
import srcs.vehicules.Flyable;

public class AircraftFactory implements Flyable
{
	public Flyable Aircraft =  new Aircraft(String type, String name, int longitude, int latitude, int height);
}
