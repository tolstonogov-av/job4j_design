package design.srp;

import java.util.function.Predicate;

/**
 * Class for generating reports for IT in XML format.
 *
 * @author Job4j, Tolstonogov Alexey
 */
public class ReportEngineItXml implements ReportView {
    /**
     * Store with employees's data.
     */
    private Store store;

    /**
     * Constructor, that fills the store.
     *
     * @param store store
     */
    public ReportEngineItXml(Store store) {
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
                .append("<?xml version=\"1.0\" encoding=\"WINDOWS-1251\"?>").append(System.lineSeparator())
                .append("<employees>").append(System.lineSeparator()).toString();
    }

    public String row(Employee employee) {
        return new StringBuilder()
                .append("<employee>").append(System.lineSeparator())
                .append("<Name>").append(System.lineSeparator())
                .append(employee.getName()).append(System.lineSeparator())
                .append("</Name>").append(System.lineSeparator())
                .append("<Hired>").append(System.lineSeparator())
                .append(employee.getHired().getTime()).append(System.lineSeparator())
                .append("</Hired>").append(System.lineSeparator())
                .append("<Fired>").append(System.lineSeparator())
                .append(employee.getFired() == null ? "-" : employee.getFired().getTime()).append(System.lineSeparator())
                .append("</Fired>").append(System.lineSeparator())
                .append("<Salary>").append(System.lineSeparator())
                .append(employee.getSalary()).append(System.lineSeparator())
                .append("</Salary>").append(System.lineSeparator())
                .append("</employee>").append(System.lineSeparator()).toString();
    }

    public String end() {
        return new StringBuilder()
                .append("</employees>").append(System.lineSeparator()).toString();
    }
}
