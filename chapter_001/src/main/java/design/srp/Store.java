package design.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Interface that described access to BD.
 *
 * @author Job4j
 */
public interface Store {
    /**
     * Finds all employees, who satisfy the condition.
     *
     * @param filter condition
     * @return list of employees
     */
    List<Employee> findBy(Predicate<Employee> filter);
}
