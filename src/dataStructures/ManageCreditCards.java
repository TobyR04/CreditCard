package dataStructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.util.*;

public class ManageCreditCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		menu(input);

	}

	public static void menu(Scanner input) {

		System.out.println("Please choose a menu option: ");
		System.out.print("\n1. Add a new Credit Card \n2. Remove a Credit Card \n3. Display total outstanding balances"
				+ "\n4. Display total available credit \n5. Display largest purchase\n"
				+ "6. Display most recent payment\n" + "7. Display total spent on certain category of expense\n"
				+ "8. For which type of Purchase was the most money spent\n"
				+ "9. Manage a specific Credit Card \n10. Add Bank Account\n11. Exit ");

		int choice = input.nextInt();
		while (choice < 1 || choice > 10) {
			System.out.println("You can only enter 1-10. Please re-enter your choice");
			System.out.println("Please choose a menu option: ");
			System.out.print(
					"\n1. Add a new Credit Card \n2. Remove a Credit Card \n3. Display total outstanding balances"
							+ "\n4. Display total available credit \n5. Display largest purchase\n"
							+ "6. Display most recent payment\n"
							+ "7. Display total spent on certain category of expense\n"
							+ "8. For which type of Purchase was the most money spent\n"
							+ "9. Manage a specific Credit Card \n10. Add Bank Account\n11. Exit");

			choice = input.nextInt();
		}
		input.nextLine();
		try {
			chooseOption(choice, input);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void chooseOption(int choice, Scanner input) throws ParseException {
		CreditCards cards = new CreditCards();
		BankAccounts bankAccounts = new BankAccounts();// add cards to this
		switch (choice) {
		case 1:
			System.out.print("Enter the Credit Card Number: ");
			String creditCardID = input.nextLine();
			boolean correct = true;

			if (creditCardID.charAt(0) != ('3') || creditCardID.charAt(0) != ('4') || creditCardID.charAt(0) != ('5')) {
				correct = false;
			}
			if ((creditCardID.charAt(0) == ('3') && creditCardID.length() != 15)
					|| ((creditCardID.charAt(0) == ('5') || creditCardID.charAt(0) == ('4'))
							&& creditCardID.length() != 16)) {
				correct = false;
			}
			while (correct == false) {
				System.out.println("The credit card number that you enterd is incorrect.");
				System.out.println("Please enter the credit card number again.");
				System.out.print("Enter the Credit Card Number: ");
				creditCardID = input.nextLine();
				correct = true;
				if ((creditCardID.charAt(0) == ('3') && creditCardID.length() != 15)
						|| ((creditCardID.charAt(0) == ('5') || creditCardID.charAt(0) == ('4'))
								&& creditCardID.length() != 16)) {
					correct = false;
				}
			}

			try {
				System.out.print("Enter the expiration date: (mm-yyyy)");
				String date = input.nextLine();
				SimpleDateFormat formatter = new SimpleDateFormat("mm-yyyy");
				Date expDate = formatter.parse(date);
			} catch (ParseException e) {
				// figure out how to catch validating
			}

		case 6:
			// have validation to make sure that if there is no credit cards at all...
			System.out.println("The most recent Payment is: " + cards.getMostRecentPayment());// make to String
			break; // methods!!!

		case 7:
			// have validation to make sure that if there is no credit cards at all...
			System.out.println("Choose which expense total you would like to see: ");
			System.out
					.print("1. Car 2. Clothing 3. Food 4. Groceries 5. Lodging 6. Restaurant 7. Travel 8. Utilities ");
			int option = input.nextInt();
			while (option < 1 || option > 8) {
				System.out.println("You entered an incorrect number. Please re-enter your option.");
				System.out.print(
						"1. Car 2. Clothing 3. Food 4. Groceries 5. Lodging 6. Restaurant 7. Travel 8. Utilities ");
				option = input.nextInt();
			}
			switch (option) {
			case 1:
				System.out.println("Car Total: " + cards.getTotalCar());
			case 2:
				System.out.println("Clothing Total: " + cards.getTotalClothing());
			case 3:
				System.out.println("Food Total: " + cards.getTotalFood());
			case 4:
				System.out.println("Groceries Total: " + cards.getTotalGroceries());
			case 5:
				System.out.println("Lodging Total: " + cards.getTotalLodging());
			case 6:
				System.out.println("Restaurant Total: " + cards.getTotalRestaurant());
			case 7:
				System.out.println("Travel Total: " + cards.getTotalTravel());
			case 8:
				System.out.println("Utilities Total: " + cards.getTotalUtilities());

			}
			break;
		case 8:
			// have validation to make sure that if there is no credit cards at all...
			System.out.println(cards.getMostPurchase());
			break;
		case 9:

			IndividualCardMenu(input, cards);
			break;
		case 10:
			System.out.print("Please enter the bank name: ");
			String bankName = input.nextLine();
			System.out.print("Please enter the bank ID: ");
			String bankID =input.nextLine();
			System.out.print("Please enter the balance: ");
			double balance = input.nextDouble();
			while(balance < 0) {
				System.out.print("Invalid amount. Please enter the amount again:");
				balance = input.nextDouble();
			}
			bankAccounts.addBankAccount(new BankAccount(bankName, bankID, balance));
			
		}

		// make method to exit

//		
//	    public boolean isValid(String dateStr) {
//	        SimpleDateFormat sdf = new SimpleDateFormat(this.dateFormat);
//	        sdf.setLenient(false);
//	        try {
//	            sdf.parse(dateStr);
//	        } catch (ParseException e) {
//	            return false;
//	        }
//	        return true;
//	    }
	}

	public static void IndividualCardMenu(Scanner input, CreditCards cards) {
		System.out.print("Manage a specific credit card. Please input your credit card number: ");
		String cardNum = input.nextLine();
		while (cards.findCard(cardNum).equals(null)) {
			System.out.print("You entered an incorrect credit card number. Please try again. ");
			cardNum = input.nextLine();
		}
		CreditCard card = cards.findCard(cardNum);

		System.out.print("\n1. Display current balance" + "\n2. Display current credit limit \n3. Add a Purchase\n"
				+ "4.  Add a Payment\n" + "5. Add a Fee\n" + "6. Display most recent Purchase\n"
				+ "7. Display most recent Payment \n8. Exit to main menu");

		int choice = input.nextInt();
		while (choice < 1 || choice > 8) {
			System.out.println("You can only enter 1-8. Please re-enter your choice");
			System.out.println("Please choose a menu option: ");
			System.out.print("\n1. Display current balance" + "\n2. Display current credit limit \n3. Add a Purchase\n"
					+ "4.  Add a Payment\n" + "5. Add a Fee\n" + "6. Display most recent Purchase\n"
					+ "7. Display most recent Payment \n8. Exit to main menu");
			System.out.print("");
			choice = input.nextInt();

		}
		input.nextLine();

		switch (choice) {
		case 1:
			System.out.println("The current balance of card " + cardNum + " is " + card.getCurrentBalance());
			break;
		case 2:
			System.out.println("The current credit limit of card " + cardNum + " is " + card.getAvailCredit());
			break;
		case 3:
			System.out.print("Please enter the purchase type: ");
			String purchase = input.nextLine();
			// figure out how to see if enum contains the String
			// make into a purchase type
			System.out.print("Please enter the amount: ");
			double amount = input.nextDouble();
			while (amount < 0) {
				System.out.print("Invalid amount. Please re-enter the amount: ");
				amount = input.nextDouble();
			}
			System.out.print("Please enter the vendor's name: ");
			String name = input.nextLine();
			System.out.print("Please enter the vendor's email address:  ex:xyz@gmail.com ");
			String email = input.nextLine();
			boolean checkEmail = checkEmailValidity(email);
			while (!checkEmail) {
				System.out.print("InValid email. Please re-enter the email address: ");
				email = input.nextLine();
				checkEmail = checkEmailValidity(email);
			}

			Vendor vendor = new Vendor(name, email);
			card.addPurchase(new Purchase(amount, purchase, vendor));

		case 4:
			System.out.print("Please enter the payment type: ");
			String payment = input.nextLine();
			// figure out how to see if enum contains the String
			
			System.out.print("Please enter the bank account ID affiliated with this payment: ");
			
			
		case 5:
		}
	}

	public static boolean checkEmailValidity(String emailaddress) {
		String email_regex = "[A-Z]+[a-zA-Z_]+@\b([a-zA-Z]+.){2}\b?.[a-zA-Z]+";
		boolean b = emailaddress.matches(email_regex);
		return b;
	}
}

//	a. Display current balance
//	b. Display current credit limit
//	c. Add a Purchase
//	d. Add a Payment-Faygie will finish
//	e. Add a Fee-Toby
//	f. Display most recent Purchase-Faygie
//	g. Display most recent Payment-Chaya
