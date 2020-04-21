package ru.job4j.control;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import ru.job4j.food.Curd;
import ru.job4j.food.Milk;
import ru.job4j.food.Orange;
import ru.job4j.storage.Shop;
import ru.job4j.storage.Trash;
import ru.job4j.storage.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class to test class ControlQuality.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ControlQualityTest {
    /**
     * Test current day.
     */
    private final Calendar today = new GregorianCalendar(2020, Calendar.APRIL, 20);

    /**
     * Curd with 87.8% expired term.
     */
    private final Curd curd = new Curd(
            "Vatrusha",
            new GregorianCalendar(2020, Calendar.MAY, 1),
            new GregorianCalendar(2020, Calendar.FEBRUARY, 1),
            100,
            9.5f);

    /**
     * Milk with 211.1% expired term.
     */
    private final Milk milk1 = new Milk(
            "Prostokvashino",
            new GregorianCalendar(2020, Calendar.APRIL, 10),
            new GregorianCalendar(2020, Calendar.APRIL, 1),
            55,
            0.93f);

    /**
     * Milk with 60% expired term.
     */
    private final Milk milk2 = new Milk(
            "Semenishna",
            new GregorianCalendar(2020, Calendar.APRIL, 22),
            new GregorianCalendar(2020, Calendar.APRIL, 17),
            50,
            1f);

    /**
     * Orange with 15.6% expired term.
     */
    private final Orange orange = new Orange(
            "Egypt",
            new GregorianCalendar(2020, Calendar.AUGUST, 1),
            new GregorianCalendar(2020, Calendar.APRIL, 1),
            150,
            65);

    /**
     * Trash for Liskov distribution.
     */
    private final Trash trashLiskov = new Trash("Tolstonogov Alexey");

    /**
     * Shop for Liskov distribution.
     */
    private final Shop shopLiskov = new Shop("Krasnoyarsk");

    /**
     * Warehouse for Liskov distribution.
     */
    private final Warehouse warehouseLiskov = new Warehouse(300);

    /**
     * Distribution to Liskov storages.
     */
    private final ControlQuality cqLiskov = new ControlQuality(trashLiskov, shopLiskov, warehouseLiskov);

    /**
     * Trash for not Liskov distribution.
     */
    private final Trash trashNotLiskov = new Trash("Tolstonogov Alexey");

    /**
     * Shop for not Liskov distribution.
     */
    private final Shop shopNotLiskov = new Shop("Krasnoyarsk");

    /**
     * Warehouse for not Liskov distribution.
     */
    private final Warehouse warehouseNotLiskov = new Warehouse(300);

    /**
     * Distribution to not Liskov storages.
     */
    private final ControlQuality cqNotLiskov = new ControlQuality(trashNotLiskov, shopNotLiskov, warehouseNotLiskov);

    /**
     *             ---
     * trash
     *             100
     * shop - 10%       <- curd 87.8%
     *             75
     * shop
     *             25
     * warehouse
     *             0
     *             ---
     */
    @Test
    public void whenDistributeCurdThenDistributedToShopAndDiscount10() {
        cqLiskov.distributionLiskov(curd, today);
        Curd curdLiskov = (Curd) shopLiskov.getLastItem();
        Curd curdExpected = new Curd(
                "Vatrusha",
                new GregorianCalendar(2020, Calendar.MAY, 1),
                new GregorianCalendar(2020, Calendar.FEBRUARY, 1),
                100,
                9.5f);
        curdExpected.setDiscount(10);
        assertEquals(curdExpected, curdLiskov);
    }

    /**
     *             ---
     * trash            <- milk 211.1%
     *             100
     * shop - 10%
     *             75
     * shop
     *             25
     * warehouse
     *             0
     *             ---
     */
    @Test
    public void whenDistributeMilk1ThenDistributedToTrash() {
        cqLiskov.distributionLiskov(milk1, today);
        Milk milk1Liskov = (Milk) trashLiskov.getLastItem();
        assertEquals(milk1, milk1Liskov);
    }

    /**
     *             ---
     * trash
     *             100
     * shop - 10%
     *             75
     * shop             <- milk 60%
     *             25
     * warehouse
     *             0
     *             ---
     */
    @Test
    public void whenDistributeMilk2ThenDistributedToShop() {
        cqLiskov.distributionLiskov(milk2, today);
        Milk milk2Liskov = (Milk) shopLiskov.getLastItem();
        assertEquals(milk2, milk2Liskov);
    }

    /**
     *             ---
     * trash
     *             100
     * shop - 10%
     *             75
     * shop
     *             25
     * warehouse        <- Orange 15.6%
     *             0
     *             ---
     */
    @Test
    public void whenDistributeOrangeThenDistributedToWarehouse() {
        cqLiskov.distributionLiskov(orange, today);
        Orange orangeLiskov = (Orange) warehouseLiskov.getLastItem();
        assertEquals(orange, orangeLiskov);
    }

    /**
     *   curd -> Liskov distribution      -> Shop - 10%
     *
     *   curd -> not Liskov distribution  -> Shop - 10%
     */
    @Test
    public void whenDistributeCurdThenLiskovAndNotLiskovDistributedToShopAndDiscount10() {
        cqLiskov.distributionLiskov(curd, today);
        Curd curdLiskov = (Curd) shopLiskov.getLastItem();
        cqNotLiskov.distributionNoLiskov(curd, today);
        Curd curdNotLiskov = (Curd) shopNotLiskov.getLastItem();
        assertEquals(curdNotLiskov, curdLiskov);
    }

    /**
     *   milk1 -> Liskov distribution      -> Trash
     *
     *   milk1 -> not Liskov distribution  -> Trash
     */
    @Test
    public void whenDistributeMilk1ThenLiskovAndNotLiskovDistributedToTrash() {
        cqLiskov.distributionLiskov(milk1, today);
        Milk milk1Liskov = (Milk) trashLiskov.getLastItem();
        cqNotLiskov.distributionNoLiskov(milk1, today);
        Milk milk1NotLiskov = (Milk) trashNotLiskov.getLastItem();
        assertEquals(milk1NotLiskov, milk1Liskov);
    }

    /**
     *   milk2 -> Liskov distribution      -> Shop
     *
     *   milk2 -> not Liskov distribution  -> Shop
     */
    @Test
    public void whenDistributeMilk2ThenLiskovAndNotLiskovDistributedToShop() {
        cqLiskov.distributionLiskov(milk2, today);
        Milk milk2Liskov = (Milk) shopLiskov.getLastItem();
        cqNotLiskov.distributionNoLiskov(milk2, today);
        Milk milk2NotLiskov = (Milk) shopNotLiskov.getLastItem();
        assertEquals(milk2NotLiskov, milk2Liskov);
    }

    /**
     *   orange -> Liskov distribution      -> Warehouse
     *
     *   orange -> not Liskov distribution  -> Warehouse
     */
    @Test
    public void whenDistributeOrangeThenLiskovAndNotLiskovDistributedToWarehouse() {
        cqLiskov.distributionLiskov(orange, today);
        Orange orangeLiskov = (Orange) warehouseLiskov.getLastItem();
        cqNotLiskov.distributionNoLiskov(orange, today);
        Orange orangeNotLiskov = (Orange) warehouseNotLiskov.getLastItem();
        assertEquals(orangeNotLiskov, orangeLiskov);
    }
}