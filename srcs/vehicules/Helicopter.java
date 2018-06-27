package srcs.vehicules;
import	srcs.weather.WeatherTower;
import	srcs.weather.Logger;

public class Helicopter extends Aircraft implements Flyable
{
    private	WeatherTower	weatherTower;
	private int 			Longitude;
    private	int 			Height;
    
    Helicopter(String name, Coordinates coordinates)
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
			coordinates.setLongitude(Longitude + 10);
			coordinates.setHeight(Height + 2);
			if (coordinates.getHeight() > 100)
				coordinates.setHeight(100);
			Logger.GetFileToWrite().writetofile("Helicopter#" + this.name + "(" + this.id + "): SO HOT!\n");
		}
		else if (weather.equals("RAIN"))
		{
			coordinates.setLongitude(Longitude + 5);
			Logger.GetFileToWrite().writetofile("Helicopter#" + this.name + "(" + this.id + "): This is going to get wet.\n");
		}
		else if (weather.equals("FOG"))
		{
			coordinates.setLongitude(Longitude + 1);
			Logger.GetFileToWrite().writetofile("Helicopter#" + this.name + "(" + this.id + "): Hope we have lights for this fog.\n");
		}
		else
		{
			coordinates.setHeight(Height - 12);
			Logger.GetFileToWrite().writetofile("Helicopter#" + this.name + "(" + this.id + "): My rotors are going to freeze!\n");
		}
		
		if (coordinates.getHeight() <= 0)
		{
			coordinates.setHeight(0);
			Logger.GetFileToWrite().writetofile("\nHelicopter#" + this.name + "(" + this.id + "): Landing. Coordinates: " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight() + "\n");
			Logger.GetFileToWrite().writetofile("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from WeatherTower.\n\n");
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		//need to write in the file the registration for the ballon
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Logger.GetFileToWrite().writetofile("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to WeatherTower.\n");
	}
}