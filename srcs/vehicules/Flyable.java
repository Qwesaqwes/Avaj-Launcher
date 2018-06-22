package srcs.vehicules;
import srcs.weather.*;

public interface Flyable
{
	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
}
