package oop.oopdictionary.quizgame;

import java.util.Scanner;

public class WordQuizGame {

    private void generateWordQuiz() {
        // Quiz Questions and Answers
        String[] questions = {
                "Question 1: What does the word \"sophisticated\" primarily mean?\r\n" +
                        "A) Simple and ordinary\r\n" +
                        "B) Complex and refined\r\n" +
                        "C) Dull and uninspired\r\n" +
                        "D) Noisy and chaotic\r\n",
                "Question 2: What does the word \"configuration\" primarily mean?\r\n" +
                        "A) The arrangement or set-up of parts in a system\r\n" +
                        "B) A type of computer software\r\n" +
                        "C) A mathematical equation\r\n" +
                        "D) A specific computer model\r\n",
                "Question 3: What does the term \"graphics\" primarily refer to in the context of computing and technology?\r\n" +
                        "A) The physical appearance of a computer\r\n" +
                        "B) Computer programming languages\r\n" +
                        "C) Computer hardware components\r\n" +
                        "D) Visual images or designs displayed on a screen or printed on a surface\r\n",
                "Question 4: In the context of computers, what does the term \"network\" refer to?\r\n" +
                        "A) A group of people using the same computer\r\n" +
                        "B) A collection of interconnected computers and devices that can communicate and share resources\r\n" +
                        "C) A computer virus\r\n" +
                        "D) A type of computer software\r\n",
                "Question 5: In the context of retail, what does the term \"register\" refer to?\r\n" +
                        "A) The total number of customers in a store\r\n" +
                        "B) The list of products available for sale\r\n" +
                        "C) A device used to record sales transactions and handle payments\r\n" +
                        "D) The store's opening and closing hours\r\n",
        };

        char[] correctAnswers = {'B', 'A', 'D', 'B', 'C'};
        int score = 0;
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Enter the correct answer(A, B, C or D): ");

            String userAnswer = scanner.nextLine().toUpperCase();
            char[] chars = userAnswer.toCharArray();
            char as = userAnswer.charAt(0);
            if (as == correctAnswers[i] && userAnswer.length() == 1) {
                System.out.println("Correct!\n");
                score+=2;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctAnswers[i] + "\n");
            }
        }

        // Display the final score
        System.out.println("Your final score is: " + score + "/5");
        //scanner.close();
    }
    public void start(){
        generateWordQuiz();
    }

//    public static void main(String[] args) {
//        WordQuizGame game = new WordQuizGame();
//        game.start();
//    }
}