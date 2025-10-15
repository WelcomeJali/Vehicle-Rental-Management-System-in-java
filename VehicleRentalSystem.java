import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Vehicle interface defines the contract for all vehicle types
 * in the rental management system.
 * 
 * @author Welcome Jali
 * @version 1.0
 */
interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
}

/**
 * CarVehicle interface defines specific methods for car-type vehicles
 */
interface CarVehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType);
    String getFuelType();
}

/**
 * MotorVehicle interface defines specific methods for motorcycle-type vehicles
 */
interface MotorVehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    void setMotorcycleType(String type);
    String getMotorcycleType();
}

/**
 * TruckVehicle interface defines specific methods for truck-type vehicles
 */
interface TruckVehicle {
    void setCargoCapacity(double capacity);
    double getCargoCapacity();
    void setTransmissionType(String transmission);
    String getTransmissionType();
}

/**
 * Car class implements both Vehicle and CarVehicle interfaces
 */
class Car implements Vehicle, CarVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfDoors;
    private String fuelType;
    
    public Car(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }
    
    @Override
    public String getMake() {
        return make;
    }
    
    @Override
    public String getModel() {
        return model;
    }
    
    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    
    @Override
    public void setNumberOfDoors(int doors) {
        if (doors <= 0) {
            throw new IllegalArgumentException("Number of doors must be positive");
        }
        this.numberOfDoors = doors;
    }
    
    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    @Override
    public void setFuelType(String fuelType) {
        String normalizedType = fuelType.toLowerCase().trim();
        if (!normalizedType.equals("petrol") && 
            !normalizedType.equals("diesel") && 
            !normalizedType.equals("electric")) {
            throw new IllegalArgumentException(
                "Invalid fuel type. Must be petrol, diesel, or electric");
        }
        this.fuelType = normalizedType;
    }
    
    @Override
    public String getFuelType() {
        return fuelType;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Car Details:\n" +
            "  Make: %s\n" +
            "  Model: %s\n" +
            "  Year: %d\n" +
            "  Doors: %d\n" +
            "  Fuel Type: %s",
            make, model, yearOfManufacture, numberOfDoors, fuelType
        );
    }
}

/**
 * Motorcycle class implements both Vehicle and MotorVehicle interfaces
 */
class Motorcycle implements Vehicle, MotorVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    private String motorcycleType;
    
    public Motorcycle(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }
    
    @Override
    public String getMake() {
        return make;
    }
    
    @Override
    public String getModel() {
        return model;
    }
    
    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    
    @Override
    public void setNumberOfWheels(int wheels) {
        if (wheels <= 0) {
            throw new IllegalArgumentException("Number of wheels must be positive");
        }
        this.numberOfWheels = wheels;
    }
    
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    
    @Override
    public void setMotorcycleType(String type) {
        String normalizedType = type.toLowerCase().trim();
        if (!normalizedType.equals("sport") && 
            !normalizedType.equals("cruiser") && 
            !normalizedType.equals("off-road")) {
            throw new IllegalArgumentException(
                "Invalid motorcycle type. Must be sport, cruiser, or off-road");
        }
        this.motorcycleType = normalizedType;
    }
    
    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Motorcycle Details:\n" +
            "  Make: %s\n" +
            "  Model: %s\n" +
            "  Year: %d\n" +
            "  Wheels: %d\n" +
            "  Type: %s",
            make, model, yearOfManufacture, numberOfWheels, motorcycleType
        );
    }
}

/**
 * Truck class implements both Vehicle and TruckVehicle interfaces
 */
class Truck implements Vehicle, TruckVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private double cargoCapacity;
    private String transmissionType;
    
    public Truck(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }
    
    @Override
    public String getMake() {
        return make;
    }
    
    @Override
    public String getModel() {
        return model;
    }
    
    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    
    @Override
    public void setCargoCapacity(double capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Cargo capacity cannot be negative");
        }
        this.cargoCapacity = capacity;
    }
    
    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }
    
    @Override
    public void setTransmissionType(String transmission) {
        String normalizedTransmission = transmission.toLowerCase().trim();
        if (!normalizedTransmission.equals("manual") && 
            !normalizedTransmission.equals("automatic")) {
            throw new IllegalArgumentException(
                "Invalid transmission type. Must be manual or automatic");
        }
        this.transmissionType = normalizedTransmission;
    }
    
    @Override
    public String getTransmissionType() {
        return transmissionType;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Truck Details:\n" +
            "  Make: %s\n" +
            "  Model: %s\n" +
            "  Year: %d\n" +
            "  Cargo Capacity: %.2f tons\n" +
            "  Transmission: %s",
            make, model, yearOfManufacture, cargoCapacity, transmissionType
        );
    }
}

/**
 * Main program for the Vehicle Rental Management System
 * Provides an interactive interface for managing different vehicle types
 * 
 * @author Giktec Technologies
 * @version 1.0
 */
public class VehicleRentalSystem {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Vehicle Rental Management System");
        System.out.println("========================================\n");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    addMotorcycle();
                    break;
                case 3:
                    addTruck();
                    break;
                case 4:
                    displayAllVehicles();
                    break;
                case 5:
                    System.out.println("\nThank you for using the Vehicle Rental System!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add a Car");
        System.out.println("2. Add a Motorcycle");
        System.out.println("3. Add a Truck");
        System.out.println("4. Display All Vehicles");
        System.out.println("5. Exit");
        System.out.println("===============================");
        System.out.print("Enter your choice (1-5): ");
    }
    
    private static int getMenuChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }
    
    private static void addCar() {
        System.out.println("\n--- Add New Car ---");
        
        try {
            System.out.print("Enter make: ");
            String make = scanner.nextLine().trim();
            
            System.out.print("Enter model: ");
            String model = scanner.nextLine().trim();
            
            System.out.print("Enter year of manufacture: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            
            Car car = new Car(make, model, year);
            
            System.out.print("Enter number of doors: ");
            int doors = scanner.nextInt();
            scanner.nextLine();
            car.setNumberOfDoors(doors);
            
            System.out.print("Enter fuel type (petrol/diesel/electric): ");
            String fuelType = scanner.nextLine().trim();
            car.setFuelType(fuelType);
            
            vehicles.add(car);
            System.out.println("\n✓ Car added successfully!");
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\n✗ Error: Invalid input format. Please enter valid data.");
        } catch (IllegalArgumentException e) {
            System.out.println("\n✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n✗ An unexpected error occurred: " + e.getMessage());
        }
    }
    
    private static void addMotorcycle() {
        System.out.println("\n--- Add New Motorcycle ---");
        
        try {
            System.out.print("Enter make: ");
            String make = scanner.nextLine().trim();
            
            System.out.print("Enter model: ");
            String model = scanner.nextLine().trim();
            
            System.out.print("Enter year of manufacture: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            
            Motorcycle motorcycle = new Motorcycle(make, model, year);
            
            System.out.print("Enter number of wheels: ");
            int wheels = scanner.nextInt();
            scanner.nextLine();
            motorcycle.setNumberOfWheels(wheels);
            
            System.out.print("Enter motorcycle type (sport/cruiser/off-road): ");
            String type = scanner.nextLine().trim();
            motorcycle.setMotorcycleType(type);
            
            vehicles.add(motorcycle);
            System.out.println("\n✓ Motorcycle added successfully!");
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\n✗ Error: Invalid input format. Please enter valid data.");
        } catch (IllegalArgumentException e) {
            System.out.println("\n✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n✗ An unexpected error occurred: " + e.getMessage());
        }
    }
    
    private static void addTruck() {
        System.out.println("\n--- Add New Truck ---");
        
        try {
            System.out.print("Enter make: ");
            String make = scanner.nextLine().trim();
            
            System.out.print("Enter model: ");
            String model = scanner.nextLine().trim();
            
            System.out.print("Enter year of manufacture: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            
            Truck truck = new Truck(make, model, year);
            
            System.out.print("Enter cargo capacity (in tons): ");
            double capacity = scanner.nextDouble();
            scanner.nextLine();
            truck.setCargoCapacity(capacity);
            
            System.out.print("Enter transmission type (manual/automatic): ");
            String transmission = scanner.nextLine().trim();
            truck.setTransmissionType(transmission);
            
            vehicles.add(truck);
            System.out.println("\n✓ Truck added successfully!");
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\n✗ Error: Invalid input format. Please enter valid data.");
        } catch (IllegalArgumentException e) {
            System.out.println("\n✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n✗ An unexpected error occurred: " + e.getMessage());
        }
    }
    
    private static void displayAllVehicles() {
        System.out.println("\n========== ALL VEHICLES ==========");
        
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the system.");
        } else {
            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println("\nVehicle #" + (i + 1) + ":");
                System.out.println(vehicles.get(i).toString());
                System.out.println("----------------------------------");
            }
            System.out.println("\nTotal vehicles: " + vehicles.size());
        }
    }
}