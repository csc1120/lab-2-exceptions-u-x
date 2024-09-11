/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Leonardo Borrelli
 * Last Updated: 9/11/2024
 */
package borrellil;

import java.util.Scanner;

/**
 * Primary driver class for dice rolling program.
 */
public class Driver {
    /**
     * Function that obtains input from the user to create dice.
     * @return An array of numbers containing the amount of dice, their sides,
     * and how many times to roll the dice.
     */
    public static int[] getInput() {
        int[] input = new int[3];
        boolean validInput = false;
        Scanner read = new Scanner(System.in);
        while (!validInput) {
            System.out.println("Please enter the number of dice to roll," +
                    " how many sides the dice have,");
            System.out.println("and how many rolls to complete, separating the values by a space.");
            System.out.println("Example: \"2 6 1000\"\n");
            System.out.print("Enter configuration: ");
            String config = read.nextLine();
            String[] formattedConfig = config.split(" ");
            if (formattedConfig.length < 3) {
                System.out.println("Expected 3 values. Received " + formattedConfig.length + ".");
                continue;
            }
            boolean numbersValid = true;
            for (int i = 0; i < 3; i++) {
                try {
                    input[i] = Integer.parseInt(formattedConfig[i]);
                } catch (NumberFormatException e) {
                    numbersValid = false;
                }
            }
            if (input[1] > Die.MAX_SIDES || input[1] < Die.MIN_SIDES) {
                System.out.println("Bad die creation: Illegal number of sides: " + input[1]);
                continue;
            }
            if (!numbersValid) {
                System.out.println("Invalid input: All values must be whole numbers.");
                continue;
            }
            validInput = true;
        }
        return input;
    }

    /**
     * Function that creates Die objects that fit a criteria input.
     * @param numDice Amount of Die objects to create.
     * @param numSides Amount of sides each Die object should contain.
     * @return An array of Die objects.
     */
    public static Die[] createDice(int numDice, int numSides) {
        Die[] dice = new Die[numDice];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die(numSides);
        }
        return dice;
    }

    /**
     * Roll the dice and give them values.
     * @param dice Array of dice to roll.
     * @param numSides Number of sides each dice has.
     * @param numRolls Number of rolls to generate for each dice.
     * @return An array of totals of the dice rolls.
     */
    public static int[] rollDice(Die[] dice, int numSides, int numRolls) {
        int[] rolls = new int[(numSides * dice.length) - dice.length];
        for (int i = 0; i < numRolls; i++) {
            for (Die d : dice) {
                d.roll();
                int roll = d.getCurrentValue();
                rolls[roll - dice.length] += 1;
            }
        }
        return rolls;
    }

    /**
     * A method for finding the highest total of rolls within a roll set.
     * @param rolls Array of rolls to read.
     * @return The highest total of rolls.
     */
    public static int findMax(int[] rolls) {
        int highest = 0;
        for (int i : rolls) {
            if (i > highest) {
                highest = i;
            }
        }
        return highest;
    }
    public static void main(String[] args) {
        int[] userInput = getInput();
        Die[] dice = createDice(userInput[0], userInput[1]);
        int[] results = rollDice(dice, userInput[1], userInput[2]);
        int highest = findMax(results);
    }
}