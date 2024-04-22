package se.lexicon;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

public class ExceptionsDemo {
    public static void main(String[] args) {
        // checked-exception
        // BufferedReader reader = Files.newBufferedReader(Paths.get("dir/skills.txt"));

        // unchecked-exception
        // int[] numbers = {1, 2, 3, 4};
        // System.out.println(numbers[5]);

        //double decimalInput = takeDecimalInput();
        //System.out.println("Decimal Input: " + decimalInput);


        double decimalInput = takeDecimalInput.get();
        System.out.println("Decimal Input: " + decimalInput);


    }

    public static double takeDecimalInput() {
        Scanner scanner = new Scanner(System.in);
        double number;
        while (true) {
            try {
                System.out.println("Enter a Number: ");
                number = scanner.nextDouble(); // is to read sequence of numbers, skipping the whitespace
                break;
            } catch (InputMismatchException e) {
                System.out.println("Number is not Valid.");
                scanner.next(); // consume invalid input to avoid an infinitive loop
            }
        } // while loop
        return number;
    }
    public static Supplier<Double> takeDecimalInput = () -> {
        Scanner scanner = new Scanner(System.in);
        double number;
        while (true) {
            try {
                System.out.println("Enter a Number: ");
                number = scanner.nextDouble(); // is to read sequence of numbers, skipping the whitespace
                break;
            } catch (InputMismatchException e) {
                System.out.println("Number is not Valid.");
                scanner.next(); // consume invalid input to avoid an infinitive loop
            }
        } // while loop
        return number;
    };




}
