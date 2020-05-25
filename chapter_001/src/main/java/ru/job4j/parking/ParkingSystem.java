package ru.job4j.parking;

public class ParkingSystem implements Parking {
    /**
     * Size of lorry place.
     */
    private final int lorrySize;

    /**
     * Number of place for lorries.
     */
    private final int lorryUnits;

    /**
     * Number of place for passenger cars.
     */
    private final int pcUnits;

    public ParkingSystem(int lorrySize, int lorryUnits, int pcUnits) {
        this.lorrySize = lorrySize;
        this.lorryUnits = lorryUnits;
        this.pcUnits = pcUnits;
    }

    @Override
    public boolean hasSpace(Car car) {
        return false;
    }

    @Override
    public boolean hasCar(String lpn) {
        return false;
    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void removeCar(String lpn) {

    }

    @Override
    public Car lastAdded() {
        return null;
    }
}
