package srcs;
import srcs.exceptions.CustomException;	//include exceptions class
import java.io.*;		//for buffered and file
import java.util.ArrayList;

import srcs.vehicules.*;

public class Main
{
	private static List<Flyable> StoredFlyable = new ArrayList<Flyable>();

	public static void main(String[] args)
	{
		try
		{
			if (args.length == 0)
				throw new CustomException("No Arguments!");
			else if (!((new File(args[0])).isFile()))
				throw new CustomException("Not a File!");
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line = br.readLine();
			if (line != null)
			{
				if (Integer.parseInt(line) < 0)
					throw new CustomException("First line not a valid Number!");
				int integer = Integer.parseInt(line);
				// System.out.println(integer);
			}
			while ((line = br.readLine()) != null)
			{
				System.out.println(line);
				Flyable aircraft = AircraftFactory.newAircraft()
			}
			br.close();
		}
		catch(CustomException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
	}
}
