package ru.job4j.design.srp;

import java.util.function.Predicate;

public interface ReportView {
    /**
     * Generates a report with employees who meet the specific condition.
     *
     * @param filter specific condition
     * @return the generated report
     */
    String generate(Predicate<Employee> filter);

    /**
     * Generates the header of the report.
     *
     * @return header of the report
     */
    String start();

    /**
     * Generates the row in the report.
     *
     * @param employee employee, for which the row is generated
     * @return row in the report
     */
    String row(Employee employee);

    /**
     * Generates the footer of the report.
     *
     * @return footer of the report
     */
    String end();
}
