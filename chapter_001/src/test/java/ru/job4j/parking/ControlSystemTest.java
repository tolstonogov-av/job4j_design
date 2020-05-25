package ru.job4j.parking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for test class ControlSystem.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ControlSystemTest {
    private final Parking parking = new ParkingSystem(2, 2, 3);

    private final ControlParking control = new ControlSystem();

    private final Car passengerCar = new SimpleCar(1, "GOSNOMER1");

    private final Car lorry = new SimpleCar(2, "GOSNOMER2");

    @Before
    public void setBefore() {
        control.addParking(parking);
    }

    /**
     * Lorry (L) = 2 place
     * Passenger car (PC) = 1 place
     * busy - b
     * free - f
     * Parking = {Lf, Lf, PCf, PCf, PCf}
     * PC -> Parking = {Lf, Lf, PCb, PCf, PCf}
     */
    @Test
    public void whenGivePassengerCarToFreePassengerCarPlaceThenItInParking() {
        assertTrue(control.giveCar(passengerCar));
        assertEquals(passengerCar, parking.lastAdded());
        assertTrue(control.takeCar(passengerCar.getLpn()));
    }

    /**
     * Lorry (L) = 2 place
     * Passenger car (PC) = 1 place
     * busy - b
     * free - f
     * Parking = {Lf, Lf, PCb, PCb, PCb}
     * PC -> Parking = not success
     */
    @Test
    public void whenGivePassengerCarToBusyPassengerCarPlaceThenItNotInParking() {
        control.giveCar(new SimpleCar(1, "GOSNOMER3"));
        control.giveCar(new SimpleCar(1, "GOSNOMER4"));
        control.giveCar(new SimpleCar(1, "GOSNOMER5"));
        assertFalse(control.giveCar(passengerCar));
    }

    /**
     * Lorry (L) = 2 place
     * Passenger car (PC) = 1 place
     * busy - b
     * free - f
     * Parking = {Lf, Lf, PCf, PCf, PCf}
     * L -> Parking = {Lb, Lf, PCf, PCf, PCf}
     */
    @Test
    public void whenGiveLorryToFreeLorryPlaceThenItInParking() {
        assertTrue(control.giveCar(lorry));
        assertEquals(lorry, parking.lastAdded());
        assertTrue(control.takeCar(lorry.getLpn()));
    }

    /**
     * Lorry (L) = 2 place
     * Passenger car (PC) = 1 place
     * busy - b
     * free - f
     * Parking = {Lb, Lb, PCf, PCf, PCf}
     * L -> Parking = {Lb, Lb, PCb, PCb, PCf}
     */
    @Test
    public void whenGiveLorryToBusyLorryPlaceAndFreePassengerCarPlaceThenItInParking() {
        control.giveCar(new SimpleCar(2, "GOSNOMER3"));
        control.giveCar(new SimpleCar(2, "GOSNOMER4"));
        assertTrue(control.giveCar(lorry));
        assertEquals(lorry, parking.lastAdded());
        assertTrue(control.takeCar(lorry.getLpn()));
    }

    /**
     * Lorry (L) = 2 place
     * Passenger car (PC) = 1 place
     * busy - b
     * free - f
     * Parking = {Lb, Lb, PCb, PCb, PCb}
     * PC -> Parking = not success
     */
    @Test
    public void whenGiveLorryToBusyLorryPlaceAndBusyPassengerCarPlaceThenItNotInParking() {
        control.giveCar(new SimpleCar(2, "GOSNOMER3"));
        control.giveCar(new SimpleCar(2, "GOSNOMER4"));
        control.giveCar(new SimpleCar(1, "GOSNOMER5"));
        control.giveCar(new SimpleCar(1, "GOSNOMER6"));
        control.giveCar(new SimpleCar(1, "GOSNOMER7"));
        assertFalse(control.giveCar(lorry));
    }
}
