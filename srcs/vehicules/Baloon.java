package srcs.vehicules;
// import	srcs.vehicules.Aircraft;
// import	srcs.vehicules.Flyable;
// import	srcs.vehicules.Coordinates;
import	srcs.weather.WeatherTower;
import	srcs.weather.Logger;

public class Baloon extends Aircraft implements Flyable
{
	private	WeatherTower	weatherTower;

	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		String weather = weatherTower.getWeather(coordinates);
		if (weather.equals("SUN"))
		{
			coordinates.setLongitude(coordinates.getLongitude() + 2);
			coordinates.setHeight(coordinates.getHeight() + 4);
			if (coordinates.getHeight() > 100)
				coordinates.setHeight(100);
			System.out.println("Baloon#" + this.name + "(" + this.id + "): What a Nice day!\n");
		}
		else if (weather.equals("RAIN"))
		{
			coordinates.setHeight(coordinates.getHeight() - 5);
		}
		else if (weather.equals("FOG"))
		{
			coordinates.setHeight(coordinates.getHeight() - 3);
		}
		else
		{
			coordinates.setHeight(coordinates.getHeight() - 15);
		}
		
		if (coordinates.getHeight() <= 0)
		{

		}
		
	}

	public void registerTower(WeatherTower weatherTower)
	{
		//need to write in the file the registration for the ballon
		this.weatherTower = weatherTower;
		Logger.GetFileToWrite().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.\n");
		this.weatherTower.register(this);
	}
}
