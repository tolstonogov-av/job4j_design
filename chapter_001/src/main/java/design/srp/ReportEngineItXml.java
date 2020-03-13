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
    private final Store store;

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
        return "<?xml version=\"1.0\" encoding=\"WINDOWS-1251\"?>" + System.lineSeparator()
                + "<employees>" + System.lineSeparator();
    }

    public String row(Employee employee) {
        return "<employee>" + System.lineSeparator()
                + "<Name>" + System.lineSeparator()
                + employee.getName() + System.lineSeparator()
                + "</Name>" + System.lineSeparator()
                + "<Hired>" + System.lineSeparator()
                + employee.getHired().getTime() + System.lineSeparator()
                + "</Hired>" + System.lineSeparator()
                + "<Fired>" + System.lineSeparator()
                + (employee.getFired() == null ? "-" : employee.getFired().getTime()) + System.lineSeparator()
                + "</Fired>" + System.lineSeparator()
                + "<Salary>" + System.lineSeparator()
                + employee.getSalary() + System.lineSeparator()
                + "</Salary>" + System.lineSeparator()
                + "</employee>" + System.lineSeparator();
    }

    public String end() {
        return "</employees>" + System.lineSeparator();
    }
}
