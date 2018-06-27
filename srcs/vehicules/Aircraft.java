package srcs.vehicules;
import srcs.vehicules.Coordinates;
import java.lang.String;

public abstract class Aircraft
{
	protected		long id = 0;
	protected		String name;
	protected		Coordinates coordinates;
	private	static	long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private static long nextId()
	{
		idCounter += 1;
		return (idCounter);
	}
}
