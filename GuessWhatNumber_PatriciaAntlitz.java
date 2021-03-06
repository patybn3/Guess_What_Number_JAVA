/* LAB 5 Guess What Number Lab -- OBJECTIVE -- : To use a decision
constructs and loop constructs to play a simple guessing game.
-------------------------------------------------------------*/
/*
Name: Patricia Antlitz
Date: 10/07/2021
Class: CIS-160 Computer Science I - NECC Fall 2021
Professor: Kristen Sparrow
*/

/**
 * This program generates a random number from 1-10
 * It allows an user to input a number from 1-10 to guess what number
 * was generated.
 * User is given 10 chances to guess.
 * Press h for help
 * p to play
 * and q to quit
 * @author Patricia N. Antlitz
 * @version 1.0
 */

/*
Create a program that asks a user to input a number
between 1 and 10 to see if it is the number the computer generates.

Give the end user at least 10 tries to guess the number.

Create a menu that allows the user to 1. get help, 2. play the game, 3. exit the game.

The program must use decision constructs
(if or switch statments) and looping constructs (while, for, or do while loops).

Extra Credit:

Create a menu that runs your Guess What Number game and has the ability to:
Get instructions as to how to play the game
Start the game again
Exit the game
 */

//import scanner
import java.util.Scanner;

// begin class GuessWhatNumber
public class GuessWhatNumber_PatriciaAntlitz {

    //will hold the number generated by the computer
    int randomNum;
    //will hold the string entered by the user as player name
    String namePlayer;

    //first print out on screen will let user know that instructions will be given
    public void gameIntro(){
        //prints the title of the game and instructions
        System.out.println("\n               Guess What Number");
        System.out.println("------------------------------------------------");
        System.out.println("\nInstructions:\n");
    }

    //instructions method, will print a list of instructions to play the game
    public void gameInstructions() {

        System.out.println("- This game will generate a random number from 1-10");
        System.out.println("that will be compared with a number entered by the user.");
        System.out.println("- The user should enter a number from 1-10 as well.");
        System.out.println("- You have 10 chances to guess what number was generated");
        System.out.println("by the computer before the game ends.");
        //game restarts when 0 is entered
        System.out.println("- Entering the number 0 will restart the whole game.");
        System.out.println("- Numbers smaller than 0, or larger than 10 are invalid");
        System.out.println("and the guess will not count.");
        System.out.println("----LOOK FOR HINTS----\n");

        System.out.println("Remember, you must guess what number was generated by the computer.\n");
    }

    //game's menu to be display after the first round
    public void gameMenu() {
        //allows user to pick start, quit, or help
        System.out.println("\n------------------------------------------------");
        System.out.println("|                    MENU:                     |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|    - Press the Letter 's' to Start           |");
        System.out.println("|    - Press the Letter 'q' to Exit The Game   |");
        System.out.println("|    - Press the Letter 'h' for Help           |");
        System.out.println("------------------------------------------------");
    }

    public int computerGeneratedNum() {
        //numbers are generated from 0-9, 1 is added to add 1 to each number,
        //allowing 1-10 to be printed instead
        randomNum = (int) ((Math.random() * 10) + 1);
        //exporting randomNum to be used by other functions
        return randomNum;
    }

    //userName method will ask the user to enter a name "string" for the player
    public String userName() {
        //scan function
        Scanner scnr = new Scanner(System.in);
        //instruction
        System.out.println("Enter Player's Name:\n");
        //scans user's entry adding entry to the string variable
        namePlayer = scnr.nextLine();

        //this call will take the string entered by the user and capitalize the first letter
        String nameCapitalized = namePlayer.substring(0, 1).toUpperCase() + namePlayer.substring(1);

        //welcomes the player
        System.out.println("\nWelcome, " + nameCapitalized);

        //sets the user vs computer
        System.out.println("\n* * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("\n" + nameCapitalized + " - - VS. - - Computer");
        System.out.println("\n* * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * *");

        //returns string to be used
        return namePlayer;
    }

    public void guessGame() {

        //variables will hold the number entered by user, and the number generated by the computer
        int numEntered, computerNum;
        //will hold the scores (computer vs user)
        int computerScore = 0, userScore = 0;
        //variable used for looping
        int i = 0;

        //will capitalize the user's name again
        String nameCapitalized = namePlayer.substring(0, 1).toUpperCase() + namePlayer.substring(1);

        //scan function
        Scanner scnr = new Scanner(System.in);
        //instructions to restart the game
        System.out.println("|    - PRESS 0 TO RESTART THE GAME AT ANY TIME -     |\n");

        //while loop, while i is less then 10, 0-10
        while (i < 10) {

            //calls the random number method into the variable to store the random number
            computerNum = computerGeneratedNum();

            // HINTS
            //if computer's random number is less or equal to 3
            if (computerNum <= 3) {
                System.out.println("\nHINT: Computer's number is in between 1-3");
            }
            // less or equal 6
            else if (computerNum <= 6) {
                System.out.println("\nHINT: Computer's number is in between 4-6");
            }
            // all other numbers
            else{
                System.out.println("\nHINT: Computer's number is in between 7-10");
            }

            // asks the user to enter a number
            System.out.println("\nEnter a Number:");
            //stores the number on numEntered variable
            numEntered = scnr.nextInt();

            // first rule. If number entered by the user is negative or greater than 10
            if (numEntered < 0 || numEntered > 10) {
                //the move will be invalid
                System.out.println("--------------------------------------------------");
                System.out.println("| Number must be from 1 to 10. Please try again: |");
                System.out.println("--------------------------------------------------");
                //this move wont count and will be added back to the loop
                i--;

            }
            // second rule = if number entered by the user is equal to 0
            else if (numEntered == 0){
                //the game will be restarted
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("Restarting The Game. Count Reset.");
                System.out.println("-------------------------------------------------------------------------");
                //scores will be reset
                userScore = 0;
                computerScore = 0;
                //loop will start from the beginning
                i = 0;

            }
            // if the number entered by the user is the same as the one generated by the computer
            else if (numEntered == computerNum) {
                //then the user gains a point
                userScore++;
            }
            // now, if the number entered is not equal
            else if (numEntered != computerNum) {
                // the point goes to the computer
                computerScore++;
            }
            // back to rules about restarting the game
            // if the user enters any number but 0
            if (numEntered != 0) {
                // print the number chosen by the computer
                System.out.println("\nComputer: " + computerNum);
                //and the number chose by the user
                System.out.println(nameCapitalized + ": " + numEntered);
            }

            // prints the score on each move
            System.out.println("\nCURRENT SCORE:");
            System.out.println("\nComputer's Score = " + computerScore + " -- X -- "
                    + nameCapitalized + "'s Score = " + userScore + "\n");
            //adds to i to continue the loop until 10 is reached
            i++;

            //if number entered is 0, it will take 1 out of i, which was previously increased, to allow
            // the user to have 10 more moves and not 9
            if(numEntered == 0){
                i--;
            }
        }

        // conditionals will print the correct winner of this round
        // if the computer score is greater than the user's score
        if (computerScore > userScore) {
            //print the computer as winner
            System.out.println("\n*****************************");
            System.out.println("|          WINNER:          |");
            System.out.println("*****************************");
            System.out.println("|     *** Computer ***      |");
            System.out.println("*****************************");
            //prints the menu to allow the user to make a choice on the next move
            gameMenu();
        }
        // now, if the score of the user is greater
        else {
            // the user is the winner
            System.out.println("\n*****************************");
            System.out.println("|          WINNER:          |");
            System.out.println("*****************************");
            System.out.println("*** " + nameCapitalized + " ***");
            System.out.println("*****************************");
            // get menu
            gameMenu();
        }
    }

    //method will allow the user to enter a letter to select from the menu
    public void menuChoices() {
        //variable used for the loop
        int i = 0;
        // variable will store the letter entered by the user
        char letterEntered;

        //scan function
        Scanner scnr = new Scanner(System.in);

        //d0-while loop
        do {
            //gets letter entered by the user at index 0
            letterEntered = scnr.nextLine().charAt(0);

            // if the letter entered is "s"
            if (letterEntered == 's') {
                //the game will start again
                System.out.println("Game Starting...");
                //calls the method that has the game
                guessGame();
            }
            // if the entry is "h"
            else if (letterEntered == 'h') {
                System.out.println("-----------HELP:-----------\n");
                //will print the instructions
                gameInstructions();
                //will print the menu again
                gameMenu();
            }
            // if entry is "q"
            else if (letterEntered == 'q') {
                System.out.println("\nGoodbye!\n");
                // will quit the game
                break;
            }
            else {
                i = 0;
                getMenu();
            }
            //continues loop until a choice is made
            i++;

        } while (i >= 0);

    }

    //main function
    public static void main(String args[]) {
        //creates an object
        GuessWhatNumber_PatriciaAntlitz compNum = new GuessWhatNumber_PatriciaAntlitz();

        //calls
        //calls the intro
        compNum.gameIntro();
        //calls the instructions
        compNum.gameInstructions();
        //calls the method that asks for an player name
        compNum.userName();
        // calls the game method
        compNum.guessGame();
        //calls the menu choices
        compNum.menuChoices();

    }
}
// end.