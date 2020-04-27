package ru.job4j.control;

import org.junit.Before;
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
     * Curd with 87.8% expired term.
     */
    private final Curd curd = new Curd(
            "Vatrusha",
            System.currentTimeMillis() - 878,
            System.currentTimeMillis() + 122,
            100,
            9.5f);

    /**
     * Milk with 211.1% expired term.
     */
    private final Milk milk1 = new Milk(
            "Prostokvashino",
            System.currentTimeMillis() - 2111,
            System.currentTimeMillis() - 1111,
            55,
            0.93f);

    /**
     * Milk with 60% expired term.
     */
    private final Milk milk2 = new Milk(
            "Semenishna",
            System.currentTimeMillis() - 60,
            System.currentTimeMillis() + 40,
            50,
            1f);

    /**
     * Orange with 15.6% expired term.
     */
    private final Orange orange = new Orange(
            "Egypt",
            System.currentTimeMillis() - 156,
            System.currentTimeMillis() + 844,
            150,
            65);

    /**
     * Trash for  distribution.
     */
    private final Trash trash = new Trash("Tolstonogov Alexey");

    /**
     * Shop for distribution.
     */
    private final Shop shop = new Shop("Krasnoyarsk");

    /**
     * Warehouse for distribution.
     */
    private final Warehouse warehouse = new Warehouse(300);

    /**
     * Distribution to storages.
     */
    private final ControlQuality cq = new ControlQuality();

    @Before
    public void setBefore() {
        cq.addStorage(trash);
        cq.addStorage(shop);
        cq.addStorage(warehouse);
    }

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
    public void whenDistributeCurdThenDistributedAndDiscount10() {
        cq.distribution(curd);
        Curd curdExpected = new Curd(
                "Vatrusha",
                System.currentTimeMillis() - 878,
                System.currentTimeMillis() + 122,
                100,
                9.5f);
        curdExpected.setDiscount(10);
        assertEquals(curdExpected, curd);
    }

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
    public void whenDistributeCurdThenDistributedToShop() {
        cq.distribution(curd);
        Curd curdExpected = (Curd) shop.getLastItem();
        assertEquals(curdExpected, curd);
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
        cq.distribution(milk1);
        Milk milk1Expected = (Milk) trash.getLastItem();
        assertEquals(milk1Expected, milk1);
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
        cq.distribution(milk2);
        Milk milk2Expected = (Milk) shop.getLastItem();
        assertEquals(milk2Expected, milk2);
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
        cq.distribution(orange);
        Orange orangeExpected = (Orange) warehouse.getLastItem();
        assertEquals(orangeExpected, orange);
    }
}