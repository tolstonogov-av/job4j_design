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
    private Store store;

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
        return new StringBuilder()
                .append("Name; Hired; Fired; Salary;").append(System.lineSeparator()).toString();
    }

    public String row(Employee employee) {
        return new StringBuilder()
                .append(employee.getName()).append(";")
                .append(employee.getHired().getTime()).append(";")
                .append(employee.getFired() == null ? "-" : employee.getFired().getTime()).append(";")
                .append(employee.getSalary()).append(" rubles;").append(System.lineSeparator()).toString();
    }

    public String end() {
        return "";
    }
}
