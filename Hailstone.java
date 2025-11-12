// Aditya Sarcar
// 11-7-25
// Hailstone.java
// This program displays the Hailstone Sequence proposed by German mathematician
// Lothar Collatz. The sequence always ends in a 1, although it has yet to be 
// proven. The sequence works this way by picking a number; if it is even then, 
// halves it, and if it is odd multiplies it by 3 and adds one. The program 
// continues this process until the number becomes one.
// Working on: using while loops and do-while loops smoothly to orchestrate and 
// print a sequence, then using conditional statements to format the output in 
// a neat, readable manner.
///Testing: 20 (8), 30 (19), -3 (error), 10001 (error), -1 (break)
/// count starts at 1
/// print 20, divide by 2, increment count, check 10!=1 (true)
/// print 10, divide by 2, increment count, check 5!=1 (true)
/// print 5, multiply by three and add 1, increment count, check 16!=1 (true)
/// print 16, divide by 2, increment count, check 8!=1 (true)
/// print 8, divide by 2, increment count, check 4!=1 (true)
/// print 4, divide by 2, increment count, check 2!=1 (true)
/// print 2, divide by 2, increment count, check 1!=1 (false)

import java.util.Scanner; // import Scanner

public class Hailstone
{
	private int userInput; // declare FV userInput, stores starting number
	// of the hailstone sequence
	private int numOfIterations; // declare FV numOfIterations, stores number
	// of iterations in the Hailstone for sequence in userInput
	
	// constructor intializes FVs
	public Hailstone()
	{
		userInput = 0;
		numOfIterations = 0;
	}
	
	// main constructs an object and then uses it to call findIt
	public static void main (String[] args)
	{
		Hailstone collatzSequence = new Hailstone(); // construct an object
		collatzSequence.findIt(); // use object to call findIt
	}
															
	/* getInput prompts user for a positive integer to use the Hailstone 
	 * Sequence on, then stores the number in userInput
	 */
	public void getInput()
	{
		Scanner inputReader = new Scanner(System.in); // open Scanner
		
		System.out.print("Enter a positive integer (1 - 10,000). To quit, " +
			"enter -1:\t");
		userInput = inputReader.nextInt(); // store user's input in userInput
	}
	
	/* findIt uses a do-while loop to increment the number of numOfIterations 
	 * and call printSequence as long as the sentinel value -1 isn't entered; if
	 * it isn't in the expected range, it calls printCount to account for the 
	 * user entering a value outside the prompt
	 */
	public void findIt()
	{
		System.out.println("\n\n\n");
		
		do
		{
			numOfIterations = 1;
			getInput(); // call getInput
			System.out.println(); // space for formatting
			
			if (1 <= userInput && userInput <= 10000) // check if in expected range
			{
				printSequence(); // call printSequence
			}
			
			printCount(); // call printCount
			
		} while (userInput != -1); // check if sentinel value is entered
		
		System.out.println();
	}
	
	/* printSequences prints the sequence numbers in the proper format and 
	 * counts the number of iterations for printCount
	 */
	public void printSequence()
	{
		do 
		{
			System.out.printf("%7d", userInput); // prints number in proper format
			if (numOfIterations%10 == 0)
			{
				System.out.println(); // enter blank line for formatting
			}
			
			if (userInput%2 == 0) // check if even
			{
				userInput = userInput/2; // apply hailstone sequence
			}
			else // check if odd
			{
				userInput = 3*userInput + 1; // apply hailstone sequence
			}

			numOfIterations += 1; // increment number of iterations
		} while (userInput != 1);
		System.out.printf("%7d", userInput); // print one more output since the
		// do-while loop misses printing the last output of 1
	}
	
	/* printCount prints the output for when every sequence ends or when the 
	 * code ends, or when the user enters a value outside the expected range*/
	public void printCount()
	{
		if (1<= userInput && userInput <= 10000) // in expected range
		{
			System.out.printf("\n\nThe loop executed %d times.", 
				numOfIterations);
		}
		else if (userInput == -1) // check if sentinel value is entered
		{
			System.out.println("\nThank you for playing Hailstone.");
		}
		else // checking for cases outside expected range
		{
			System.out.println("\nEnter a value within the range, please!");
		}
		
		System.out.println("\n\n");
	}
}
