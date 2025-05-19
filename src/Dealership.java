import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicleArrayList;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicleArrayList = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleArrayList.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return vehicleArrayList;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }


    public ArrayList<Vehicle> getVehicleByPrice(double min, double max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicleArrayList) {
            if (v.price >= min && v.price <= max) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicleArrayList) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehicleByYear(int minYear, int maxYear) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicleArrayList) {
            if (v.getYear() >= minYear && v.getYear() <= maxYear) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehicleByColor(String color) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicleArrayList) {
            if (v.getColor().equalsIgnoreCase(color)) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehicleByMileage(int minMileage, int maxMileage) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicleArrayList) {
            if (v.getOdometer() >= minMileage && v.getOdometer() <= maxMileage) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehicleByType(String type) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicleArrayList) {
            if (v.getVehicleType().equalsIgnoreCase(type)) {
                matches.add(v);
            }
        }
        return matches;
    }
    public boolean removeVehicle(int vin) {
        for (Vehicle v : vehicleArrayList) {
            if (v.getVin() == vin) {  // Check if the VIN matches
                vehicleArrayList.remove(v);  // Remove the vehicle
                return true;  // Vehicle was found and removed
            }
        }
        return false;  // No vehicle with the given VIN found
    }
}