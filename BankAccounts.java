package dataStructures;

import java.util.ArrayList;

public class BankAccounts {
	private ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	
	public void addBankAccount(BankAccount bankAccount) {
		if (!bankAccounts.contains(bankAccount)) {
			bankAccounts.add(bankAccount);
		}
		
	}
	
	public BankAccount findAccount(String id) {
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getBankID().equals(id)) {
				return bankAccounts.get(i);
			}
		}
		return null;// check if right
	}
	
	public boolean isEmpty() {
		if(bankAccounts.isEmpty()) {
			return true;
		}
		return false;
	}
	

	public boolean contains(String id) {
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getBankID().equals(id)) {
				return true;
			}
		}
		return false;
	}


}
