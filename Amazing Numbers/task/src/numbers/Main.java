package numbers;

import java.util.Scanner;

import static numbers.Methods.checkMutuallyExclusive;
import static numbers.Methods.showNumberInfo;

public class Main {

    public static void instructions() {
        System.out.println("""
                            
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.""");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        instructions();
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter a request: ");
            String userInput = scanner.nextLine();
            if (userInput.equals("")) {
                instructions();
                continue;
            }

            String[] request = userInput.split(" ");
            long userNumber;
            long amount;

            // 1
            if (request.length == 1) {
                userNumber = Long.parseLong(request[0]);
                System.out.println();

                if (userNumber == 0) {
                    isRunning = false;
                } else if (userNumber < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else {

                    System.out.println("Properties of " + String.format("%,d", userNumber));
                    numbers.Methods.properties(userNumber);
                    System.out.println();
                }
                // 2
            } else if (request.length == 2) {
                userNumber = Long.parseLong(request[0]);
                amount = Long.parseLong(request[1]);


                if (userNumber < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if (amount < 0) {
                    System.out.println("The second parameter should be a natural number.");
                } else showNumberInfo(userNumber, amount);

                // 3
            } else if (request.length > 2) {
                userNumber = Long.parseLong(request[0]);
                amount = Long.parseLong(request[1]);
                //check for value
                if (userNumber < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if (amount < 0) {
                    System.out.println("Second parameter should be a natural number");

                } else if (!checkMutuallyExclusive(request)) {
                    showNumberInfo(userNumber, amount, request);
                }
            }

        }
            System.out.println("Goodbye!");
        }
    }
