import java.util.Scanner;

///QuizGame.java
///This program simulates a simple 5-question multiple-choice quiz.
///It tracks the user's score and calculates a final percentage.
///Course: CS 1102 - Programming 1
public class QuizGame {

    public static void main(String[] args) {
        /* Initialize the Scanner to read user input */
        Scanner scanner = new Scanner(System.in);

        // Variables to track the score
        int correctAnswers = 0;
        int totalQuestions = 5;

        System.out.println("Welcome to the CS 1102 Java Quiz!");
        System.out.println("Please enter your answer as a single letter: A, B, C, or D.\n");

        /* --- Question 1 --- */
        System.out.println("1. Which data type is used to store a single character in Java?");
        System.out.println("A. String\nB. char\nC. int\nD. float");
        System.out.print("Your answer: ");
        String answer1 = scanner.next().toUpperCase(); // Input validation: convert to uppercase

        // Using switch-case to handle the answer
        switch (answer1) {
            case "B":
                System.out.println("Correct!");
                correctAnswers++;
                break;
            default:
                System.out.println("Incorrect. The correct answer was B.");
                break;
        }
        System.out.println();

        // --- Question 2 ---
        System.out.println("2. What is the result of 5 + 2 * 3?");
        System.out.println("A. 21\nB. 10\nC. 11\nD. 15");
        System.out.print("Your answer: ");
        String answer2 = scanner.next().toUpperCase();

        if (answer2.equals("C")) {
            System.out.println("Correct!");
            correctAnswers++;
        } else {
            System.out.println("Incorrect. Remember operator precedence: multiplication comes first!");
        }
        System.out.println();

        // --- Question 3 ---
        System.out.println("3. Which of these is a valid Java identifier?");
        System.out.println("A. 123variable\nB. _myVar\nC. class\nD. my Variable");
        System.out.print("Your answer: ");
        String answer3 = scanner.next().toUpperCase();

        switch (answer3) {
            case "B":
                System.out.println("Correct!");
                correctAnswers++;
                break;
            default:
                System.out.println("Incorrect. Identifiers can't start with numbers or contain spaces.");
                break;
        }
        System.out.println();

        // --- Question 4 ---
        System.out.println("4. Which operator is used for a logical AND?");
        System.out.println("A. ||\nB. !\nC. &\nD. &&");
        System.out.print("Your answer: ");
        String answer4 = scanner.next().toUpperCase();

        if (answer4.equals("D")) {
            System.out.println("Correct!");
            correctAnswers++;
        } else {
            System.out.println("Incorrect. && is the logical AND operator.");
        }
        System.out.println();

        // --- Question 5 ---
        System.out.println("5. Which keyword is used to declare a constant in Java?");
        System.out.println("A. final\nB. static\nC. constant\nD. fixed");
        System.out.print("Your answer: ");
        String answer5 = scanner.next().toUpperCase();

        switch (answer5) {
            case "A":
                System.out.println("Correct!");
                correctAnswers++;
                break;
            default:
                System.out.println("Incorrect. The 'final' keyword makes a variable constant.");
                break;
        }
        System.out.println();

        // --- Final Score Calculation ---
        double percentage = ((double) correctAnswers / totalQuestions) * 100;

        System.out.println("--- Quiz Complete ---");
        System.out.println("Correct Responses: " + correctAnswers + " out of " + totalQuestions);
        System.out.printf("Your Final Score: %.1f%%\n", percentage);

        // Close the scanner
        scanner.close();
    }
}