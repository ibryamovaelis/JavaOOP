package Vehicle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double carFuelAmount = Double.parseDouble(tokens[1]);
        double carFuelConsumption = Double.parseDouble(tokens[2]);
        double carTankCapacity = Double.parseDouble(tokens[3]);
        Vehicle car = new Car(carFuelAmount, carFuelConsumption, carTankCapacity);

        tokens = scanner.nextLine().split("\\s+");
        double truckFuelAmount = Double.parseDouble(tokens[1]);
        double truckFuelConsumption = Double.parseDouble(tokens[2]);
        double truckTankCapacity = Double.parseDouble(tokens[3]);
        Vehicle truck = new Truck(truckFuelAmount, truckFuelConsumption, truckTankCapacity);

        tokens = scanner.nextLine().split("\\s+");
        double busFuelAmount = Double.parseDouble(tokens[1]);
        double busFuelConsumption = Double.parseDouble(tokens[2]);
        double busTankCapacity = Double.parseDouble(tokens[3]);
        Vehicle bus = new Bus(busFuelAmount, busFuelConsumption, busTankCapacity);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehicleType = tokens[1];
            Vehicle vehicle = vehicles.get(vehicleType);
            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(false);
                    }
                    System.out.println(vehicles.get(vehicleType).drive(distance));

                    break;
                case "Refuel":
                    double fuel = Double.parseDouble(tokens[2]);
                    try {
                        vehicles.get(vehicleType).refuel(fuel);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    distance = Double.parseDouble(tokens[2]);
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(true);
                    }
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                    break;
            }
        }
        vehicles.values()
                .forEach(vehicle -> System.out.println(vehicle.toString()));
    }
}
