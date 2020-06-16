package ru.job4j.menu.actions;

/**
 * Interface for action with parameters - actionWithParameters.
 * Also extends interface Action (getNameOperation).
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface ActionWithParameters extends Action {

    /**
     * Does action with parameters.
     *
     * @return result of action
     */
    int actionWithParameters(int param1, int param2);
}
