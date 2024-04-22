package se.lexicon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExceptionsDemo {
    public static void main(String[] args) {
        // checked-exception
        // BufferedReader reader = Files.newBufferedReader(Paths.get("dir/skills.txt"));

        // unchecked-exception
        // int[] numbers = {1, 2, 3, 4};
        // System.out.println(numbers[5]);

        //double decimalInput = takeDecimalInput();
        //System.out.println("Decimal Input: " + decimalInput);


        //double decimalInput = takeDecimalInput.get();
        //System.out.println("Decimal Input: " + decimalInput);

        //System.out.println("Date: " + takeDate.get());

        //readTextFile();

        writeTextToFile();


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

    public static Supplier<LocalDate> takeDate = () -> {
        Scanner scanner = new Scanner(System.in);
        LocalDate date;
        while (true) {
            try {
                System.out.println("Enter a date (yyyy-MM-dd): ");
                String input = scanner.nextLine();
                date = LocalDate.parse(input);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format. " + e.getMessage());
                //e.printStackTrace();
            }
        } // while loop

        return date;
    };


    public static void readTextFile() {
        // java.nio
        // https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html

        // absolute path
        String absolutePath = "D:\\lexicon\\g49\\projects\\g49-exceptions-files\\dir\\skills.txt";
        // relative path
        String relativePath = "dir/skills.txt";
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(relativePath));
            //Stream<String> stringStream = reader.lines();
            //List<String> skills = stringStream.collect(Collectors.toList());
            //skills.forEach(System.out::println);

            reader
                    .lines()
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

            List<String> skills = Files.readAllLines(Paths.get(relativePath));
            skills.forEach(System.out::println);

        } catch (NoSuchFileException e) {
            System.out.println("File not found:" + e.getFile());
        } catch (IOException e) {
            System.out.println("An error occurred  while reading the file." + e);
        }

    }

    public static void readImageAndCopyToDestinationDirectory() {
        // todo: read the image file and copy it into the destination directory, if the file exist in the destination directory replace it
    }

    public static void writeTextToFile() {
        Path skillsFilePath = Paths.get("dir/skills.txt");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(skillsFilePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            writer.append("React");
            writer.newLine();
            System.out.println("Operation is Done");
            //writer.close();
        } catch (IOException e) {
            // todo: display a proper message
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Allocated resources are released...");

        }


    }


    public static void writeTextToFileTryWithRecourses() {
        Path skillsFilePath = Paths.get("dir/skills.txt");
        try (
                BufferedWriter writer = Files.newBufferedWriter(skillsFilePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        ) {

            writer.append("React");
            writer.newLine();
            System.out.println("Operation is Done");
            //writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
