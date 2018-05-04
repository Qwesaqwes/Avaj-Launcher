package srcs.vehicules;
import srcs.vehicules.Coordinates;
import java.lang.String;

public abstract class Aircraft
{
	protected	long id = 0;
	protected	String name;
	protected	Coordinates coordinates;
	private		long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.Coordinates = coordinates;
		this.id = nextId();
	}

	private long nextId()
	{
		this.idCounter += 1;
		return (this.idCounter);
	}
}
