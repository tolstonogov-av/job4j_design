package design.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Class for generating reports for HR.
 *
 * @author Job4j, Tolstonogov Alexey
 */
public class ReportEngineHr implements ReportView {
    /**
     * Store with employees's data.
     */
    private final Store store;

    /**
     * Constructor, that fills the store.
     *
     * @param store store
     */
    public ReportEngineHr(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(start());
        List<Employee> employees = store.findBy(filter);
        employees.sort((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
        for (Employee employee : employees) {
            text.append(row(employee));
        }
        return text.toString();
    }

    public String start() {
        return "Name; Salary;" + System.lineSeparator();
    }

    public String row(Employee employee) {
        return employee.getName() + ";"
                + employee.getSalary() + ";" + System.lineSeparator();
    }

    public String end() {
        return "";
    }
}
