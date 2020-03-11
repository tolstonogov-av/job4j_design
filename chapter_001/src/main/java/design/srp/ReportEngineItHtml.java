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
    private Store store;

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
        return new StringBuilder()
                .append("<html>").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator()).toString();
    }

    public String row(Employee employee) {
        return new StringBuilder()
                .append(employee.getName()).append(";")
                .append(employee.getHired().getTime()).append(";")
                .append(employee.getFired() == null ? "-" : employee.getFired().getTime()).append(";")
                .append(employee.getSalary()).append(";").append(System.lineSeparator()).toString();
    }

    public String end() {
        return new StringBuilder()
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator()).toString();
    }
}
