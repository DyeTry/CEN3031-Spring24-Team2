public class Vehicle {
    String vehicleMake;
    String vehicleModel;
    String vehicleColor;
    String vehiclePlate;

    Vehicle(String newVehicleMake, String newVehicleModel, String newVehicleColor, String newVehiclePlate) {
        setVehicleMake(newVehicleMake);
        setVehicleModel(newVehicleModel);
        setVehicleColor(newVehicleColor);
        setVehiclePlate(newVehiclePlate);
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    String getVehiclePlate() {
        return vehiclePlate;
    }



}
