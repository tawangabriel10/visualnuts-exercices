package com.visualnuts.exercice01;

import com.visualnuts.exceptions.VisualNutsException;

public class Exercice01 {

    private static final Integer INITIAL_NUMBER = 1;
    private static final Integer FINAL_NUMBER = 100;

    public static void main(String[] args) {
        System.out.println("Begin execution exercice one...");

        doExercice(INITIAL_NUMBER, FINAL_NUMBER);

        System.out.println("Finish execution exercice one...");
    }

    /**
     * Method responsible for to execution logic of exercice 01
     * @param initialNumber
     * @param finalNumber
     */
    public static void doExercice(Integer initialNumber, Integer finalNumber) {
        if (initialNumber > finalNumber) {
            throw new VisualNutsException("Initial number can'' be greater than final number");
        }

        for (int num = initialNumber.intValue(); num <= finalNumber; num++) {
            if(num % 3 == 0 && num % 5 == 0) {
                System.out.println("Visual Nuts");
            } else if (num % 3 == 0) {
                System.out.println("Visual");
            } else if (num % 5 == 0) {
                System.out.println("Nuts");
            } else {
                System.out.println(num);
            }
        }
    }
}
