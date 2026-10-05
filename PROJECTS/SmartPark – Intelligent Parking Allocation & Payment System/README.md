# 🚗 SmartPark – Intelligent Parking Allocation & Payment System

> A Java-based **Low-Level Design (LLD)** project that simulates a multi-floor parking facility with automated parking allocation, ticket management, dynamic pricing, multiple payment methods, and real-time parking availability updates.

---

## 📌 Project Overview

**SmartPark** is an object-oriented parking management system developed in **Java**.

The system is designed to manage the complete lifecycle of a vehicle inside a parking facility:

```text
Vehicle Entry
      ↓
Vehicle Identification
      ↓
Vehicle Creation
      ↓
Parking Spot Allocation
      ↓
Parking Ticket Generation
      ↓
Vehicle Parking
      ↓
Vehicle Search / Status
      ↓
Vehicle Exit
      ↓
Parking Duration Calculation
      ↓
Parking Fee Calculation
      ↓
Payment Processing
      ↓
Parking Spot Release
      ↓
Availability Update
```

The project focuses on applying **Object-Oriented Programming, Low-Level Design principles, Java Collections, and Design Patterns** to solve a real-world system-design problem.

---

# 🎯 Objectives

The major objectives of this project are:

- Design a scalable parking Allocation system.
- Support multiple vehicle types.
- Manage multiple parking floors.
- Allocate appropriate parking spots automatically.
- Prevent duplicate parking of the same vehicle.
- Generate and manage parking tickets.
- Calculate parking duration and charges.
- Support multiple payment methods.
- Display real-time parking availability.
- Apply reusable and extensible design patterns.
- Demonstrate practical Java OOP and LLD concepts.

---

# 🏗️ System Architecture

The overall architecture of SmartPark can be represented as:

```text
                         ┌──────────────────────┐
                         │   Main / Controller  │
                         │     program1017      │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │      ParkingLot      │
                         │    Singleton         │
                         │                      │
                         │  - Floors            │
                         │  - Active Tickets    │
                         │  - Vehicle Mapping   │
                         │  - Parking Strategy  │
                         │  - Pricing Strategy  │
                         └──────────┬───────────┘
                                    │
              ┌─────────────────────┼─────────────────────┐
              │                     │                     │
              ▼                     ▼                     ▼
      ┌──────────────┐      ┌──────────────┐      ┌──────────────┐
      │ ParkingFloor │      │ ParkingTicket│      │   Vehicle    │
      └──────┬───────┘      └──────────────┘      └──────┬───────┘
             │                                            │
             ▼                                            ▼
      ┌──────────────┐                          ┌─────────────────┐
      │ ParkingSpot  │                          │ VehicleFactory  │
      └──────┬───────┘                          └────────┬────────┘
             │                                           │
       ┌─────┼─────┐                              ┌──────┼──────┐
       ▼     ▼     ▼                              ▼      ▼      ▼
     Bike   Car   Truck                          Bike   Car   Truck
      Spot   Spot   Spot

             │
             │ Parking Availability
             ▼
      ┌─────────────────────┐
      │ ParkingDisplayBoard │
      │  Observer Pattern   │
      └─────────────────────┘


              ENTRY FLOW
                   │
                   ▼
           ┌─────────────┐
           │  EntryGate  │
           └──────┬──────┘
                  │
                  ▼
           Parking Ticket


              EXIT FLOW
                  │
                  ▼
           ┌─────────────┐
           │   ExitGate  │
           └──────┬──────┘
                  │
          ┌───────┼────────┐
          ▼       ▼        ▼
       Pricing  Payment  Release
       Strategy Strategy  Spot
```

---

# 🔄 Complete Parking Flow

## 🚘 Vehicle Entry

When a vehicle enters the parking facility:

```text
Vehicle
   │
   ▼
Select Vehicle Type
   │
   ▼
VehicleFactory
   │
   ▼
Create Vehicle Object
   │
   ▼
Check Duplicate Vehicle
   │
   ▼
ParkingStrategy
   │
   ▼
Find Available Spot
   │
   ▼
Occupy Parking Spot
   │
   ▼
EntryGate
   │
   ▼
Generate ParkingTicket
   │
   ▼
Store Active Ticket
```

---

## 🎫 Parking Ticket

Each parked vehicle receives a unique parking ticket.

The ticket contains:

- Ticket Number
- Vehicle Number
- Vehicle Type
- Floor Number
- Parking Spot Number
- Entry Time
- Exit Time
- Ticket Status

Ticket status is maintained using:

```text
ACTIVE
   │
   │ Vehicle exits
   ▼
CLOSED
```

---

# 🚪 Vehicle Exit Flow

When the vehicle exits:

```text
Enter Ticket Number
        │
        ▼
Find Active Ticket
        │
        ▼
Close Ticket
        │
        ▼
Calculate Parking Duration
        │
        ▼
Calculate Parking Charges
        │
        ▼
Select Payment Method
        │
        ▼
Process Payment
        │
        ▼
Release Parking Spot
        │
        ▼
Remove Active Records
        │
        ▼
Notify Display Board
```

---

# 🧩 Design Patterns

One of the major goals of this project is to demonstrate practical usage of **Design Patterns**.

## 1️⃣ Singleton Pattern

### Class

```text
ParkingLot
```

Only one `ParkingLot` object is maintained throughout the application.

```java
private static ParkingLot instance;

private ParkingLot()
{
}

public static synchronized ParkingLot getInstance()
{
    if(instance == null)
    {
        instance = new ParkingLot();
    }

    return instance;
}
```

### Purpose

The Singleton Pattern ensures that the application has a single central parking-lot controller.

```text
             ParkingLot
                 │
          ┌──────┴──────┐
          │             │
        Floor 1       Floor 2
          │             │
        Spots         Spots
```

---

# 2️⃣ Factory Pattern

### Class

```text
VehicleFactory
```

The factory is responsible for creating different vehicle objects.

```text
                  VehicleFactory
                        │
             ┌──────────┼──────────┐
             ▼          ▼          ▼
           Bike        Car       Truck
```

Instead of creating objects directly throughout the application:

```java
new Bike(number);
new Car(number);
new Truck(number);
```

the system uses:

```java
VehicleFactory.creatVehicle(...)
```

### Benefit

Vehicle creation is centralized and new vehicle types can be added more easily.

---

# 3️⃣ Observer Pattern

### Subject

```text
ParkingFloor
```

### Observer

```text
ParkingDispalyBoard
```

Whenever a parking spot becomes occupied or available, the display board is notified.

```text
                ParkingFloor
                     │
              notifyObservers()
                     │
                     ▼
          ┌─────────────────────┐
          │ ParkingDisplayBoard │
          └──────────┬──────────┘
                     │
                     ▼
             Updated Availability
```

For example:

```text
Floor : 1

Available Bike spots  : 1
Available Car spots   : 2
Available Truck spots : 2
```

This allows additional observers such as a future website or mobile application to be added.

---

# 4️⃣ Strategy Pattern

The project uses the Strategy Pattern in multiple areas.

## Parking Strategy

```text
ParkingStrategy
       │
       ▼
FirstAvialableParkingStrategy
```

The strategy decides which parking spot should be selected.

Future strategies can include:

```text
ParkingStrategy
      │
      ├── FirstAvailable
      ├── NearestAvailable
      ├── FloorBased
      └── VehiclePriority
```

---

## Pricing Strategy

```text
PricingStrategy
       │
       ├── NormalPricingStrategy
       │
       └── WeekendPricingStrategy
```

The pricing algorithm can therefore be changed without changing the exit-processing logic.

Example:

```text
Normal Pricing

Bike  → ₹20/hour
Car   → ₹50/hour
Truck → ₹100/hour
```

Weekend pricing:

```text
Bike  → ₹40/hour
Car   → ₹100/hour
Truck → ₹200/hour
```

---

## Payment Strategy

```text
PaymentStrategy
       │
       ├── CashPayment
       ├── UPIPayment
       └── CardPayment
```

The exit system does not need to know how each payment method works.

It simply calls:

```java
paymentStrategy.pay(amount);
```

---

# 🧱 Class Structure

The major classes and interfaces are:

```text
Vehicle
 │
 ├── Bike
 ├── Car
 └── Truck

VehicleFactory

ParkingSpot
 │
 ├── BikeSpot
 ├── CarSpot
 └── TruckSpot

ParkingFloor

ParkingObserver
 │
 └── ParkingDispalyBoard

ParkingStrategy
 │
 └── FirstAvialableParkingStrategy

PricingStrategy
 │
 ├── NormalPricingStrategy
 └── WeekendPricingStrategy

PaymentStrategy
 │
 ├── CashPayment
 ├── UPIPayment
 └── CardPayment

ParkingTicket

EntryGate

ExitGate

ParkingLot
```

---

# 🗃️ Data Structures Used

The project uses Java Collections for managing system information.

### ArrayList

Used for storing:

```java
List<ParkingFloor> floors;
List<ParkingSpot> parkingSpots;
List<ParkingObserver> observers;
```

### HashMap

Used for fast lookup of active tickets:

```java
Map<Integer, ParkingTicket> activeTickets;
```

and vehicle-ticket mapping:

```java
Map<String, ParkingTicket> vehicleTicketMap;
```

The vehicle map also helps prevent the same vehicle from being parked multiple times.

---

# 🧠 Object-Oriented Concepts

The project demonstrates the four major pillars of OOP.

### Encapsulation

Important data members are kept private.

```java
private String vehicleNumber;
private VehicleType vehicleType;
```

Access is provided through methods such as:

```java
getVehicleNumber()
getVehicleType()
```

### Abstraction

Abstract classes and interfaces define common behavior.

Examples:

```java
abstract class Vehicle
abstract class ParkingSpot

interface ParkingStrategy
interface PricingStrategy
interface PaymentStrategy
```

### Inheritance

Specialized classes inherit common functionality.

```text
Vehicle
 ├── Bike
 ├── Car
 └── Truck
```

and:

```text
ParkingSpot
 ├── BikeSpot
 ├── CarSpot
 └── TruckSpot
```

### Polymorphism

Different implementations can be accessed using a common reference.

For example:

```java
Vehicle vehicle;
```

can refer to:

```text
Bike
Car
Truck
```

Similarly:

```java
PaymentStrategy paymentStrategy;
```

can refer to:

```text
CashPayment
UPIPayment
CardPayment
```

---

# 🛡️ Business Rules

The system implements several important parking rules.

### Duplicate Vehicle Prevention

A vehicle cannot be parked again while it already has an active ticket.

```text
Vehicle Number
      │
      ▼
vehicleTicketMap
      │
      ├── Exists → Reject
      │
      └── Not Exists → Continue
```

### Parking Spot Compatibility

A vehicle can only use its compatible parking spot.

```text
Bike  → BikeSpot
Car   → CarSpot
Truck → TruckSpot
```

### Parking Full Handling

If no compatible parking spot is available:

```text
No Available Spot
       ↓
Parking Full Exception
```

### Ticket Validation

A vehicle can exit only with a valid active ticket.

---

# 💰 Pricing Model

The current implementation supports two pricing strategies.

| Vehicle |    Normal |   Weekend |
| ------- | --------: | --------: |
| Bike    |  ₹20/hour |  ₹40/hour |
| Car     |  ₹50/hour | ₹100/hour |
| Truck   | ₹100/hour | ₹200/hour |

The system calculates parking duration using Java's:

```java
LocalDateTime
Duration
```

Partial hours are rounded up to the next complete hour.

For example:

```text
Parking Duration = 2 hours 15 minutes

Billable Duration = 3 hours
```

---

# 💳 Payment Methods

The system supports:

```text
PaymentStrategy
      │
      ├── CashPayment
      │
      ├── UPIPayment
      │
      └── CardPayment
```

Example:

```text
Parking Charges : Rs. 100.0

Payment Method:
1. Cash
2. UPI
3. Card
```

---

# 🖥️ Application Menu

The console application provides:

```text
---------------------------------
---- SmartPark ------------------
---------------------------------

1 : Park Vehicle
2 : Exit Vehicle
3 : Search Vehicle
4 : Display Parking Lot
5 : Exit
```

### Park Vehicle

```text
Select Vehicle Type

1 : Bike
2 : Car
3 : Truck

Enter Vehicle Number
```

The system automatically finds a suitable parking spot and generates a ticket.

### Exit Vehicle

```text
Enter Ticket Number

Select Payment Option

1 : Cash
2 : UPI
3 : Card
```

The system calculates the bill, processes payment, and releases the parking spot.

### Search Vehicle

The vehicle number can be used to find its active parking ticket.

### Display Parking Lot

Displays all floors and their parking spots.

---

# 📊 Parking Availability

The Observer Pattern automatically updates the display board when a parking spot changes.

Example:

```text
--------- Display Board ---------

Floor : 1

Available Bike spots  : 1
Available Car spots   : 2
Available Truck spots : 1

---------------------------------
```

This avoids manually refreshing the parking availability.

---

# 🛠️ Technology Stack

| Technology            | Usage                        |
| --------------------- | ---------------------------- |
| Java                  | Core application development |
| OOP                   | System modeling              |
| Collections Framework | Data management              |
| Java Time API         | Parking duration calculation |
| Design Patterns       | Extensible architecture      |
| Exception Handling    | Error management             |
| Console Interface     | User interaction             |

---

# 📂 Project Structure

A recommended GitHub repository structure:

```text
SmartPark/
│
├── README.md
│
├── src/
│   └── program1017.java
│
└── screenshots/
    ├── parking.png
    ├── ticket.png
    └── payment.png
```

If the project is later converted into a standard Java/Maven project:

```text
SmartPark/
│
├── README.md
├── pom.xml
│
└── src/
    └── main/
        └── java/
            ├── Vehicle.java
            ├── VehicleFactory.java
            ├── ParkingSpot.java
            ├── ParkingFloor.java
            ├── ParkingTicket.java
            ├── ParkingLot.java
            ├── EntryGate.java
            ├── ExitGate.java
            └── Main.java
```

---

# ▶️ How to Run

## 1. Clone the repository

```bash
git clone <your-repository-url>
```

## 2. Navigate to the project

```bash
cd SmartPark
```

## 3. Compile

```bash
javac program1017.java
```

## 4. Run

```bash
java SmartPark
```

---

# 🔮 Future Enhancements

The current console-based system can be extended into a production-level application.

### Backend

- Spring Boot REST APIs
- MySQL/PostgreSQL database
- JPA/Hibernate
- RESTful services

### Authentication

- User registration
- Login
- Role-based access
- Admin management

### Parking Features

- Vehicle reservation
- Nearest parking spot strategy
- VIP parking
- EV charging spots
- Disabled parking spots
- Multiple entry and exit gates

### Payment

- Real UPI integration
- Payment gateway
- Online receipts
- Transaction history

### Frontend

- Web-based dashboard
- Mobile application
- Real-time parking availability

### Monitoring

- Parking analytics
- Revenue reports
- Occupancy reports
- Vehicle history

---

# 📈 Learning Outcomes

Through this project, I strengthened my understanding of:

- Java Object-Oriented Programming
- Low-Level Design
- Class relationships
- Interfaces and abstract classes
- Inheritance and polymorphism
- Java Collections
- Exception handling
- Design Patterns
- Separation of responsibilities
- Extensible system architecture
- Real-world software modeling

---

# 👨‍💻 Author

**Om**

Java Developer | Software Development | Low-Level Design

---

# ⭐ Project Highlights

```text
Java
 │
 ├── OOP
 │
 ├── Low-Level Design
 │
 ├── Singleton Pattern
 │
 ├── Factory Pattern
 │
 ├── Observer Pattern
 │
 ├── Strategy Pattern
 │
 ├── Collections Framework
 │
 ├── Java Time API
 │
 └── Exception Handling
```

> **SmartPark demonstrates how a real-world parking system can be modeled using clean object-oriented design and reusable software design patterns.**
