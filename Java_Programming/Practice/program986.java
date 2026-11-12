class ParkingTicket
{
    private  int ticketNumber;
    private String vehicleNumber;
    private int floorNumber;
    private int spotNumber;
    private String entryTime;

    private ParkingTicket(Builder builder)
    {
        this.ticketNumber = builder.ticketNumber;
        this.vehicleNumber = builder.vehicleNumber;
        this.floorNumber = builder.floorNumber;
        this.spotNumber = builder.spotNumber;
        this.entryTime = builder.entryTime;
    }

    public void display()
    {
        System.out.println("Ticket Number : "+this.ticketNumber);
        System.out.println("Vehicle Number : "+this.vehicleNumber);
        System.out.println("Floor Number : "+this.floorNumber);
        System.out.println("Spot Number : "+this.spotNumber);
        System.out.println("Entry Time : "+this.entryTime);
    }
}

public static class Builder
{
    private  int ticketNumber;
    private String vehicleNumber;
    private int floorNumber;
    private int spotNumber;
    private String entryTime;

    public Builder setTicketNumber(int ticketNumber)
    {
        this.ticketNumber = ticketNumber;
        return this;
    }

    public Builder setVehicleNumber(String vehicleNumber)
    {
        this.vehicleNumber = vehicleNumber;
        return this;
    } 

    public Builder setFloorNumber(int floorNumber)
    {
        this.floorNumber = floorNumber;
        return this;
    }

    public Builder setSpotNumber(int spotNumber)
    {
        this.spotNumber = spotNumber;
        return this;
    }

    public Builder setEntryTime(String entryTime)
    {
        this.entryTime = entryTime;
        return this;
    } 

    public ParkingTicket build()
    {
       return new ParkingTicket(this); 
    }
}

class program986
{
    public static void main(String A[])
    {
        
    }
}