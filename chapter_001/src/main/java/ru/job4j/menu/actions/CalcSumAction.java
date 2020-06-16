package ru.job4j.menu.actions;

/**
 * Class for calculating sum of two operands.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class CalcSumAction implements ActionWithParameters {

    @Override
    public String getNameOperation() {
        return "Calculation of sum";
    }

    @Override
    public int actionWithParameters(int param1, int param2) {
        return param1 + param2;
    }
}
