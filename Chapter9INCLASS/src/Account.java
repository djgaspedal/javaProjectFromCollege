import java.util.*;

// Account Class that creates an account with a balance, id,
// 				  interestRate, and displays the dateCreated
public class Account {

	// Account ID: Unique number for each account
	private int id = 0;
	
	// Balance for account
	private double balance = 0;
	
	// Current interest rate for account [assume that all accounts have same interest rate]
	private double annualInterestRate ;
	
	// Account creation date object for class
	private Date dateCreated = null;
	
	// No-Arg Constructor
	public Account() {
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
	}
		
	// Constructor that creates an account w/ specified id && initial balance
	public Account(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
		this.dateCreated = new Date();
	}
	
	// ID getter fxn
	public int getId() {
		return id;
	}

	// ID setter fxn
	public void setId(int id) {
		this.id = id;
	}

	// Balance getter fxn
	public double getBalance() {
		return balance;
	}

	// Balance setter fxn
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// AnnualInterestRate setter fxn
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	// Returns 'annualIntRate/12' for months
	public double getMonthlyInterest() {
		return this.balance * (this.annualInterestRate / 12);
	}

	// Subtracts withdrawnAmount from balance
	public void withdrawal(double withdrawnAmount) {
		balance -= withdrawnAmount;
	}
	
	// Deposits money into account
	public void deposit(double depositAmount) {
		balance += depositAmount;
	}

	// toString Method
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", annualInterestRate=" + annualInterestRate
				+ ", dateCreated=" + dateCreated + "]";
	}
	
}