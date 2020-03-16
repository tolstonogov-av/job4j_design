package ru.job4j.tdd;

import org.junit.Test;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class CinemaTest {
    /**
     * When buying a ticket, the theater issues a new ticket.
     */
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    /**
     * When a new sessions is added, it is possible to find all of them in the storage.
     */
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertNull(sessions);
    }

    /**
     * When a new session is added, it is possible to find it in the storage by predicate.
     */
    @Test
    public void findByPredicate() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> session.equals(new Session3D()));
        assertNull(sessions);
    }
}
