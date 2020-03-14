package ru.job4j.design.srp;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

/**
 * Class to test class ReportEngine.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ReportEngineTest {
    /**
     * One of the employees in company.
     */
    private final Employee employee1 = new Employee(
            "Sam",
            new GregorianCalendar(2010, Calendar.APRIL, 4),
            new GregorianCalendar(2016, Calendar.FEBRUARY, 10),
            10000d);

    /**
     * One of the employees in company.
     */
    private final Employee employee2 = new Employee(
            "Ban",
            new GregorianCalendar(2017, Calendar.NOVEMBER, 17),
            null,
            12800d);

    /**
     * One of the employees in company.
     */
    private final Employee employee3 = new Employee(
            "Luma",
            new GregorianCalendar(2007, Calendar.JANUARY, 5),
            null,
            9000d);

    /**
     * One of the employees in company.
     */
    private final Employee employee4 = new Employee(
            "Garek",
            new GregorianCalendar(2015, Calendar.MAY, 31),
            new GregorianCalendar(2015, Calendar.AUGUST, 3),
            5000d);

    /**
     * The condition, which is used for selection of employees into the report.
     */
    private final Predicate<Employee> predicate = employee -> employee.getSalary() > 5000d;

    /**
     * The employees storage.
     * Method findBy() finds all employees, who satisfy the condition.
     */
    private final Store store = filter -> {
        List<Employee> result = new ArrayList<>();
        if (filter.test(employee1)) {
            result.add(employee1);
        }
        if (filter.test(employee2)) {
            result.add(employee2);
        }
        if (filter.test(employee3)) {
            result.add(employee3);
        }
        if (filter.test(employee4)) {
            result.add(employee4);
        }
        return result;
    };

    /**
     * For HR: without hired, fired; with sorting by salary in descending order.
     */
    @Test
    public void generateReportForHr() {
        ReportView rv = new ReportEngineHr(store);
        String report = rv.generate(predicate);
        String expected = "Name; Salary;" + System.lineSeparator()
                + employee2.getName() + ";"
                + employee2.getSalary() + ";" + System.lineSeparator()
                + employee1.getName() + ";"
                + employee1.getSalary() + ";" + System.lineSeparator()
                + employee3.getName() + ";"
                + employee3.getSalary() + ";" + System.lineSeparator();
        assertEquals(expected, report);
    }

    /**
     * For Accounting: with rubles in salary.
     */
    @Test
    public void generateReportForAccounting() {
        ReportView rv = new ReportEngineAccounting(store);
        String report = rv.generate(predicate);
        String expected = "Name; Hired; Fired; Salary;" + System.lineSeparator()
                + employee1.getName() + ";"
                + employee1.getHired().getTime() + ";"
                + (employee1.getFired() == null ? "-" : employee1.getFired().getTime()) + ";"
                + employee1.getSalary() + " rubles;" + System.lineSeparator()
                + employee2.getName() + ";"
                + employee2.getHired().getTime() + ";"
                + (employee2.getFired() == null ? "-" : employee2.getFired().getTime()) + ";"
                + employee2.getSalary() + " rubles;" + System.lineSeparator()
                + employee3.getName() + ";"
                + employee3.getHired().getTime() + ";"
                + (employee3.getFired() == null ? "-" : employee3.getFired().getTime()) + ";"
                + employee3.getSalary() + " rubles;" + System.lineSeparator();
        assertEquals(expected, report);
    }

    /**
     * For IT: in HTML format.
     */
    @Test
    public void generateReportForItHtml() {
        ReportView rv = new ReportEngineItHtml(store);
        String report = rv.generate(predicate);
        String expected = "<html>" + System.lineSeparator()
                + "<head>" + System.lineSeparator()
                + "Name; Hired; Fired; Salary;" + System.lineSeparator()
                + "</head>" + System.lineSeparator()
                + "<body>" + System.lineSeparator()
                + employee1.getName() + ";"
                + employee1.getHired().getTime() + ";"
                + (employee1.getFired() == null ? "-" : employee1.getFired().getTime()) + ";"
                + employee1.getSalary() + ";" + System.lineSeparator()
                + employee2.getName() + ";"
                + employee2.getHired().getTime() + ";"
                + (employee2.getFired() == null ? "-" : employee2.getFired().getTime()) + ";"
                + employee2.getSalary() + ";" + System.lineSeparator()
                + employee3.getName() + ";"
                + employee3.getHired().getTime() + ";"
                + (employee3.getFired() == null ? "-" : employee3.getFired().getTime()) + ";"
                + employee3.getSalary() + ";" + System.lineSeparator()
                + "</body>" + System.lineSeparator()
                + "</html>" + System.lineSeparator();
        assertEquals(expected, report);
    }

    /**
     * For IT: in JSON format.
     */
    @Test
    public void generateReportForItJson() {
        ReportView rv = new ReportEngineItJson(store);
        String report = rv.generate(predicate);
        String expected = '{' + System.lineSeparator()
                + "\"employees\":[" + System.lineSeparator()
                + '{' + System.lineSeparator()
                + "\"Name\":"
                + '"' + employee1.getName() + '"'
                + ',' + System.lineSeparator()
                + "\"Hired\":"
                + '"' + employee1.getHired().getTime() + '"'
                + ',' + System.lineSeparator()
                + "\"Fired\":"
                + '"' + (employee1.getFired() == null ? '-' : employee1.getFired().getTime()) + '"'
                + ',' + System.lineSeparator()
                + "\"Salary\":" + employee1.getSalary() + System.lineSeparator()
                + "}," + System.lineSeparator()
                + '{' + System.lineSeparator()
                + "\"Name\":"
                + '"' + employee2.getName() + '"'
                + ',' + System.lineSeparator()
                + "\"Hired\":"
                + '"' + employee2.getHired().getTime() + '"'
                + ',' + System.lineSeparator()
                + "\"Fired\":"
                + '"' + (employee2.getFired() == null ? '-' : employee2.getFired().getTime()) + '"'
                + ',' + System.lineSeparator()
                + "\"Salary\":" + employee2.getSalary() + System.lineSeparator()
                + "}," + System.lineSeparator()
                + '{' + System.lineSeparator()
                + "\"Name\":"
                + '"' + employee3.getName() + '"'
                + ',' + System.lineSeparator()
                + "\"Hired\":"
                + '"' + employee3.getHired().getTime() + '"'
                + ',' + System.lineSeparator()
                + "\"Fired\":"
                + '"' + (employee3.getFired() == null ? '-' : employee3.getFired().getTime()) + '"'
                + ',' + System.lineSeparator()
                + "\"Salary\":" + employee3.getSalary() + System.lineSeparator()
                + "}" + System.lineSeparator()
                + ']' + System.lineSeparator()
                + '}' + System.lineSeparator();
        assertEquals(expected, report);
    }


    /**
     * For IT: in XML format.
     */
    @Test
    public void generateReportForItXml() {
        ReportView rv = new ReportEngineItXml(store);
        String report = rv.generate(predicate);
        String expected = "<?xml version=\"1.0\" encoding=\"WINDOWS-1251\"?>" + System.lineSeparator()
                + "<employees>" + System.lineSeparator()
                + "<employee>" + System.lineSeparator()
                + "<Name>" + System.lineSeparator()
                + employee1.getName() + System.lineSeparator()
                + "</Name>" + System.lineSeparator()
                + "<Hired>" + System.lineSeparator()
                + employee1.getHired().getTime() + System.lineSeparator()
                + "</Hired>" + System.lineSeparator()
                + "<Fired>" + System.lineSeparator()
                + (employee1.getFired() == null ? "-" : employee1.getFired().getTime()) + System.lineSeparator()
                + "</Fired>" + System.lineSeparator()
                + "<Salary>" + System.lineSeparator()
                + employee1.getSalary() + System.lineSeparator()
                + "</Salary>" + System.lineSeparator()
                + "</employee>" + System.lineSeparator()
                + "<employee>" + System.lineSeparator()
                + "<Name>" + System.lineSeparator()
                + employee2.getName() + System.lineSeparator()
                + "</Name>" + System.lineSeparator()
                + "<Hired>" + System.lineSeparator()
                + employee2.getHired().getTime() + System.lineSeparator()
                + "</Hired>" + System.lineSeparator()
                + "<Fired>" + System.lineSeparator()
                + (employee2.getFired() == null ? "-" : employee2.getFired().getTime()) + System.lineSeparator()
                + "</Fired>" + System.lineSeparator()
                + "<Salary>" + System.lineSeparator()
                + employee2.getSalary() + System.lineSeparator()
                + "</Salary>" + System.lineSeparator()
                + "</employee>" + System.lineSeparator()
                + "<employee>" + System.lineSeparator()
                + "<Name>" + System.lineSeparator()
                + employee3.getName() + System.lineSeparator()
                + "</Name>" + System.lineSeparator()
                + "<Hired>" + System.lineSeparator()
                + employee3.getHired().getTime() + System.lineSeparator()
                + "</Hired>" + System.lineSeparator()
                + "<Fired>" + System.lineSeparator()
                + (employee3.getFired() == null ? "-" : employee3.getFired().getTime()) + System.lineSeparator()
                + "</Fired>" + System.lineSeparator()
                + "<Salary>" + System.lineSeparator()
                + employee3.getSalary() + System.lineSeparator()
                + "</Salary>" + System.lineSeparator()
                + "</employee>" + System.lineSeparator()
                + "</employees>" + System.lineSeparator();
        assertEquals(expected, report);
    }
}
