

// 				  Class that utilizes the Account class 
// to create accounts and uses methods in Account class
public class App {

	// Main function only exists to create and use Account objects
	public static void main(String[] args) {
	
		System.out.println("New Account");
		Account newAccount  = new Account(1122, 20000);
		newAccount.setAnnualInterestRate(0.045);
		
		System.out.println(newAccount);
		
		System.out.println("Withdraw $2500");
		newAccount.withdrawal(2500);
		
		System.out.println(newAccount);
		
		System.out.println("Deposit $3000");
		newAccount.deposit(3000);
		
		System.out.println(newAccount);
		
		System.out.println("Monthly Interest: " + newAccount.getMonthlyInterest());
	}

}