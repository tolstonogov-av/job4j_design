package ru.job4j.parking;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for parking control system.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ControlSystem implements ControlParking {
    /**
     * Storage for parkings.
     */
    private final List<Parking> parkingStorage = new LinkedList<>();

    @Override
    public void addParking(Parking parking) {
        parkingStorage.add(parking);
    }

    @Override
    public void removeParking(Parking parking) {
        parkingStorage.remove(parking);
    }

    @Override
    public boolean takeCar(String lpn) {
        boolean result = false;
        for (Parking parking: parkingStorage) {
            if (parking.hasCar(lpn)) {
                parking.removeCar(lpn);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean giveCar(Car car) {
        boolean result = false;
        for (Parking parking: parkingStorage) {
            if (parking.hasSpace(car)) {
                parking.addCar(car);
                result = true;
                break;
            }
        }
        return result;
    }
}
