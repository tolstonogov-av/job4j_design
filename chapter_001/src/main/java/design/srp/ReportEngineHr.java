package design.srp;

import java.util.Comparator;
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
    private Store store;

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
        employees.sort(new Comparator<>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getSalary() - o1.getSalary());
            }
        });
        for (Employee employee : employees) {
            text.append(row(employee));
        }
        return text.toString();
    }

    public String start() {
        return new StringBuilder()
                .append("Name; Salary;").append(System.lineSeparator()).toString();
    }

    public String row(Employee employee) {
        return new StringBuilder()
                .append(employee.getName()).append(";")
                .append(employee.getSalary()).append(";").append(System.lineSeparator()).toString();
    }

    public String end() {
        return "";
    }
}
