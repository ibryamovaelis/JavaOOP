package Vehicle;

public class Bus extends VehicleImpl {
    private boolean isEmpty;
    private static final double AC_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        isEmpty = false;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if (!isEmpty) {
            super.setFuelConsumption(fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
        }
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
