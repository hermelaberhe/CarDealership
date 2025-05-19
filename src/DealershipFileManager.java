import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class DealershipFileManager {

    // Loads dealership and its vehicles from file
    public Dealership getDealership() {
        Dealership dealership = null;

        try (Scanner scanner = new Scanner(new File("vehicleInfo.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    // Dealership info line
                    dealership = new Dealership(parts[0], parts[1], parts[2]);
                } else if (parts.length == 8 && dealership != null) {
                    // Vehicle line
                    int stockNumber = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String type = parts[4];
                    String color = parts[5];
                    int mileage = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(stockNumber, year, make, model, type, color, mileage, price);
                    dealership.addVehicle(vehicle);
                } else {
                    System.out.println("Unrecognized or misplaced line: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }

        return dealership;
    }

    // Saves the dealership and its vehicles back to the file
    public void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("vehicleInfo.csv"))) {
            // Write dealership info
            writer.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());

            // Write vehicle info
            for (Vehicle v : dealership.getAllVehicles()) {
                writer.println(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                        v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
            }
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}