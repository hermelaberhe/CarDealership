import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Dealership dealership;

    // Constructor to initialize dealership and scanner
    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        int option = 0;

        while (option != 99) {
            // Show menu
            System.out.println("\nPlease choose an option:");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");

            // Read user input
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (option) {
                    case 1 -> processGetByPrice();
                    case 2 -> processGetByMakeModel();
                    case 3 -> processGetByYear();
                    case 4 -> processGetByColor();
                    case 5 -> processGetByMileage();
                    case 6 -> processGetByType();
                    case 7 -> processListAll();
                    case 8 -> processAddVehicle();
                    case 9 -> processRemoveVehicle();
                    case 99 -> System.out.println("Exiting... Goodbye!");
                    default -> System.out.println("Invalid option. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.close();
    }

    private void processGetByPrice() {
        System.out.print("Enter min price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter max price: ");
        double max = Double.parseDouble(scanner.nextLine());

        ArrayList<Vehicle> results = dealership.getVehicleByPrice(min, max);
        displayVehicles(results);
    }

    private void processGetByMakeModel() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehicleByMakeModel(make, model);
        displayVehicles(results);
    }

    private void processGetByYear() {
        System.out.print("Enter min year: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter max year: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> results = dealership.getVehicleByYear(min, max);
        displayVehicles(results);
    }

    private void processGetByColor() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehicleByColor(color);
        displayVehicles(results);
    }

    private void processGetByMileage() {
        System.out.print("Enter min mileage: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter max mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> results = dealership.getVehicleByMileage(min, max);
        displayVehicles(results);
    }

    private void processGetByType() {
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehicleByType(type);
        displayVehicles(results);
    }

    private void processListAll() {
        ArrayList<Vehicle> all = dealership.getAllVehicles();
        displayVehicles(all);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }
    private void processAddVehicle() {
        // Prompt user for vehicle details and add a new vehicle to the dealership
        System.out.println("Enter the vehicle details: ");
        System.out.print("VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type (Car, Truck, SUV, Van): ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    private void processRemoveVehicle() {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());
        boolean removed = dealership.removeVehicle(vin);
        if (removed) {
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }


}