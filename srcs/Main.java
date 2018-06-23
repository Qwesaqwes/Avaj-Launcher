package srcs;
import srcs.exceptions.CustomException;	//include exceptions class
import java.io.*;		//for buffered and file
import java.util.*;		//for List
import srcs.vehicules.*;
import srcs.weather.*;

public class Main
{
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String[] arg) throws InterruptedException
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
			String line = reader.readLine();
			if (line != null)
			{
				weatherTower = new WeatherTower();
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0)
				{
					System.out.println("Invalid simulations count " + simulations);
					System.exit(1);
				}
				// System.out.println(line);
				while ((line = reader.readLine()) != null)
				{
					Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
						Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
						Integer.parseInt(line.split(" ")[4]));
					if (flyable != null)
						flyables.add(flyable);
					// System.out.println(line);
				}

				for (Flyable flyable : flyables)
				{
					flyable.registerTower(weatherTower);
				}

				// for (int i = 1; i <= simulations; i++)
				// {
				// 	weatherTower.changeWeather();
				// }
			}
		}
		// catch(CustomException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
	}
}
