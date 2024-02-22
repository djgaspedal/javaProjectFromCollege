package chapter6;

import java.util.*;

// Public class that computes interest, monthly payment, and total payment of a loan
public class ChapterSixOnYourOwn {

	// Main method that uses other methods to output computations regarding the user's loan input
	public static void main(String[] args) {
		
		// New Scanner object
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.println(      "Enter yearly interest rate, EX = 8.250: ");
		double annualInterestRate = userInput.nextDouble();
		
		System.out.println("Enter Number of Years as an Integer, EX = 5: ");
		double numberOfYears = userInput.nextDouble();
		
		System.out.println(          "Enter Loan Amount, EX = 120000.95: ");
		double loanAmount = userInput.nextDouble();

		// Method that outputs the proper information to the user
		outputLoanInformation(annualInterestRate, numberOfYears, loanAmount);
		
		userInput.close();
		
	}
	
	public static double getMonthlyPayment(double annualInterestRate, double numberOfYears, double loanAmount) { 
		
		annualInterestRate = annualInterestRate / 100;
		
		double totalPayment = ( Math.pow(annualInterestRate + 1,numberOfYears) ) * (loanAmount);
		double monthlyPayment = (totalPayment) / (12 * numberOfYears);
		
		// 
		return monthlyPayment;
		
	}
	
	public static double getTotalPayment(double annualInterestRate, double numberOfYears, double loanAmount) {
		
		annualInterestRate = (annualInterestRate / 100);
		
		double total = ( Math.pow(annualInterestRate + 1,numberOfYears) ) * (loanAmount);
		
		return total;
		
	}
	
	public static void outputLoanInformation(double annualInterestRate, double numberOfYears, double loanAmount) {
		
		System.out.println();
		System.out.println("Your Loan Data:");
		
		System.out.printf("Your Annual Interest Rate Entered: %.3f ", annualInterestRate);
		System.out.println();
		
		System.out.printf("Your Number of Years Entered: %.0f ", numberOfYears);
		System.out.println();
		
		System.out.printf("Your Number Loan Amount Entered: %.2f ", loanAmount);
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Monthly & Total Payment: ");
		System.out.printf("Your Monthly Payment: " + " $" +"%.2f", getMonthlyPayment(annualInterestRate, numberOfYears, loanAmount) );
		System.out.println();
		
		System.out.printf("Your Total Payment: " + " $" +"%.2f", getTotalPayment(annualInterestRate, numberOfYears, loanAmount));
		
	}

}