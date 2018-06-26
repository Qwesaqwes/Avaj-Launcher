package	srcs.weather;
import srcs.vehicules.Flyable;
import java.util.*;

public class Tower
{
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable Flyable)
    {
        if (observers.contains(Flyable) == false)
        {
            observers.add(Flyable);
        }
    }

    public void unregister(Flyable Flyable)
    {
        //do stuff
    }

    protected void conditionsChanged()
    {
        //Update Conditions for each Aircrafts and check if they landed, if so need to unregister
        for (Flyable flyable : observers)
        {
            flyable.updateConditions();
        }
    }
}