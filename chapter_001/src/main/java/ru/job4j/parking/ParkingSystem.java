package ru.job4j.parking;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class ParkingSystem implements Parking {
    /**
     * Size of lorry place.
     */
    private final int lorrySize;

    /**
     * Last added car to parking.
     */
    private Car lastAddedCar;

    /**
     * Places in parking for lorries.
     */
    private final Car[] lorryParking;

    /**
     * Places in parking for passenger cars.
     */
    private final Car[] pcParking;

    public ParkingSystem(int lorrySize, int lorryUnits, int pcUnits) {
        this.lorrySize = lorrySize;
        this.lorryParking = new Car[lorryUnits];
        this.pcParking = new Car[pcUnits];
    }

    /**
     * Calculates for free places in lorry's places.
     *
     * @return number of free places for lorry
     */
    private int freeLorryPlaces() {
        return (int) Arrays.stream(lorryParking).filter(Objects::isNull).count();
    }

    /**
     * Calculates for free places in passenger car's places.
     *
     * @return number of free places for passenger car
     */
    private int freePcPlaces() {
        return (int) Arrays.stream(pcParking).filter(Objects::isNull).count();
    }

    @Override
    public boolean hasSpace(Car car) {
        boolean result = false;
        if (car.getSize() == 1) {
            if (freePcPlaces() > 0) {
                result = true;
            }
        } else {
            if (freeLorryPlaces() > 0 || freeLorryPlaceInPcPlaces(car.getSize())) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Calculates whether are free place in places for passenger cars for lorry with specified size.
     *
     * @param size size of lorry
     * @return result of check
     */
    private boolean freeLorryPlaceInPcPlaces(int size) {
        int freePlaceSize = 0;
        for (Car car : pcParking) {
            if (car == null) {
                freePlaceSize++;
            } else {
                freePlaceSize = 0;
            }
            if (freePlaceSize == size) {
                break;
            }
        }
        return freePlaceSize == size;
    }

    @Override
    public boolean hasCar(String lpn) {
        boolean result = false;
        if (hasCarInPcParking(lpn) || hasCarInLorryParking(lpn)) {
            result = true;
        }
        return result;
    }

    /**
     * Searches the car with specified lpn in places for lorries.
     *
     * @param lpn lpn of searched car
     * @return result of check
     */
    private boolean hasCarInLorryParking(String lpn) {
        boolean result = false;
        for (Car car : lorryParking) {
            if (car != null && lpn.equals(car.getLpn())) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Searches the car with specified lpn in places for passenger cars.
     *
     * @param lpn lpn of searched car
     * @return result of check
     */
    private boolean hasCarInPcParking(String lpn) {
        boolean result = false;
        for (Car car : pcParking) {
            if (car != null && lpn.equals(car.getLpn())) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void addCar(Car car) {
        if (car.getSize() == 1) {
            if (freePcPlaces() > 0) {
                addPcCarToPcParking(car);
            }
        } else {
            if (freeLorryPlaces() > 0) {
                addLorryCarToLorryParking(car);
            } else {
                addLorryCarToPcParking(car);
            }
        }
        lastAddedCar = car;
    }

    /**
     * Adds lorry to places for passenger cars.
     *
     * @param car lorry to add
     */
    private void addLorryCarToPcParking(Car car) {
        int freePlaceSize = 0;
        for (int index = 0; index < pcParking.length; index++) {
            if (pcParking[index] == null) {
                freePlaceSize++;
                if (freePlaceSize == car.getSize()) {
                    for (int indexRepl = index - freePlaceSize + 1; indexRepl <= index; indexRepl++) {
                        pcParking[indexRepl] = car;
                    }
                    break;
                }
            }
        }
    }

    /**
     * Adds lorry to places for lorries
     *
     * @param car lorry to add
     */
    private void addLorryCarToLorryParking(Car car) {
        for (int index = 0; index < lorryParking.length; index++) {
            if (lorryParking[index] == null) {
                lorryParking[index] = car;
                break;
            }
        }
    }

    /**
     * Adds passenger car to places for passenger cars.
     *
     * @param car passenger car to add
     */
    private void addPcCarToPcParking(Car car) {
        for (int index = 0; index < pcParking.length; index++) {
            if (pcParking[index] == null) {
                pcParking[index] = car;
                break;
            }
        }
    }

    @Override
    public void removeCar(String lpn) {
        if (hasCarInPcParking(lpn)) {
            removeCarInPcParking(lpn);
        } else if (hasCarInLorryParking(lpn)) {
            removeCarInLorryParking(lpn);
        }
    }

    /**
     * Removes lorry from places for lorries.
     *
     * @param lpn lpn of car to remove
     */
    private void removeCarInLorryParking(String lpn) {
        for (int index = 0; index < lorryParking.length; index++) {
            if (pcParking[index] != null && lpn.equals(lorryParking[index].getLpn())) {
                lorryParking[index] = null;
            }
        }
    }

    /**
     * Removes any car from places for passenger cars.
     *
     * @param lpn lpn of car to remove
     */
    private void removeCarInPcParking(String lpn) {
        for (int index = 0; index < pcParking.length; index++) {
            if (pcParking[index] != null && lpn.equals(pcParking[index].getLpn())) {
                pcParking[index] = null;
            }
        }
    }

    @Override
    public Car lastAdded() {
        return this.lastAddedCar;
    }
}
