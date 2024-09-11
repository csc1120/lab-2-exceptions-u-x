/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Leonardo Borrelli
 * Last Updated: 9/11/2024
 */
package borrellil;

import java.util.Random;

/**
 * Main class for all new dice.
 */
public class Die {
    /**
     * Minimum amount of sides a die should have.
     */
    public final int MIN_SIDES = 2;
    /**
     * Maximum amount of sides a die should have.
     */
    public final int MAX_SIDES = 100;
    private int currentValue;
    private int numSides;
    private final Random random = new Random();

    /**
     * Default constructor for a die.
     * @param numSides Number of sides in new die.
     */
    public Die(int numSides) {
        try {
            this.numSides = numSides;
        } catch (IllegalArgumentException e) {
            System.out.println("An illegal argument exception was thrown.");
        }
    }

    /**
     * Obtain the current value of the die and reset it to 0.
     * @return Returns the current value of the die.
     * @throws DieNotRolledException Thrown if the die is outside of the possible roll range.
     */
    public int getCurrentValue() throws DieNotRolledException {
        int dieVal;
        if (currentValue < 1 && currentValue > numSides) {
            throw new DieNotRolledException("Die value outside of possible range.");
        } else {
            dieVal = currentValue;
        }
        currentValue = 0;
        return dieVal;
    }

    /**
     * Roll a die by generating a random number between 1 and the amount of sides the die has.
     */
    public void roll() {
        currentValue = 1 + random.nextInt(1, numSides);
    }
}