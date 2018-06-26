package	srcs.weather;
import	srcs.vehicules.Coordinates;
import	srcs.weather.WeatherProvider;;

public class WeatherTower extends Tower
{
	public String	getWeather(Coordinates coordinates)
	{
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	void changeWeather()
	{
		conditionsChanged();
	}
}
