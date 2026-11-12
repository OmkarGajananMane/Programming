import java.util.*;

interface ParkingObserver
{
    void update(int availableSpots);
}

class DisplayBoard implements ParkingObserver
{
    public void update(int availableSpots)
    {
        System.out.println("Display Board : "+availableSpots);
    }
}

class MobileApplication implements ParkingObserver
{
    public void update(int availableSpots)
    {
        System.out.println("Mobile Application : "+availableSpots);
    }
}

class ParkingFloor
{
    private int availableSpots;

    private List<ParkingObserver> observers = new ArrayList<>();

    public ParkingFloor(int availableSpots)
    {
        this.availableSpots = availableSpots;
    }

    public void addObserver(ParkingObserver observer)
    {
        observers.add(observer);
    }

    public void removeObserver(ParkingObserver observer)
    {
        observers.remove(observer);
    }

    public void vehicleParked()
    {
        availableSpots--;
        notifyObservers();
    }

    public void vehicleExited()
    {
        availableSpots++;
        notifyObservers();
    }

    private void notifyObservers()
    {
        for(ParkingObserver observer : observers)
        {
           observer.update(availableSpots); 
        }
    }
}


class program995
{
    public static void main(String A[])
    {
        ParkingFloor floor = new ParkingFloor(5);
        
        DisplayBoard board = new DisplayBoard();
        MobileApplication app = new MobileApplication();

        floor.addObserver(board);
        floor.addObserver(app);

        floor.vehicleParked();

        System.out.println("--------------------");
    
        floor.vehicleExited();
    }
}
