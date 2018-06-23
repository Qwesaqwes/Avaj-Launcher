package srcs.vehicules;
import	srcs.vehicules.Aircraft;
import	srcs.vehicules.Flyable;
import	srcs.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable
{
	private		WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		//do stuff
	}

	public void registerTower(WeatherTower weatherTower)
	{
		//do stuff
	}
}
