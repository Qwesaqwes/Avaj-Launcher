package srcs.vehicules;
import	srcs.vehicules.Aircraft;
import	srcs.vehicules.Flyable;
import	srcs.weather.WeatherTower;
import	srcs.Logger;

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
		//need to write in the file the registration for the ballon
		this.weatherTower = weatherTower;
		System.out.println("a");
		Logger.GetFileToWrite().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
		System.out.println("B");
	}
}
