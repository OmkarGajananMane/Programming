class ParkingLot
{
    private static ParkingLot instance;

    private  ParkingLot()
    {
        System.out.println("ParkingLot object gest created");
    }

    public static ParkingLot getInstance()
    {
        if(instance == null)
        {
            instance = new ParkingLot();
        }

        return instance;
    }
}

class program973
{
    public static void main(String A[])
    {
        // ParkingLot pobj1 = new ParkingLot();
    
        ParkingLot pobj1 = ParkingLot.getInstance();
        ParkingLot pobj2 = ParkingLot.getInstance();
        ParkingLot pobj3 = ParkingLot.getInstance();
    } 
}