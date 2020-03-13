package design.srp;

import java.util.function.Predicate;

/**
 * Class for generating reports for accounting.
 *
 * @author Job4j, Tolstonogov Alexey
 */
public class ReportEngineAccounting implements ReportView {
    /**
     * Store with employees's data.
     */
    private final Store store;

    /**
     * Constructor, that fills the store.
     *
     * @param store store
     */
    public ReportEngineAccounting(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(start());
        for (Employee employee : store.findBy(filter)) {
            text.append(row(employee));
        }
        return text.toString();
    }

    public String start() {
        return "Name; Hired; Fired; Salary;" + System.lineSeparator();
    }

    public String row(Employee employee) {
        return employee.getName() + ";"
                + employee.getHired().getTime() + ";"
                + (employee.getFired() == null ? "-" : employee.getFired().getTime()) + ";"
                + employee.getSalary() + " rubles;" + System.lineSeparator();
    }

    public String end() {
        return "";
    }
}
