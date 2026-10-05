/*
    SmartPark - Parking Lot Automation System with GUI

    Design Patterns:
    1. Factory Pattern       -> VehicleFactory
    2. Observer Pattern      -> ParkingObserver / ParkingDispalyBoard
    3. Strategy Pattern      -> ParkingStrategy / PricingStrategy / PaymentStrategy
    4. Singleton Pattern     -> ParkingLot

    Compile:
        javac SmartParkGUI.java

    Run:
        java SmartParkGUI
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

public class SmartParkGUI extends JFrame
{
    private ParkingLot parkingLot;

    private EntryGate entryGate;
    private ExitGate exitGate;

    private JComboBox<String> vehicleTypeCombo;
    private JTextField vehicleNumberField;

    private JTextField ticketNumberField;
    private JComboBox<String> paymentCombo;

    private JTextField searchVehicleField;

    private JTextArea outputArea;

    private JLabel totalLabel;
    private JLabel occupiedLabel;
    private JLabel availableLabel;

    public SmartParkGUI()
    {
        parkingLot = ParkingLot.getInstance();

        createParkingLot();

        entryGate = new EntryGate(1);
        exitGate = new ExitGate(1);

        createGUI();

        refreshStatus();
    }

    /////////////////////////////////////////////////////////
    // Create Parking Lot
    /////////////////////////////////////////////////////////

    private void createParkingLot()
    {
        parkingLot.setParkingLotName("SmartPark");

        // Floor 1

        ParkingFloor floor1 = new ParkingFloor(1);

        floor1.addParkingSpot(new BikeSpot(101));
        floor1.addParkingSpot(new BikeSpot(102));

        floor1.addParkingSpot(new CarSpot(103));
        floor1.addParkingSpot(new CarSpot(104));

        floor1.addParkingSpot(new TruckSpot(105));
        floor1.addParkingSpot(new TruckSpot(106));

        ParkingDispalyBoard board1 =
                new ParkingDispalyBoard(floor1);

        floor1.addObserver(board1);

        // Floor 2

        ParkingFloor floor2 = new ParkingFloor(2);

        floor2.addParkingSpot(new BikeSpot(201));
        floor2.addParkingSpot(new BikeSpot(202));

        floor2.addParkingSpot(new CarSpot(203));
        floor2.addParkingSpot(new CarSpot(204));

        floor2.addParkingSpot(new TruckSpot(205));
        floor2.addParkingSpot(new TruckSpot(206));

        ParkingDispalyBoard board2 =
                new ParkingDispalyBoard(floor2);

        floor2.addObserver(board2);

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);
    }

    /////////////////////////////////////////////////////////
    // GUI
    /////////////////////////////////////////////////////////

    private void createGUI()
    {
        setTitle("SmartPark - Parking Lot Automation");
        setSize(1100, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
        mainPanel.add(createFooterPanel(), BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createHeaderPanel()
    {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel title =
                new JLabel(
                    "SmartPark",
                    SwingConstants.CENTER);

        title.setFont(
                new Font("Arial", Font.BOLD, 28));

        JLabel subtitle =
                new JLabel(
                    "Parking Lot Automation System",
                    SwingConstants.CENTER);

        subtitle.setFont(
                new Font("Arial", Font.PLAIN, 16));

        JPanel textPanel = new JPanel(new GridLayout(2, 1));

        textPanel.add(title);
        textPanel.add(subtitle);

        panel.add(textPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createCenterPanel()
    {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        panel.add(createOperationPanel(), BorderLayout.WEST);
        panel.add(createOutputPanel(), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createOperationPanel()
    {
        JPanel main = new JPanel();

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.setBorder(
                BorderFactory.createTitledBorder("Operations"));

        main.add(createParkPanel());
        main.add(Box.createVerticalStrut(10));

        main.add(createExitPanel());
        main.add(Box.createVerticalStrut(10));

        main.add(createSearchPanel());
        main.add(Box.createVerticalStrut(10));

        JButton displayButton =
                new JButton("Refresh Parking Status");

        displayButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        displayButton.addActionListener(
                e -> refreshStatus());

        main.add(displayButton);

        return main;
    }

    private JPanel createParkPanel()
    {
        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));

        panel.setBorder(
                BorderFactory.createTitledBorder("1. Park Vehicle"));

        vehicleTypeCombo =
                new JComboBox<>(
                    new String[] {"Bike", "Car", "Truck"});

        vehicleNumberField =
                new JTextField();

        JButton parkButton =
                new JButton("Park Vehicle");

        parkButton.addActionListener(
                e -> parkVehicle());

        panel.add(new JLabel("Vehicle Type"));
        panel.add(vehicleTypeCombo);

        panel.add(new JLabel("Vehicle Number"));
        panel.add(vehicleNumberField);

        panel.add(parkButton);

        return panel;
    }

    private JPanel createExitPanel()
    {
        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));

        panel.setBorder(
                BorderFactory.createTitledBorder("2. Exit Vehicle"));

        ticketNumberField =
                new JTextField();

        paymentCombo =
                new JComboBox<>(
                    new String[] {"Cash", "UPI", "Card"});

        JButton exitButton =
                new JButton("Exit Vehicle");

        exitButton.addActionListener(
                e -> exitVehicle());

        panel.add(new JLabel("Ticket Number"));
        panel.add(ticketNumberField);

        panel.add(new JLabel("Payment Method"));
        panel.add(paymentCombo);

        panel.add(exitButton);

        return panel;
    }

    private JPanel createSearchPanel()
    {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));

        panel.setBorder(
                BorderFactory.createTitledBorder("3. Search Vehicle"));

        searchVehicleField =
                new JTextField();

        JButton searchButton =
                new JButton("Search Vehicle");

        searchButton.addActionListener(
                e -> searchVehicle());

        panel.add(new JLabel("Vehicle Number"));
        panel.add(searchVehicleField);

        panel.add(searchButton);

        return panel;
    }

    private JScrollPane createOutputPanel()
    {
        outputArea =
                new JTextArea();

        outputArea.setEditable(false);
        outputArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14));

        outputArea.setLineWrap(false);

        return new JScrollPane(outputArea);
    }

    private JPanel createFooterPanel()
    {
        JPanel panel =
                new JPanel(
                    new GridLayout(1, 3, 20, 5));

        totalLabel =
                new JLabel("Total: 0",
                        SwingConstants.CENTER);

        occupiedLabel =
                new JLabel("Occupied: 0",
                        SwingConstants.CENTER);

        availableLabel =
                new JLabel("Available: 0",
                        SwingConstants.CENTER);

        totalLabel.setFont(
                new Font("Arial", Font.BOLD, 15));

        occupiedLabel.setFont(
                new Font("Arial", Font.BOLD, 15));

        availableLabel.setFont(
                new Font("Arial", Font.BOLD, 15));

        panel.add(totalLabel);
        panel.add(occupiedLabel);
        panel.add(availableLabel);

        return panel;
    }

    /////////////////////////////////////////////////////////
    // Park Vehicle
    /////////////////////////////////////////////////////////

    private void parkVehicle()
    {
        try
        {
            String number =
                    vehicleNumberField.getText().trim();

            if(number.length() == 0)
            {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter vehicle number",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            String selectedType =
                    (String) vehicleTypeCombo.getSelectedItem();

            VehicleType type;

            switch(selectedType)
            {
                case "Bike":
                    type = VehicleType.BIKE;
                    break;

                case "Car":
                    type = VehicleType.CAR;
                    break;

                case "Truck":
                    type = VehicleType.TRUCK;
                    break;

                default:
                    throw new RuntimeException(
                            "Invalid vehicle type");
            }

            Vehicle vehicle =
                    VehicleFactory.creatVehicle(
                            type,
                            number);

            ParkingTicket ticket =
                    parkingLot.parkVehicle(
                            vehicle,
                            entryGate);

            outputArea.setText(
                    "VEHICLE PARKED SUCCESSFULLY\n\n" +
                    ticket.getTicketDetails());

            ticketNumberField.setText(
                    String.valueOf(
                        ticket.getTicketNumber()));

            vehicleNumberField.setText("");

            refreshStatus();

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Parking Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /////////////////////////////////////////////////////////
    // Exit Vehicle
    /////////////////////////////////////////////////////////

    private void exitVehicle()
    {
        try
        {
            String ticketText =
                    ticketNumberField.getText().trim();

            if(ticketText.length() == 0)
            {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter ticket number",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            int ticketNumber =
                    Integer.parseInt(ticketText);

            ParkingTicket ticket =
                    parkingLot.searchTicket(ticketNumber);

            if(ticket == null)
            {
                throw new RuntimeException(
                        "No active ticket found");
            }

            String payment =
                    (String) paymentCombo.getSelectedItem();

            PaymentStrategy paymentStrategy;

            switch(payment)
            {
                case "Cash":
                    paymentStrategy =
                            new CashPayment();
                    break;

                case "UPI":
                    paymentStrategy =
                            new UPIPayment();
                    break;

                case "Card":
                    paymentStrategy =
                            new CardPayment();
                    break;

                default:
                    throw new RuntimeException(
                            "Invalid payment method");
            }

            double amount =
                    parkingLot.removeVehicle(
                            ticketNumber,
                            exitGate,
                            paymentStrategy);

            outputArea.setText(
                    "VEHICLE EXIT SUCCESSFUL\n\n" +
                    ticket.getTicketDetails() +
                    "\n\n" +
                    "Parking Duration : " +
                    ticket.calculateHours() +
                    " hour(s)\n" +
                    "Parking Charges  : Rs. " +
                    amount +
                    "\n" +
                    "Payment Method   : " +
                    payment +
                    "\n\n" +
                    "Spot released successfully.");

            ticketNumberField.setText("");

            refreshStatus();

        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(
                    this,
                    "Ticket number must be a number",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Exit Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /////////////////////////////////////////////////////////
    // Search Vehicle
    /////////////////////////////////////////////////////////

    private void searchVehicle()
    {
        try
        {
            String number =
                    searchVehicleField.getText().trim();

            if(number.length() == 0)
            {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter vehicle number",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            ParkingTicket ticket =
                    parkingLot.searchVehicle(number);

            if(ticket == null)
            {
                outputArea.setText(
                        "VEHICLE NOT FOUND\n\n" +
                        "Vehicle " + number +
                        " is not currently parked.");
            }
            else
            {
                outputArea.setText(
                        "VEHICLE FOUND\n\n" +
                        ticket.getTicketDetails());
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Search Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /////////////////////////////////////////////////////////
    // Refresh Status
    /////////////////////////////////////////////////////////

    private void refreshStatus()
    {
        totalLabel.setText(
                "Total: " +
                parkingLot.getTotalSpots());

        occupiedLabel.setText(
                "Occupied: " +
                parkingLot.getOccupiedSpots());

        availableLabel.setText(
                "Available: " +
                parkingLot.getAvailableSpots());

        if(outputArea != null)
        {
            outputArea.setText(
                    parkingLot.getParkingStatus());
        }
    }

    /////////////////////////////////////////////////////////
    // Main
    /////////////////////////////////////////////////////////

    public static void main(String A[])
    {
        SwingUtilities.invokeLater(
            new Runnable()
            {
                @Override
                public void run()
                {
                    SmartParkGUI frame =
                            new SmartParkGUI();

                    frame.setVisible(true);
                }
            }
        );
    }
}


/////////////////////////////////////////////////////////
// Step 1 : Enums
/////////////////////////////////////////////////////////

enum VehicleType
{
    BIKE,
    CAR,
    TRUCK
}

enum SpotType
{
    BIKE,
    CAR,
    TRUCK
}

enum TicketStatus
{
    ACTIVE,
    CLOSED
}

/////////////////////////////////////////////////////////
// Step 2 : Vehicle Hierarchy
/////////////////////////////////////////////////////////

abstract class Vehicle
{
    private String vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType)
    {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType()
    {
        return this.vehicleType;
    }

    public String getVehicleNumber()
    {
        return this.vehicleNumber;
    }

    public abstract void display();
}

class Bike extends Vehicle
{
    public Bike(String vehicleNumber)
    {
        super(vehicleNumber, VehicleType.BIKE);
    }

    @Override
    public void display()
    {
        System.out.println("Bike : " + getVehicleNumber());
    }
}

class Car extends Vehicle
{
    public Car(String vehicleNumber)
    {
        super(vehicleNumber, VehicleType.CAR);
    }

    @Override
    public void display()
    {
        System.out.println("Car : " + getVehicleNumber());
    }
}

class Truck extends Vehicle
{
    public Truck(String vehicleNumber)
    {
        super(vehicleNumber, VehicleType.TRUCK);
    }

    @Override
    public void display()
    {
        System.out.println("Truck : " + getVehicleNumber());
    }
}

/////////////////////////////////////////////////////////
// Step 3 : Factory Pattern
/////////////////////////////////////////////////////////

class VehicleFactory
{
    public static Vehicle creatVehicle(VehicleType type, String number)
    {
        switch(type)
        {
            case BIKE:
                return new Bike(number);

            case CAR:
                return new Car(number);

            case TRUCK:
                return new Truck(number);

            default:
                throw new IllegalArgumentException("Invalid Vehicle type");
        }
    }
}

/////////////////////////////////////////////////////////
// Step 4 : Parking Spot Hierarchy
/////////////////////////////////////////////////////////

abstract class ParkingSpot
{
    private int spotNumber;
    private SpotType spotType;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber, SpotType spotType)
    {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.occupied = false;
        this.vehicle = null;
    }

    public int getSpotNumber()
    {
        return this.spotNumber;
    }

    public SpotType getSpotType()
    {
        return this.spotType;
    }

    public boolean isOccupied()
    {
        return this.occupied;
    }

    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    public void parkVehicle(Vehicle vehicle)
    {
        if(this.occupied)
        {
            throw new RuntimeException("Parking spot is already occupied");
        }

        if(!canFitVehicle(vehicle))
        {
            throw new RuntimeException("Vehicle cannot fit in this parking spot");
        }

        this.vehicle = vehicle;
        this.occupied = true;
    }

    public Vehicle removeVehicle()
    {
        if(!this.occupied)
        {
            throw new RuntimeException("Parking spot is already empty");
        }

        Vehicle temp = this.vehicle;

        this.vehicle = null;
        this.occupied = false;

        return temp;
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);

    public void display()
    {
        System.out.println("Spot : " + spotNumber + " [" + spotType + "]");

        if(this.occupied)
        {
            System.out.println("Occupied by : " + vehicle.getVehicleNumber());
        }
        else
        {
            System.out.println("Spot is available");
        }
    }
}

class BikeSpot extends ParkingSpot
{
    public BikeSpot(int spotNumber)
    {
        super(spotNumber, SpotType.BIKE);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle)
    {
        return vehicle.getVehicleType() == VehicleType.BIKE;
    }
}

class CarSpot extends ParkingSpot
{
    public CarSpot(int spotNumber)
    {
        super(spotNumber, SpotType.CAR);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle)
    {
        return vehicle.getVehicleType() == VehicleType.CAR;
    }
}

class TruckSpot extends ParkingSpot
{
    public TruckSpot(int spotNumber)
    {
        super(spotNumber, SpotType.TRUCK);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle)
    {
        return vehicle.getVehicleType() == VehicleType.TRUCK;
    }
}

/////////////////////////////////////////////////////////
// Step 5 : Observer
/////////////////////////////////////////////////////////

interface ParkingObserver
{
    void update();
}

/////////////////////////////////////////////////////////
// Step 6 : Parking Floor
/////////////////////////////////////////////////////////

class ParkingFloor
{
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;
    private List<ParkingObserver> observers;

    public ParkingFloor(int floorNumber)
    {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public int getFloorNumber()
    {
        return this.floorNumber;
    }

    public void addParkingSpot(ParkingSpot spot)
    {
        parkingSpots.add(spot);
    }

    public void addObserver(ParkingObserver observer)
    {
        observers.add(observer);
    }

    private void notifyObservers()
    {
        for(ParkingObserver observer : observers)
        {
            observer.update();
        }
    }

    public ParkingSpot findAvailabSpot(Vehicle vehicle)
    {
        for(ParkingSpot spot : parkingSpots)
        {
            if(!spot.isOccupied() && spot.canFitVehicle(vehicle))
            {
                return spot;
            }
        }

        return null;
    }

    public void occupySpot(ParkingSpot spot, Vehicle vehicle)
    {
        spot.parkVehicle(vehicle);
        notifyObservers();
    }

    public void releaseSpot(ParkingSpot spot)
    {
        spot.removeVehicle();
        notifyObservers();
    }

    public int getAvailableCount(SpotType type)
    {
        int count = 0;

        for(ParkingSpot spot : parkingSpots)
        {
            if(spot.getSpotType() == type && !spot.isOccupied())
            {
                count++;
            }
        }

        return count;
    }

    public List<ParkingSpot> getParkingSpots()
    {
        return parkingSpots;
    }

    public void displayFloor()
    {
        System.out.println();
        System.out.println("Floor : " + floorNumber);

        for(ParkingSpot spot : parkingSpots)
        {
            spot.display();
        }
    }
}

/////////////////////////////////////////////////////////
// Step 7 : Display Board - Observer
/////////////////////////////////////////////////////////

class ParkingDispalyBoard implements ParkingObserver
{
    private ParkingFloor floor;

    public ParkingDispalyBoard(ParkingFloor floor)
    {
        this.floor = floor;
    }

    @Override
    public void update()
    {
        System.out.println();
        System.out.println("--------- Display Board ---------");
        System.out.println("Floor : " + floor.getFloorNumber());
        System.out.println("Available Bike spots : "
                + floor.getAvailableCount(SpotType.BIKE));
        System.out.println("Available Car spots : "
                + floor.getAvailableCount(SpotType.CAR));
        System.out.println("Available Truck spots : "
                + floor.getAvailableCount(SpotType.TRUCK));
        System.out.println("---------------------------------");
    }
}

/////////////////////////////////////////////////////////
// Step 8 : Parking Strategy
/////////////////////////////////////////////////////////

interface ParkingStrategy
{
    ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}

class FirstAvialableParkingStrategy implements ParkingStrategy
{
    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle)
    {
        for(ParkingFloor floor : floors)
        {
            ParkingSpot spot = floor.findAvailabSpot(vehicle);

            if(spot != null)
            {
                return spot;
            }
        }

        return null;
    }
}

/////////////////////////////////////////////////////////
// Step 9 : Pricing Strategy
/////////////////////////////////////////////////////////

interface PricingStrategy
{
    double calculatePrice(Vehicle vehicle, long hours);
}

class NormalPricingStrategy implements PricingStrategy
{
    @Override
    public double calculatePrice(Vehicle vehicle, long hours)
    {
        if(hours <= 0)
        {
            hours = 1;
        }

        switch(vehicle.getVehicleType())
        {
            case BIKE:
                return hours * 20;

            case CAR:
                return hours * 50;

            case TRUCK:
                return hours * 100;

            default:
                return 0;
        }
    }
}

class WeekendPricingStrategy implements PricingStrategy
{
    @Override
    public double calculatePrice(Vehicle vehicle, long hours)
    {
        if(hours <= 0)
        {
            hours = 1;
        }

        switch(vehicle.getVehicleType())
        {
            case BIKE:
                return hours * 40;

            case CAR:
                return hours * 100;

            case TRUCK:
                return hours * 200;

            default:
                return 0;
        }
    }
}

/////////////////////////////////////////////////////////
// Step 10 : Payment Strategy
/////////////////////////////////////////////////////////

interface PaymentStrategy
{
    void pay(double amount);
}

class UPIPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("UPI payment successful : Rs. " + amount);
    }
}

class CardPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Card payment successful : Rs. " + amount);
    }
}

class CashPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Cash payment successful : Rs. " + amount);
    }
}

/////////////////////////////////////////////////////////
// Step 11 : Parking Ticket
/////////////////////////////////////////////////////////

class ParkingTicket
{
    private static int counter = 1000;

    private int ticketNumber;
    private Vehicle vehicle;
    private ParkingFloor floor;
    private ParkingSpot spot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;

    public ParkingTicket(
            Vehicle vehicle,
            ParkingFloor floor,
            ParkingSpot spot)
    {
        this.ticketNumber = ++counter;
        this.vehicle = vehicle;
        this.floor = floor;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    public int getTicketNumber()
    {
        return this.ticketNumber;
    }

    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    public ParkingFloor getFloor()
    {
        return this.floor;
    }

    public ParkingSpot getSpot()
    {
        return this.spot;
    }

    public LocalDateTime getEntryTime()
    {
        return this.entryTime;
    }

    public LocalDateTime getExitTime()
    {
        return this.exitTime;
    }

    public TicketStatus getStatus()
    {
        return this.status;
    }

    public void closeTicket()
    {
        this.exitTime = LocalDateTime.now();
        this.status = TicketStatus.CLOSED;
    }

    public long calculateHours()
    {
        LocalDateTime endtime;

        if(exitTime == null)
        {
            endtime = LocalDateTime.now();
        }
        else
        {
            endtime = exitTime;
        }

        long minutes = Duration.between(entryTime, endtime).toMinutes();
        long hours = minutes / 60;

        if(minutes % 60 != 0)
        {
            hours++;
        }

        if(hours == 0)
        {
            hours = 1;
        }

        return hours;
    }

    public String getTicketDetails()
    {
        return
            "----------------------------------------\n" +
            "           PARKING TICKET\n" +
            "----------------------------------------\n" +
            "Ticket Number : " + ticketNumber + "\n" +
            "Vehicle Number: " + vehicle.getVehicleNumber() + "\n" +
            "Vehicle Type  : " + vehicle.getVehicleType() + "\n" +
            "Floor Number  : " + floor.getFloorNumber() + "\n" +
            "Spot Number   : " + spot.getSpotNumber() + "\n" +
            "Entry Time    : " + entryTime + "\n" +
            "Exit Time     : " + (exitTime == null ? "Not exited" : exitTime) + "\n" +
            "Status        : " + status + "\n" +
            "----------------------------------------";
    }

    public void displayTicket()
    {
        System.out.println(getTicketDetails());
    }
}

/////////////////////////////////////////////////////////
// Step 12 : Entry Gate
/////////////////////////////////////////////////////////

class EntryGate
{
    private int gateNumber;

    public EntryGate(int gateNumber)
    {
        this.gateNumber = gateNumber;
    }

    public int getGateNumber()
    {
        return this.gateNumber;
    }

    public ParkingTicket generateTicket(
            Vehicle vehicle,
            ParkingFloor floor,
            ParkingSpot spot)
    {
        System.out.println("Vehicle entering from gate : " + gateNumber);

        return new ParkingTicket(vehicle, floor, spot);
    }
}

/////////////////////////////////////////////////////////
// Step 13 : Exit Gate
/////////////////////////////////////////////////////////

class ExitGate
{
    private int gateNumber;

    public ExitGate(int gateNumber)
    {
        this.gateNumber = gateNumber;
    }

    public int getGateNumber()
    {
        return this.gateNumber;
    }

    public double processExit(
            ParkingTicket ticket,
            PricingStrategy pricingStrategy,
            PaymentStrategy paymentStrategy)
    {
        ticket.closeTicket();

        long hours = ticket.calculateHours();

        double amount =
                pricingStrategy.calculatePrice(ticket.getVehicle(), hours);

        System.out.println();
        System.out.println("Vehicle exiting from gate : " + gateNumber);
        System.out.println("Parking Duration : " + hours + " hour(s)");
        System.out.println("Parking charges : Rs. " + amount);

        paymentStrategy.pay(amount);

        return amount;
    }
}

/////////////////////////////////////////////////////////
// Step 14 : Singleton Parking Lot
/////////////////////////////////////////////////////////

class ParkingLot
{
    private static ParkingLot instance;

    private String parkingLotName;

    private List<ParkingFloor> floors;

    private Map<Integer, ParkingTicket> activeTickets;

    private Map<String, ParkingTicket> vehicleTicketMap;

    private ParkingStrategy parkingStrategy;

    private PricingStrategy pricingStrategy;

    private ParkingLot()
    {
        floors = new ArrayList<>();
        activeTickets = new HashMap<>();
        vehicleTicketMap = new HashMap<>();

        parkingStrategy = new FirstAvialableParkingStrategy();
        pricingStrategy = new NormalPricingStrategy();
    }

    public static synchronized ParkingLot getInstance()
    {
        if(instance == null)
        {
            instance = new ParkingLot();
        }

        return instance;
    }

    public void setParkingLotName(String parkingLotName)
    {
        this.parkingLotName = parkingLotName;
    }

    public String getParkingLotName()
    {
        return parkingLotName;
    }

    public void addFloor(ParkingFloor floor)
    {
        floors.add(floor);
    }

    public List<ParkingFloor> getFloors()
    {
        return floors;
    }

    public void setParkingStrategy(ParkingStrategy strategy)
    {
        this.parkingStrategy = strategy;
    }

    public void setPricingStrategy(PricingStrategy strategy)
    {
        this.pricingStrategy = strategy;
    }

    public ParkingTicket parkVehicle(
            Vehicle vehicle,
            EntryGate entryGate)
    {
        if(vehicleTicketMap.containsKey(vehicle.getVehicleNumber()))
        {
            throw new RuntimeException(
                    "This vehicle is already parked");
        }

        ParkingSpot spot =
                parkingStrategy.findSpot(floors, vehicle);

        if(spot == null)
        {
            throw new RuntimeException("Parking is full for this vehicle type");
        }

        ParkingFloor selectedFloor = null;

        for(ParkingFloor floor : floors)
        {
            ParkingSpot temp = floor.findAvailabSpot(vehicle);

            if(temp == spot)
            {
                selectedFloor = floor;
                break;
            }
        }

        if(selectedFloor == null)
        {
            throw new RuntimeException("Unable to identify floor");
        }

        selectedFloor.occupySpot(spot, vehicle);

        ParkingTicket ticket =
                entryGate.generateTicket(vehicle, selectedFloor, spot);

        activeTickets.put(ticket.getTicketNumber(), ticket);

        vehicleTicketMap.put(
                vehicle.getVehicleNumber(), ticket);

        return ticket;
    }

    public double removeVehicle(
            int ticketNumber,
            ExitGate exitGate,
            PaymentStrategy paymentStrategy)
    {
        ParkingTicket ticket = activeTickets.get(ticketNumber);

        if(ticket == null)
        {
            throw new RuntimeException("There is no such active ticket");
        }

        double amount =
                exitGate.processExit(
                        ticket,
                        pricingStrategy,
                        paymentStrategy);

        ticket.getFloor().releaseSpot(ticket.getSpot());

        activeTickets.remove(ticketNumber);

        vehicleTicketMap.remove(
                ticket.getVehicle().getVehicleNumber());

        return amount;
    }

    public ParkingTicket searchVehicle(String vehicleNumber)
    {
        return vehicleTicketMap.get(vehicleNumber);
    }

    public ParkingTicket searchTicket(int ticketNumber)
    {
        return activeTickets.get(ticketNumber);
    }

    public int getTotalSpots()
    {
        int count = 0;

        for(ParkingFloor floor : floors)
        {
            count += floor.getParkingSpots().size();
        }

        return count;
    }

    public int getOccupiedSpots()
    {
        int count = 0;

        for(ParkingFloor floor : floors)
        {
            for(ParkingSpot spot : floor.getParkingSpots())
            {
                if(spot.isOccupied())
                {
                    count++;
                }
            }
        }

        return count;
    }

    public int getAvailableSpots()
    {
        return getTotalSpots() - getOccupiedSpots();
    }

    public String getParkingStatus()
    {
        StringBuilder builder = new StringBuilder();

        builder.append("PARKING LOT STATUS\n");
        builder.append("============================\n");
        builder.append("Total Spots     : ")
               .append(getTotalSpots()).append("\n");
        builder.append("Occupied Spots   : ")
               .append(getOccupiedSpots()).append("\n");
        builder.append("Available Spots  : ")
               .append(getAvailableSpots()).append("\n\n");

        for(ParkingFloor floor : floors)
        {
            builder.append("Floor ")
                   .append(floor.getFloorNumber())
                   .append("\n");

            builder.append("  Bike  : ")
                   .append(floor.getAvailableCount(SpotType.BIKE))
                   .append(" available\n");

            builder.append("  Car   : ")
                   .append(floor.getAvailableCount(SpotType.CAR))
                   .append(" available\n");

            builder.append("  Truck : ")
                   .append(floor.getAvailableCount(SpotType.TRUCK))
                   .append(" available\n\n");

            for(ParkingSpot spot : floor.getParkingSpots())
            {
                builder.append("  Spot ")
                       .append(spot.getSpotNumber())
                       .append(" [")
                       .append(spot.getSpotType())
                       .append("] : ");

                if(spot.isOccupied())
                {
                    builder.append("Occupied by ")
                           .append(spot.getVehicle().getVehicleNumber());
                }
                else
                {
                    builder.append("Available");
                }

                builder.append("\n");
            }

            builder.append("\n");
        }

        return builder.toString();
    }
}

/////////////////////////////////////////////////////////
// Step 15 : GUI Controller
/////////////////////////////////////////////////////////

