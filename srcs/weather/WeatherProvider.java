package	srcs.weather;
import	srcs.vehicules.Coordinates;
import 	java.util.concurrent.ThreadLocalRandom;
import	java.util.Random;

public class WeatherProvider
{
	private static WeatherProvider		weatherProvider;
	private static String[]			weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider()
	{
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return (weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
		return (weather[randomNum]);
	}
}
