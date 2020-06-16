package ru.job4j.menu.actions;

/**
 * Interface for action without parameters - actionWithoutParameters.
 * Also extends interface Action (getNameOperation).
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface ActionWithoutParameters extends Action {

    /**
     * Does action without parameters.
     *
     * @return result of action
     */
    String actionWithoutParameters();
}
