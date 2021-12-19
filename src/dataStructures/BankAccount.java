package dataStructures;

public class BankAccount {

	private String bankName;
	private String accountID;
	private double balance;

	public BankAccount(String bankName, String accountID) {
		this.bankName = bankName;
		this.accountID = accountID;

	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public boolean withdrawal(double amount) {
		if (balance - amount > 0) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
}
