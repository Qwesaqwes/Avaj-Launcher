package srcs.weather;
import srcs.exceptions.CustomException;	//include exceptions class
import java.io.*;		//for buffered and file
import java.util.*;		//for List

import srcs.vehicules.*;
import srcs.weather.*;

public class Main
{
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();
	private static int		simulations;

	public static void main(String[] arg) throws InterruptedException
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
			String line = reader.readLine();
			if (line != null)
			{
				weatherTower = new WeatherTower();
				try{simulations = Integer.parseInt(line.split(" ")[0]);}
				catch (NumberFormatException e)
				{
					System.out.println("Error trying to get number of simulation");
					System.exit(1);
				}
				if (simulations < 0)
				{
					System.out.println("Invalid simulations count " + simulations);
					System.exit(1);
				}
				while ((line = reader.readLine()) != null)
				{
					try
					{
						Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
							Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
							Integer.parseInt(line.split(" ")[4]));
						if (flyable != null)
							flyables.add(flyable);
					}
					catch (CustomException e) {e.printStackTrace();}
				}
				Logger.InitFile();
				for (Flyable flyable : flyables)
				{
					flyable.registerTower(weatherTower);
				}
				for (int i = 1; i <= simulations; i++)
				{
					weatherTower.changeWeather();
				}
			}
		}
		catch (FileNotFoundException e) {System.out.println("Couldn't find file " + arg[0]);}
		catch (IOException e) {System.out.println("There was an error while reading the file " + arg[0]);}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("Specify simulation file");}
		finally {Logger.GetFileToWrite().close();}
	}
}
