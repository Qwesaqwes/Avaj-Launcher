package srcs.vehicules;
import	srcs.weather.WeatherTower;
import	srcs.weather.Logger;

public class Baloon extends Aircraft implements Flyable
{
	private	WeatherTower	weatherTower;
	private int 			Longitude;
	private	int 			Height;
	
	Baloon(String name, Coordinates coordinates)
	{
		super (name, coordinates);
	}

	public void updateConditions()
	{
		String weather = weatherTower.getWeather(coordinates);
		Longitude = coordinates.getLongitude();
		Height = coordinates.getHeight();
		if (weather.equals("SUN"))
		{
			coordinates.setLongitude(Longitude + 2);
			coordinates.setHeight(Height + 4);
			if (coordinates.getHeight() > 100)
				coordinates.setHeight(100);
			Logger.GetFileToWrite().writetofile("Baloon#" + this.name + "(" + this.id + "): What a Nice day!\n");
		}
		else if (weather.equals("RAIN"))
		{
			coordinates.setHeight(Height - 5);
			Logger.GetFileToWrite().writetofile("Baloon#" + this.name + "(" + this.id + "): Can Bees fly in the rain?\n");
		}
		else if (weather.equals("FOG"))
		{
			coordinates.setHeight(Height - 3);
			Logger.GetFileToWrite().writetofile("Baloon#" + this.name + "(" + this.id + "): I can't see S***T\n");
		}
		else
		{
			coordinates.setHeight(Height - 15);
			Logger.GetFileToWrite().writetofile("Baloon#" + this.name + "(" + this.id + "): So cold out here!\n");
		}
		
		if (coordinates.getHeight() <= 0)
		{
			coordinates.setHeight(0);
			Logger.GetFileToWrite().writetofile("\nBaloon#" + this.name + "(" + this.id + "): Landing. Coordinates: " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight() + "\n");
			Logger.GetFileToWrite().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from WeatherTower.\n\n");
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		//need to write in the file the registration for the ballon
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Logger.GetFileToWrite().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to WeatherTower.\n");
	}
}
