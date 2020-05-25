package ru.job4j.parking;

/**
 * Class for parking control system.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ControlSystem implements ControlParking {
    @Override
    public void addParking(Parking parking) {

    }

    @Override
    public void removeParking(Parking parking) {

    }

    @Override
    public boolean takeCar(String lpn) {
        return false;
    }

    @Override
    public boolean giveCar(Car car) {
        return false;
    }
}
