/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Leonardo Borrelli
 * Last Updated: 9/11/2024
 */
package borrellil;

/**
 * Custom exception telling the user that the die wasn't rolled, extended from RuntimeException.
 */
public class DieNotRolledException extends RuntimeException {
    private final String message;

    /**
     * Constructor from RuntimeException, reused within new custom exception.
     * @param message Custom error message, which will be provided within code.
     */
    public DieNotRolledException(String message) {
        super(message);
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
