public class Vehicle {
    String vehicleMake;
    String vehicleModel;
    String vehicleColor;
    String vehiclePlate;

    Vehicle(String newVehicleMake, String newVehicleModel, String newVehicleColor, String newVehiclePlate) {
        vehicleMake = newVehicleMake;
        vehicleModel = newVehicleModel;
        vehicleColor = newVehicleColor;
        vehiclePlate = newVehiclePlate;
    }

    String getVehicleMake() {
        return vehicleMake;
    }
    String getVehicleModel() {
        return vehicleModel;
    }
    String getVehicleColor() {
        return vehicleColor;
    }
    String getVehiclePlate() {
        return vehiclePlate;
    }



}
