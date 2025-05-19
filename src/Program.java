public class Program {
    public static void main(String[] args) {
        // Load the dealership and its vehicles from the file
        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.getDealership();  // Get dealership data from file

        // If no dealership data is loaded, initialize a default dealership
        if (dealership == null) {
            System.out.println("No dealership data found in the file. Creating a new dealership.");
            dealership = new Dealership("D & B Used Cars", "111 Old Benbrook Rd", "817-555-5555");
        }

        // Pass dealership to the UserInterface to interact with the user
        UserInterface userInterface = new UserInterface(dealership);
        userInterface.displayOptions();

        // Save the dealership data back to the file after all operations
        fileManager.saveDealership(dealership);
    }
}