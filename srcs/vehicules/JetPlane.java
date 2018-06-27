package srcs.vehicules;
import	srcs.weather.WeatherTower;
import	srcs.weather.Logger;

public class JetPlane extends Aircraft implements Flyable
{
    private	WeatherTower	weatherTower;
	private int 			Latitude;
	private	int 			Height;
	
	JetPlane(String name, Coordinates coordinates)
	{
		super (name, coordinates);
	}

	public void updateConditions()
	{
		String weather = weatherTower.getWeather(coordinates);
		Latitude = coordinates.getLatitude();
		Height = coordinates.getHeight();
		if (weather.equals("SUN"))
		{
			coordinates.setLatitude(Latitude + 10);
			coordinates.setHeight(Height + 2);
			if (coordinates.getHeight() > 100)
				coordinates.setHeight(100);
			Logger.GetFileToWrite().writetofile("JetPlane#" + this.name + "(" + this.id + "): What a day! Lets do some target Practice.\n");
		}
		else if (weather.equals("RAIN"))
		{
			coordinates.setHeight(Height + 5);
			Logger.GetFileToWrite().writetofile("JetPlane#" + this.name + "(" + this.id + "): My jet need some cleaning work.\n");
		}
		else if (weather.equals("FOG"))
		{
			coordinates.setHeight(Height + 1);
			Logger.GetFileToWrite().writetofile("JetPlane#" + this.name + "(" + this.id + "): It is time to use my X-ray Vision!\n");
		}
		else
		{
			coordinates.setHeight(Height - 7);
			Logger.GetFileToWrite().writetofile("JetPlane#" + this.name + "(" + this.id + "): It is good this freezing temperatures for my engine.\n");
		}
		
		if (coordinates.getHeight() <= 0)
		{
			coordinates.setHeight(0);
			Logger.GetFileToWrite().writetofile("\nJetPlane#" + this.name + "(" + this.id + "): Landing. Coordinates: " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight() + "\n");
			Logger.GetFileToWrite().writetofile("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from WeatherTower.\n\n");
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		//need to write in the file the registration for the ballon
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Logger.GetFileToWrite().writetofile("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to WeatherTower.\n");
	}
}