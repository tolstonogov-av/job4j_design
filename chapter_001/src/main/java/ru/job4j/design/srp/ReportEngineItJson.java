package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * Class for generating reports for IT in JSON format.
 *
 * @author Job4j, Tolstonogov Alexey
 */
public class ReportEngineItJson implements ReportView {
    /**
     * Store with employees's data.
     */
    private final Store store;

    /**
     * Constructor, that fills the store.
     *
     * @param store store
     */
    public ReportEngineItJson(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(start());
        for (Employee employee : store.findBy(filter)) {
            text.append(row(employee));
        }
        text.deleteCharAt(text.lastIndexOf(","));
        text.append(end());
        return text.toString();
    }

    public String start() {
        return '{' + System.lineSeparator()
                + "\"employees\":[" + System.lineSeparator();
    }

    public String row(Employee employee) {
        return '{' + System.lineSeparator()
                + "\"Name\":"
                + '"' + employee.getName() + '"'
                + ',' + System.lineSeparator()
                + "\"Hired\":"
                + '"' + employee.getHired().getTime() + '"'
                + ',' + System.lineSeparator()
                + "\"Fired\":"
                + '"' + (employee.getFired() == null ? '-' : employee.getFired().getTime()) + '"'
                + ',' + System.lineSeparator()
                + "\"Salary\":" + employee.getSalary() + System.lineSeparator()
                + "}," + System.lineSeparator();
    }

    public String end() {
        return ']' + System.lineSeparator()
                + '}' + System.lineSeparator();
    }
}
