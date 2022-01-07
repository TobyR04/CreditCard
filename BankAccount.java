package dataStructures;

public class BankAccount {

	private String bankName;
	private String accountID;
	private double balance;

	public BankAccount(String bankName, String accountID, double balance) {
		this.bankName = bankName;
		this.accountID = accountID;		
		this.balance = balance;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountID == null) {
			if (other.accountID != null)
				return false;
		} else if (!accountID.equals(other.accountID))
			return false;
		return true;
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
	
	public String getBankID() {
		return accountID;
	}
}
