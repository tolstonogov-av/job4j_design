package ru.job4j.menu.actions;

/**
 * Class for print some message.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class PrintMessageAction implements ActionWithoutParameters {

    @Override
    public String getNameOperation() {
        return "Print \"Hello\"";
    }

    @Override
    public String actionWithoutParameters() {
        return "Hello.";
    }
}
