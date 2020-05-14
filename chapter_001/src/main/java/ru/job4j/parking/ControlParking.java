package ru.job4j.parking;

/**
 * Describes the behaviour a distribution cars in the parkins.
 */
public interface ControlParking {
    /**
     * Adds parking to inner storage.
     *
     * @param parking parking to add
     */
    void addParking(Parking parking);

    /**
     * Removes parking from inner storage.
     *
     * @param parking parking to remove
     */
    void removeParking(Parking parking);

    /**
     * Distributes specified car in the parkings in inner storage.
     *
     * @param car specified car
     * @return result of operation, false if not found free space, true if free space is there
     */
    boolean takeCar(Car car);

    /**
     * Searches and removes the specified car from parkings in inner storage.
     *
     * @param lpn licence plate number of car to remove
     * @return result of operation, false if not found car, true if car is in the parkings
     */
    boolean giveCar(String lpn);
}
