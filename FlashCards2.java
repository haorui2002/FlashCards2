/**
 * ============================================================================
 *
 * Class FlashCards2
 *
 * File: FlashCards2.java
 *
 * =============================
 *
 * @author: Hally Zhou, under Mr. John Engle's project https://drive.google.com/file/d/1IBtIbnm2hOP4tTL7dGiV-72O1a306gZ-/view with unknown license
 * Course: AP Computer Science - Blue 1
 * Date: October 29, 2018
 * Version: https://github.com/haorui2002/FlashCards2/commit/master
 * GO CUBS GO
 * I feel like your program is too advance for now, even that is the way that we should write it,
 * which is, reusing repeated codes.
 */

//The Fear of {{{{{{{{{{Luci and Ramen}}}}}}}}}} again after 2 years of not writing in C
import java.util.Scanner;
import java.util.Random;
//to have more fun, RANDOM!

public class FlashCards2 {
    /**
     * -------------------------------
     * Declare Constants
     * -------------------------------
     */

    private static final String MARQUEE = "========================================================";

    private static final int FIRST_GRADE = 1;
    private static final int SECOND_GRADE = 2;
    private static final int THIRD_GRADE = 3;

    private static final int FORTH_GRADE = 4;
    private static final int FIFTH_GRADE = 5;
    private static final int SIXTH_GRADE = 6;

    //here, input 1 = first_grade, 2, 3, ...

    //added 3 more grades
    private static final int FIRST_GRADE_QUESTIONS_CNT = 4;
    private static final int SECOND_GRADE_QUESTIONS_CNT = 7;
    private static final int THIRD_GRADE_QUESTIONS_CNT = 10;

    //private static final int FORTH_GRADE_QUESTIONS_CNT = 13; no need
    private static final int FIFTH_GRADE_QUESTIONS_CNT = 10;
    private static final int SIXTH_GRADE_QUESTIONS_CNT = 4;
    //set numbers of questions
    //rescaled

    /**
     * -------------------------------
     * Main Method
     * -------------------------------
     */


    public static void main(String[] args) {
        Scanner kboard = new Scanner(System.in);
        //use public static boolean checkForYes ( String inputString ) to check boolean
        boolean playingGame = false;
        //don't play the game if the user cannot understand say yes to play

        int score = 0;
        //declare a int called score

        // housekeeping - clear the contents of the console before we begin
        clearScreen();

        // welcome method - say hello to the student, hit enter to continue
        helloStudent(kboard);

        clearScreen();
        //20 blank lines
        String studentName = getStudentName(kboard);
        //studentName = human keyboard input
        System.out.println("\n\n\tWelcome " + studentName + "!");

        //int studentGrade = getStudentGrade ( kboard, FIRST_GRADE, THIRD_GRADE ) ;
        int studentGrade = getStudentGrade(kboard, FIRST_GRADE, SIXTH_GRADE);
        //limit 1-6

        String playerInput = getStringInput(kboard, "\n\n\tDo you want to play Flash Cards? >> ");
        //ask for input of yes or no

        playingGame = checkForYes(playerInput);
        //checkForYes makes java undersatand yes and y = True

        while (playingGame) {
            if (studentGrade == FIRST_GRADE) {
                score = firstGradeFlashCards(kboard, studentName, FIRST_GRADE_QUESTIONS_CNT);
                reportScore(studentName, score, FIRST_GRADE_QUESTIONS_CNT);
            }
            //jump to the correct grade questions
            //after complete the for loop in the grade, report the name, score, and numbers of questions, to count
            //the total score
            // report the results
            // 1. print the marquee
            // 2. print the student's name and score
            // 3. calculate the percentage and print some logical encouragement
            // 4. print the marquee
            // 5. print < hit enter to continue >

            else if (studentGrade == SECOND_GRADE) {
                score = secondGradeFlashCards(kboard, studentName, SECOND_GRADE_QUESTIONS_CNT);
                reportScore(studentName, score, SECOND_GRADE_QUESTIONS_CNT);
            }

            // report the results
            // 1. print the marquee
            // 2. print the student's name and score
            // 3. calculate the percentage and print some logical encouragement
            // 4. print the marquee
            // 5. print < hit enter to continue >

            else if (studentGrade == THIRD_GRADE) {
                score = secondGradeFlashCards(kboard, studentName, THIRD_GRADE_QUESTIONS_CNT);
                reportScore(studentName, score, THIRD_GRADE_QUESTIONS_CNT);
            }
            
            else if (studentGrade == FORTH_GRADE) {
                score = forthGradeFlashCards(kboard, studentName);
                //no need for the numbercount
                reportScore(studentName, score, 13);
                //when report say 13
            }
            else if (studentGrade == FIFTH_GRADE) {
                score = fifthGradeFlashCards(kboard, studentName, FIFTH_GRADE_QUESTIONS_CNT);
                reportScore(studentName, score, FIFTH_GRADE_QUESTIONS_CNT);
            }
            else {
                score = sixthGradeFlashCards(kboard, studentName, SIXTH_GRADE_QUESTIONS_CNT);
                reportScore(studentName, score, SIXTH_GRADE_QUESTIONS_CNT);
            }
            //5 if 1 else looping to the corresponding one for grade
            /*
            else
            {
                score = thirdGradeFlashCards ( kboard, studentName, THIRD_GRADE_QUESTIONS_CNT ) ;
                reportScore ( studentName, score, THIRD_GRADE_QUESTIONS_CNT );
            }
            no longer need this, replace to 6
            */


            // ask student if she / he wants to play Flash Cards again


            // if yes, then

            /*************************************************************
             *                                                           *
             *  P L A Y   F L A S H   C A R D S                          *
             *                                                           *
             *  In this section of code, play the version of             *
             *  FlashCards dependent on the grade level of the           *
             *  student.  As directed, the FlashCard levels are          *
             *  as follows:                                              *
             *  1.  firstGradeFlashCards: addition with numbers 0-10     *
             *  2.  secondGradeFlashCards: addition with numbers 0-100   *
             *  3.  thirdGradeFlashCards: subtraction with numbers0-100  *
             *                                                           *
             *************************************************************/

            //    if first grade, play firstGradeFlashCards
            //    else if second grade, play secondGradeFlashCards
            //    else play thirdGradeFlashCards

            // if no, call the goodbye method

            // ask student if she / he wants to play again

            // if yes, loop back to play

            // Keep playing?
            playerInput = getStringInput(kboard, "\n\n\tKeep playing? >> ")
            ;
            //ask after playing one round
            playingGame = checkForYes(playerInput);
        }
        System.out.println("\nThanks for playing!");
        kboard.close();
    }


    /**
     * -------------------------------
     * Declare Methods
     * -------------------------------
     */

    public static String getStringInput(Scanner kboard, String prompt) {
        // Create a variable to capture input from the keyboard

        // Capture the equation in an array

        System.out.print(prompt);

        String expr = kboard.nextLine();
        System.out.println();

        return expr;
    }


    public static int getNumberInput(Scanner kboard, String prompt) {
        // Create a variable to capture input from the keyboard and get it

        System.out.print(prompt);
        int nextNumber = kboard.nextInt();
        String expr = kboard.nextLine();  // consumes the \n from nextInt
        System.out.println(expr);   // prints a blank line because expr is the \n from nextInt
        return nextNumber;
        //this is the get keyboard number input funtion
        //I really miss Python where you can just say int = input("")
        //scan keyboard, return number of grade
    }


    private static void helloStudent(Scanner kboard) {
        System.out.println(MARQUEE);
        System.out.println();
        System.out.println("\tH E L L O\n");
        System.out.println("\tW E L C O M E   T O   F L A S H   C A R D S");
        System.out.println();
        System.out.println("\t\t< Press Enter to continue >");
        System.out.println();
        System.out.println(MARQUEE);

        String studentInput = getStringInput(kboard, "");
        System.out.print(studentInput);
        //where it start to say hi

    }


    //use grade one to explain
    public static int firstGradeFlashCards(Scanner kboard, String studentName, int numberOfQuestions) {
        System.out.println("I'm here in firstGradeFlashCards.");
        int score = 0;
        //declare int score

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 0-10
        // 3. print a math equation - addition only, using the two numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for (int i = 0; i < numberOfQuestions; i++) {
            int number1 = (int) (Math.random() * 10);
            int number2 = (int) (Math.random() * 10);
            //generate 2 random number btw 1-10
            //for loop < grade's corresponding number of questions
            clearScreen();
            int studentResult = printEquation(kboard, number1, number2, "+");
            //use the printEquation function to make the calculation
            if (studentResult == (number1 + number2))
                score++;
            //if correct than score +1
        }
        return score;
        //return score to print out in result
    }

    public static int secondGradeFlashCards(Scanner kboard, String studentName, int numberOfQuestions) {
        System.out.println("I'm here in secondGradeFlashCards.");
        int score = 0;

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 10-99
        // 3. print a math equation - addition only, using the two digit numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for (int i = 0; i < numberOfQuestions; i++) {
            int number1 = (int) (Math.random() * 100);
            int number2 = (int) (Math.random() * 100);
            clearScreen();
            int studentResult = printEquation(kboard, number1, number2, "+");

            if (studentResult == (number1 + number2))
                score++;
        }

        return score;
    }

    public static int thirdGradeFlashCards(Scanner kboard, String studentName, int numberOfQuestions) {
        System.out.println("I'm here in thirdGradeFlashCards.");
        int score = 0;

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 0-10
        // 3. print a math equation - mix of addition and subtraction, using the two numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for (int i = 0; i < numberOfQuestions; i++) {
            int number1 = (int) (Math.random() * 100);
            int number2 = (int) (Math.random() * 100);
            clearScreen();
            if (number2 > number1) {
                int temp = number2;
                number2 = number1;
                number1 = temp;
            }

            int studentResult = printEquation(kboard, number1, number2, "-");

            if (studentResult == (number1 - number2))
                score++;
        }

        return score;
    }

    public static int forthGradeFlashCards(Scanner kboard, String studentName) //4th
            //no need for count
    {

        System.out.println("\n\n\tI'm here in forthGradeFlashCards.");
        int i = 0;
        while (i < 1 || i > 13 ) //while until correct input
        {
            String playTable = getStringInput(kboard, "\n\n\tWhat table to do you want to practice? 1-12 >> ");

            try //convert string to int
            {
                // the String to int conversion happens here
                i = Integer.parseInt(playTable.trim());

                // print out the value after the conversion
                System.out.println("\n\n\tTable = " + i);
                //if the students put something else
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("NumberFormatException: " + nfe.getMessage());
                System.out.println("Not Valid, Please input again.");
            }
            //if they cannot understand direction
        }
        int intPlayTable = i;
        //get the value
        int score = 0;

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 0-10
        // 3. print a math equation - mix of addition and subtraction, using the two numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for (i = 0; i < 13; i++) {

            int studentResult = printEquation(kboard, intPlayTable, i, "*");

            if (studentResult == (intPlayTable * i))
                score++;
        }

        return score;
    }

    public static int fifthGradeFlashCards(Scanner kboard, String studentName, int numberOfQuestions) //5th
    {
        System.out.println("I'm here in fifthGradeFlashCards.");
        int score = 0;

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 0-10
        // 3. print a math equation - mix of addition and subtraction, using the two numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for (int i = 0; i < numberOfQuestions; i++) {
            int number1 = (int) (Math.random() * 100); //not too big
            int number2 = (int) (Math.random() * 100); //not too big
            //TODO: q: does rand 100 include 100
            //i guess they need to use calculator
            clearScreen();
            if (number2 > number1) {
                int temp = number2;
                number2 = number1;
                number1 = temp;
            }

            int studentResult = printEquation(kboard, number1, number2, "*");

            if (studentResult == (number1 * number2))
                score++;
        }

        return score;
    }

    public static int sixthGradeFlashCards(Scanner kboard, String studentName, int numberOfQuestions) //5th
    {
        System.out.println("I'm here in sixthGradeFlashCards.");
        int score = 0;

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 0-10
        // 3. print a math equation - mix of addition and subtraction, using the two numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for (int i = 0; i < numberOfQuestions; i++) {
            int max = 100;
            int min = 1;
            Random rand = new Random();
            int number1 = rand.nextInt((max - min) + 1) + min;
            int number2 = rand.nextInt((max - min) + 1) + min;
            //you cannot divide 0, so I use another way to generate numbers
            //i guess they need to use calculator
           clearScreen();
            if (number2 > number1) {
                int temp = number2;
                number2 = number1;
                number1 = temp;
            }

            if (number1 % number2 != 0)
            {
                i -= 1;
            }
            else
            {
                int studentResult = printEquation(kboard, number1, number2, "/");

                if (studentResult == (number1 / number2))
                    score++;
            }

        }

        return score;
    }
    
    /* I did too much
    public static int sixthGradeFlashCards(Scanner kboard, String studentName, int numberOfQuestions) //6th
    {
        System.out.println("I'm here in sixthGradeFlashCards.");
        int score = 0;

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 0-10
        // 3. print a math equation - mix of addition and subtraction, using the two numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for (int i = 0; i < numberOfQuestions; i++) {
            int number1 = (int) (Math.random() * 100);//not too big
            int number2 = (int) (Math.random() * 100);//not too big

            clearScreen();

            if (number2 > number1) {
                int temp = number2;
                number2 = number1;
                number1 = temp;
            }

            Random r = new Random();
            int studentResult = 0;

            //my special cooooooooooooooooooool design
            //i think the students will kill me
            switch (r.nextInt(3)) {
                //randomly generate 0-2

                case 0:
                    studentResult = printEquation(kboard, number1, number2, "+");

                    if (studentResult == (number1 + number2))
                        score++;
                    break;
                case 1:
                    studentResult = printEquation(kboard, number1, number2, "-");

                    if (studentResult == (number1 - number2))
                        score++;
                    break;
                case 2:
                    number1 = (int) (Math.random() * 50);//not too big
                    number2 = (int) (Math.random() * 20);//not too big
                    studentResult = printEquation(kboard, number1, number2, "*");

                    if (studentResult == (number1 * number2))

                        score++;
                    break;
                default:
                    break;
            }
        }

        return score;
    }
    */


    public static int printEquation ( Scanner kboard, int num1, int num2, String operator )
    {
        return getNumberInput ( kboard, "\n\n\t" + num1 + " " + operator + " " + num2 + " = " ) ;
        //print num1 operator num2, which is the equation and calculation of the question
    }


    public static void clearScreen()
    {
        //ignore this: id rather use while true and if break, not for
        //print 20 blank lines
        for(int i = 0; i < 20; i++)
        {
            System.out.println("");
        }
    }

    public static String getStudentName ( Scanner kboard )
    {

        String studentName = getStringInput ( kboard, "\n\n\tPlease type your name >> ");

        return studentName ;
        //get name
    }


    public static int getStudentGrade ( Scanner kboard, int limitLow, int limitHigh )
    {
        // getGrade method - prompt and validate grade 1-3
        int studentGrade = getNumberInput ( kboard, "\n\n\tWhat grade are you in? >> " );
        while ( studentGrade < limitLow || studentGrade > limitHigh )
        {
            System.out.println ( "\n\n\tPlease enter a grade between " + limitLow + " and " + limitHigh );
            //when you use vars instead numbers, when you change the vars, it changes here so you don't need to ctrl-R
            studentGrade = getNumberInput ( kboard, "\n\tWhat grade are you in? >> " );
        }
        //asking for grade to direct to the correct level
        return studentGrade ;
    }


    public static boolean checkForYes ( String inputString )
    //check if human input is True or False
    {
        return ( "Y".equals ( inputString.toUpperCase()) || "YES".equals (inputString.toUpperCase()) ) ;
    }
    //y or yes = true otherwise false


    public static void reportScore ( String studentName, int score, int totalQuestions )
    {
        clearScreen();
        System.out.println ( "\n\n\t" + studentName + ", you correctly answered " + score + " of " + totalQuestions ) ;
        double grade = (double) score / (double) totalQuestions ;
        System.out.print ( "\n\tYour score is " + ( grade * 100 ) + "%  ") ;
        if ( grade == 1.0 ) System.out.println ( "Excellent job!  Perfect score!  A+") ;
        else if ( grade > 0.9 ) System.out.println ( "Well Done.  Grade = A") ;
        else if ( grade > 0.8 ) System.out.println ( "Very Good.  Grade = B") ;
        else if ( grade > 0.7 ) System.out.println ( "Keep Practicing.  Grade = C") ;
        else System.out.println ( "Don't Give Up.  You can do better.  Grade = Bad times." ) ;

        //grading system, convert deci to human language
    }

}