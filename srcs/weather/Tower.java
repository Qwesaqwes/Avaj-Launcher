package	srcs.weather;
import srcs.vehicules.Flyable;
import java.util.*;

public class Tower
{
    private List<Flyable> observers = new ArrayList<Flyable>();
    private Iterator<Flyable> iterator;

    public void register(Flyable Flyable)
    {
        if (observers.contains(Flyable) == false)
        {
            observers.add(Flyable);
        }
    }

    public void unregister(Flyable flyable)
    {
        iterator.remove();
    }

    protected void conditionsChanged()
    {
        //Update Conditions for each Aircrafts and check if they landed, if so need to unregister
        if (observers.isEmpty() == false)
        {
            iterator = observers.iterator();
            while (iterator.hasNext())
            {
                Flyable flyable = iterator.next();
                flyable.updateConditions();
            }
        }
    }
}