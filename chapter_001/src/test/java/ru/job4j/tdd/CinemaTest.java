package ru.job4j.tdd;

import org.junit.Test;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class CinemaTest {
    /**
     * Seat with row == 0 and column == 0 doesn't exist.
     */
    @Test (expected = IllegalArgumentException.class)
    public void illegalDataOfTicket() {
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = new Cinema3D().buy(new AccountCinema(), 0, 0, date);
    }

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
     * For example, a session that has already ended.
     */
    @Test (expected = IllegalArgumentException.class)
    public void illegalSessionToAdd() {
        Session session = new Session3D();
        new Cinema3D().add(session);
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
     * When a new sessions is added, it is possible to find it in the storage by predicate.
     */
    @Test
    public void findByPredicate() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> session.equals(new Session3D()));
        assertNull(sessions);
    }
}
