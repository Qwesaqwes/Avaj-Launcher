package srcs.vehicules;

public class Coordinates
{
	private int		longitude;
	private int		latitude;
	private int		height;

	public Coordinates(int longitude, int latitude, int height)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public void setLongitude(int newLongitude)
	{
		longitude = newLongitude;
	}

	public void setLatitude(int newLatitude)
	{
		latitude = newLatitude;
	}

	public void setHeight(int newHeight)
	{
		height = newHeight;
	}

	public int getLongitude()
	{
		return (longitude);
	}

	public int getLatitude()
	{
		return (latitude);
	}

	public int getHeight()
	{
		return (height);
	}
}
