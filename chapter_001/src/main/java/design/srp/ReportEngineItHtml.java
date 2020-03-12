package design.srp;

import java.util.function.Predicate;

/**
 * Class for generating reports for IT in HTML format.
 *
 * @author Job4j, Tolstonogov Alexey
 */
public class ReportEngineItHtml implements ReportView {
    /**
     * Store with employees's data.
     */
    private final Store store;

    /**
     * Constructor, that fills the store.
     *
     * @param store store
     */
    public ReportEngineItHtml(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(start());
        for (Employee employee : store.findBy(filter)) {
            text.append(row(employee));
        }
        text.append(end());
        return text.toString();
    }

    public String start() {
        return "<html>" + System.lineSeparator() +
                "<head>" + System.lineSeparator() +
                "Name; Hired; Fired; Salary;" + System.lineSeparator() +
                "</head>" + System.lineSeparator() +
                "<body>" + System.lineSeparator();
    }

    public String row(Employee employee) {
        return employee.getName() + ";" +
                employee.getHired().getTime() + ";" +
                (employee.getFired() == null ? "-" : employee.getFired().getTime()) + ";" +
                employee.getSalary() + ";" + System.lineSeparator();
    }

    public String end() {
        return "</body>" + System.lineSeparator() +
                "</html>" + System.lineSeparator();
    }
}
