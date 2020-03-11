package design.srp;

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
    private Store store;

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
        return new StringBuilder()
                .append('{').append(System.lineSeparator())
                .append("\"employees\":[").append(System.lineSeparator()).toString();
    }

    public String row(Employee employee) {
        return new StringBuilder()
                .append('{').append(System.lineSeparator())
                .append("\"Name\":")
                .append('"').append(employee.getName()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Hired\":")
                .append('"').append(employee.getHired().getTime()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Fired\":")
                .append('"').append(employee.getFired() == null ? '-' : employee.getFired().getTime()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Salary\":").append(employee.getSalary()).append(System.lineSeparator())
                .append("},").append(System.lineSeparator()).toString();
    }

    public String end() {
        return new StringBuilder()
                .append(']').append(System.lineSeparator())
                .append('}').append(System.lineSeparator()).toString();
    }
}
