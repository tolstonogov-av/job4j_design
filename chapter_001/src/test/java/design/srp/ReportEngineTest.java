package design.srp;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test class ReportEngine.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ReportEngineTest {
    /**
     * One of the employees in company.
     */
    private Employee employee1 = new Employee(
            "Sam",
            new GregorianCalendar(2010, Calendar.APRIL, 4),
            new GregorianCalendar(2016, Calendar.FEBRUARY, 10),
            10000d);

    /**
     * One of the employees in company.
     */
    private Employee employee2 = new Employee(
            "Ban",
            new GregorianCalendar(2017, Calendar.NOVEMBER, 17),
            null,
            12800d);

    /**
     * One of the employees in company.
     */
    private Employee employee3 = new Employee(
            "Luma",
            new GregorianCalendar(2007, Calendar.JANUARY, 5),
            null,
            9000d);

    /**
     * One of the employees in company.
     */
    private Employee employee4 = new Employee(
            "Garek",
            new GregorianCalendar(2015, Calendar.MAY, 31),
            new GregorianCalendar(2015, Calendar.AUGUST, 3),
            5000d);

    /**
     * The condition, which is used for selection of employees into the report.
     */
    private Predicate<Employee> predicate = new Predicate<>() {
        @Override
        public boolean test(Employee employee) {
            return employee.getSalary() > 5000d;
        }
    };

    /**
     * The employees storage.
     * Method findBy() finds all employees, who satisfy the condition.
     */
    private Store store = new Store() {
        @Override
        public List<Employee> findBy(Predicate<Employee> filter) {
            List<Employee> result = new ArrayList<>();
            if (filter.test(employee1)) {
                result.add(employee1);
            }
            if (filter.test(employee2)) {
                result.add(employee2);
            }
            if (filter.test(employee3)) {
                result.add(employee3);
            }
            if (filter.test(employee4)) {
                result.add(employee4);
            }
            return result;
        }
    };

    /**
     * For HR: without hired, fired; with sorting by salary in descending order.
     */
    @Test
    public void whenGenerateReportForHrThenGenerateTextForHrReport() {
        ReportView rv = new ReportEngineHr(store);
        String report = rv.generate(predicate);
        String expect = new StringBuilder()
                .append("Name; Salary;").append(System.lineSeparator())
                .append(employee2.getName()).append(";")
                .append(employee2.getSalary()).append(";").append(System.lineSeparator())
                .append(employee1.getName()).append(";")
                .append(employee1.getSalary()).append(";").append(System.lineSeparator())
                .append(employee3.getName()).append(";")
                .append(employee3.getSalary()).append(";").append(System.lineSeparator()).toString();
        assertThat(report, is(expect));
    }

    /**
     * For Accounting: with rubles in salary.
     */
    @Test
    public void whenGenerateForAccountingReportThenGenerateTextForAccountingReport() {
        ReportView rv = new ReportEngineAccounting(store);
        String report = rv.generate(predicate);
        String expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;").append(System.lineSeparator())
                .append(employee1.getName()).append(";")
                .append(employee1.getHired().getTime()).append(";")
                .append(employee1.getFired() == null ? "-" : employee1.getFired().getTime()).append(";")
                .append(employee1.getSalary()).append(" rubles;").append(System.lineSeparator())
                .append(employee2.getName()).append(";")
                .append(employee2.getHired().getTime()).append(";")
                .append(employee2.getFired() == null ? "-" : employee2.getFired().getTime()).append(";")
                .append(employee2.getSalary()).append(" rubles;").append(System.lineSeparator())
                .append(employee3.getName()).append(";")
                .append(employee3.getHired().getTime()).append(";")
                .append(employee3.getFired() == null ? "-" : employee3.getFired().getTime()).append(";")
                .append(employee3.getSalary()).append(" rubles;").append(System.lineSeparator()).toString();
        assertThat(report, is(expect));
    }

    /**
     * For IT: in HTML format.
     */
    @Test
    public void whenGenerateForItReportThenGenerateTextForItReport() {
        ReportView rv = new ReportEngineItHtml(store);
        String report = rv.generate(predicate);
        String expect = new StringBuilder()
                .append("<html>").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append(employee1.getName()).append(";")
                .append(employee1.getHired().getTime()).append(";")
                .append(employee1.getFired() == null ? "-" : employee1.getFired().getTime()).append(";")
                .append(employee1.getSalary()).append(";").append(System.lineSeparator())
                .append(employee2.getName()).append(";")
                .append(employee2.getHired().getTime()).append(";")
                .append(employee2.getFired() == null ? "-" : employee2.getFired().getTime()).append(";")
                .append(employee2.getSalary()).append(";").append(System.lineSeparator())
                .append(employee3.getName()).append(";")
                .append(employee3.getHired().getTime()).append(";")
                .append(employee3.getFired() == null ? "-" : employee3.getFired().getTime()).append(";")
                .append(employee3.getSalary()).append(";").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator()).toString();
        assertThat(report, is(expect));
    }

    /**
     * For IT: in JSON format.
     */
    @Test
    public void whenGenerateForJsonReportThenGenerateTextForJsonReport() {
        ReportView rv = new ReportEngineItJson(store);
        String report = rv.generate(predicate);
        String expect = new StringBuilder()
                .append('{').append(System.lineSeparator())
                .append("\"employees\":[").append(System.lineSeparator())
                .append('{').append(System.lineSeparator())
                .append("\"Name\":")
                .append('"').append(employee1.getName()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Hired\":")
                .append('"').append(employee1.getHired().getTime()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Fired\":")
                .append('"').append(employee1.getFired() == null ? '-' : employee1.getFired().getTime()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Salary\":").append(employee1.getSalary()).append(System.lineSeparator())
                .append("},").append(System.lineSeparator())
                .append('{').append(System.lineSeparator())
                .append("\"Name\":")
                .append('"').append(employee2.getName()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Hired\":")
                .append('"').append(employee2.getHired().getTime()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Fired\":")
                .append('"').append(employee2.getFired() == null ? '-' : employee2.getFired().getTime()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Salary\":").append(employee2.getSalary()).append(System.lineSeparator())
                .append("},").append(System.lineSeparator())
                .append('{').append(System.lineSeparator())
                .append("\"Name\":")
                .append('"').append(employee3.getName()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Hired\":")
                .append('"').append(employee3.getHired().getTime()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Fired\":")
                .append('"').append(employee3.getFired() == null ? '-' : employee3.getFired().getTime()).append('"')
                .append(',').append(System.lineSeparator())
                .append("\"Salary\":").append(employee3.getSalary()).append(System.lineSeparator())
                .append("}").append(System.lineSeparator())
                .append(']').append(System.lineSeparator())
                .append('}').append(System.lineSeparator()).toString();
        assertThat(report, is(expect));
    }


    /**
     * For IT: in XML format.
     */
    @Test
    public void whenGenerateForXmlReportThenGenerateTextForXmlReport() {
        ReportView rv = new ReportEngineItXml(store);
        String report = rv.generate(predicate);
        String expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"WINDOWS-1251\"?>").append(System.lineSeparator())
                .append("<employees>").append(System.lineSeparator())
                .append("<employee>").append(System.lineSeparator())
                .append("<Name>").append(System.lineSeparator())
                .append(employee1.getName()).append(System.lineSeparator())
                .append("</Name>").append(System.lineSeparator())
                .append("<Hired>").append(System.lineSeparator())
                .append(employee1.getHired().getTime()).append(System.lineSeparator())
                .append("</Hired>").append(System.lineSeparator())
                .append("<Fired>").append(System.lineSeparator())
                .append(employee1.getFired() == null ? "-" : employee1.getFired().getTime()).append(System.lineSeparator())
                .append("</Fired>").append(System.lineSeparator())
                .append("<Salary>").append(System.lineSeparator())
                .append(employee1.getSalary()).append(System.lineSeparator())
                .append("</Salary>").append(System.lineSeparator())
                .append("</employee>").append(System.lineSeparator())
                .append("<employee>").append(System.lineSeparator())
                .append("<Name>").append(System.lineSeparator())
                .append(employee2.getName()).append(System.lineSeparator())
                .append("</Name>").append(System.lineSeparator())
                .append("<Hired>").append(System.lineSeparator())
                .append(employee2.getHired().getTime()).append(System.lineSeparator())
                .append("</Hired>").append(System.lineSeparator())
                .append("<Fired>").append(System.lineSeparator())
                .append(employee2.getFired() == null ? "-" : employee2.getFired().getTime()).append(System.lineSeparator())
                .append("</Fired>").append(System.lineSeparator())
                .append("<Salary>").append(System.lineSeparator())
                .append(employee2.getSalary()).append(System.lineSeparator())
                .append("</Salary>").append(System.lineSeparator())
                .append("</employee>").append(System.lineSeparator())
                .append("<employee>").append(System.lineSeparator())
                .append("<Name>").append(System.lineSeparator())
                .append(employee3.getName()).append(System.lineSeparator())
                .append("</Name>").append(System.lineSeparator())
                .append("<Hired>").append(System.lineSeparator())
                .append(employee3.getHired().getTime()).append(System.lineSeparator())
                .append("</Hired>").append(System.lineSeparator())
                .append("<Fired>").append(System.lineSeparator())
                .append(employee3.getFired() == null ? "-" : employee3.getFired().getTime()).append(System.lineSeparator())
                .append("</Fired>").append(System.lineSeparator())
                .append("<Salary>").append(System.lineSeparator())
                .append(employee3.getSalary()).append(System.lineSeparator())
                .append("</Salary>").append(System.lineSeparator())
                .append("</employee>").append(System.lineSeparator())
                .append("</employees>").append(System.lineSeparator()).toString();
        assertThat(report, is(expect));
    }
}
