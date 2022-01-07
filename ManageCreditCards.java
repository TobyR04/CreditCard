package dataStructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
		CreditCards cards = new CreditCards();
		BankAccounts bankAccounts = new BankAccounts();// add cards to this
		boolean again = true;
		do {
			System.out.println("Please choose a menu option: ");
			System.out.print(
					"\n1. Add a new Credit Card \n2. Remove a Credit Card \n3. Display total outstanding balances"
							+ "\n4. Display total available credit \n5. Display largest purchase\n"
							+ "6. Display most recent payment\n"
							+ "7. Display total spent on certain category of expense\n"
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
				again = chooseOption(choice, input, cards, bankAccounts);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (again);

	}

	public static boolean chooseOption(int choice, Scanner input, CreditCards cards, BankAccounts bankAccounts)
			throws ParseException {

		switch (choice) {
		case 1:
			case1(input, cards);
			break;
		case 2:
			case2(input, cards);
			break;
		case 3:
			if (cards.isEmpty()) {// validation is off-saying there is no cards
				System.out.println("You have no cards in your database at this time.");
			} else {
				System.out.println("The total outstanding balance: " + cards.totalBalance());
			}
			break;
		case 4:
			if (cards.isEmpty()) {
				System.out.println("You have no cards in your database at this time.");
			} else {
				System.out.println("The total available credit is: " + cards.totalAvailCredit());
			}
			break;
		case 5:
			if (cards.isEmpty()) {
				System.out.println("You have no cards in your database at this time.");
			} else if(cards.getLargestPurchase()==null){
				System.out.println("You have no purchases at this time.");
			}
			else {
				System.out.println("The largest purchase is: " + cards.getLargestPurchase());
			}
			break;
		case 6:
			if (cards.isEmpty()) {
				System.out.println("You have no cards in your database at this time.");
			} 
			else if(cards.getMostRecentPayment()==null){
				System.out.println("You have no payments at this time.");
			}
			else {
				System.out.println("The most recent Payment is: " + cards.getMostRecentPayment());
			}
			break;

		case 7:

			if (cards.isEmpty()) {
				System.out.println("You have no cards in your database at this time.");
			} else {
				System.out.println("Choose which expense total you would like to see: ");
				System.out.print(
						"1. Car 2. Clothing 3. Food 4. Groceries 5. Lodging 6. Restaurant 7. Travel 8. Utilities ");
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
					break;
				case 2:
					System.out.println("Clothing Total: " + cards.getTotalClothing());
					break;
				case 3:
					System.out.println("Food Total: " + cards.getTotalFood());
					break;
				case 4:
					System.out.println("Groceries Total: " + cards.getTotalGroceries());
					break;
				case 5:
					System.out.println("Lodging Total: " + cards.getTotalLodging());
					break;
				case 6:
					System.out.println("Restaurant Total: " + cards.getTotalRestaurant());
					break;
				case 7:
					System.out.println("Travel Total: " + cards.getTotalTravel());
					break;
				case 8:
					System.out.println("Utilities Total: " + cards.getTotalUtilities());
					break;

				}
			}
			break;
		case 8:
			if (cards.isEmpty()) {
				System.out.println("You have no cards in your database at this time.");
			} 
			else if(cards.getMostPurchase()==null){
				System.out.println("You have no purchases at this time.");
			}
			else {
				System.out.println(cards.getMostPurchase());
			}
			break;
		case 9:
			if (cards.isEmpty()) {
				System.out.println("You have no cards in your database at this time.");
			} else {

				IndividualCardMenu(input, cards, bankAccounts);
			}
			break;
		case 10:
			addBankAccount(input, bankAccounts);
			break;
		default:
			System.out.println("Goodbye...Exiting...");
			return false;

		}
		return true;
	}

	public static boolean isDateFormat(String date) {
		boolean dateCorrect = true;
		if (date.matches("(0?[1-9]|1[012])-((?:19|20)[0-9][0-9])"))
			dateCorrect = true;
		else
			dateCorrect = false;

		return dateCorrect;

	}

	public static void case1(Scanner input, CreditCards creditCards) {
		String creditCardID = enterCreditCard(input, creditCards);
		Date expDate = null;
		System.out.print("Enter the expiration date: (mm-yyyy)");
		String date = input.nextLine();

		while (!isDateFormat(date)) {
			System.out.println("Invalid date. Please try again.");
			System.out.print("Enter the expiration date: (mm-yyyy)");
			date = input.nextLine();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("mm-yyyy");

		try {
			expDate = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.print("Enter the company that issued the credit card: ");
		String issueCompany = input.nextLine();

		System.out.println("Enter the credit card type: (choose a number)");
		System.out.println("1. VISA \n2. MASTERCARD \n3. AMEX");
		int type = input.nextInt();
		while (type < 1 || type > 3) {
			System.out.println("That is not a valid option. Please choose again.");
			System.out.println("Enter the credit card type: (choose a number)");
			System.out.println("1. VISA \n2.MASTERCARD \n3.AMEX");
			type = input.nextInt();
		}
		input.nextLine();
		CreditCardType CC_Type = null;
		switch (type) {
		case 1:
			CC_Type = CreditCardType.VISA;
			break;
		case 2:
			CC_Type = CreditCardType.MASTERCARD;
			break;
		case 3:
			CC_Type = CreditCardType.AMEX;
			break;
		}

		System.out.print("Enter the credit limit: ");
		double creditCardLimit = input.nextDouble();
		while (creditCardLimit < 0) {
			System.out.println("Invalid Limit. Please enter the limit again.");
			System.out.print("Enter the credit limit: ");
			creditCardLimit = input.nextDouble();
		}
		CreditCard newCreditCard = new CreditCard(creditCardID, expDate, issueCompany, CC_Type, creditCardLimit);
		creditCards.addCard(newCreditCard);

	}

	private static void case2(Scanner input, CreditCards cards) {
		String creditCardID = enterCreditCard(input, cards);
		cards.removeCreditCard(creditCardID);

	}

	public static String enterCreditCard(Scanner input, CreditCards cards) {
		String creditCardID = null;
		do {
			if (cards.contains(creditCardID))

			{
				System.out.println("This credit card already exists.");
			}
			System.out.print("Enter the Credit Card Number: ");
			creditCardID = input.nextLine();
			boolean correct = true;

			if (creditCardID.charAt(0) != ('3') && creditCardID.charAt(0) != ('4') && creditCardID.charAt(0) != ('5')) {
				correct = false;

			}
			if ((creditCardID.charAt(0) == ('3') && creditCardID.length() != 15)
					|| ((creditCardID.charAt(0) == ('5') || creditCardID.charAt(0) == ('4'))
							&& creditCardID.length() != 16)) {
				correct = false;
			}

			while (correct == false) {
				System.out.println("The credit card number that you entered is incorrect.");
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
		} while (cards.contains(creditCardID));

		return creditCardID;
	}

	public static void IndividualCardMenu(Scanner input, CreditCards cards, BankAccounts bankAccounts) {
		System.out.print("Manage a specific credit card. Please input your credit card number: ");
		String cardNum = input.nextLine();
		while (cards.findCard(cardNum) == (null)) {
			System.out.print("You entered an incorrect credit card number. Please try again. ");
			cardNum = input.nextLine();
		}
		CreditCard card = cards.findCard(cardNum);
		boolean again = true;
		do {
			System.out.print("\n1. Display current balance" + "\n2. Display current credit limit \n3. Add a Purchase\n"
					+ "4. Add a Payment\n" + "5. Add a Fee\n" + "6. Display most recent Purchase\n"
					+ "7. Display most recent Payment \n8. Exit to main menu ");

			int choice = input.nextInt();
			while (choice < 1 || choice > 8) {
				System.out.println("You can only enter 1-8. Please re-enter your choice");
				System.out.println("Please choose a menu option: ");
				System.out.print(
						"\n1. Display current balance" + "\n2. Display current credit limit \n3. Add a Purchase\n"
								+ "4. Add a Payment\n" + "5. Add a Fee\n" + "6. Display most recent Purchase\n"
								+ "7. Display most recent Payment \n8. Exit to main menu ");
				System.out.print("");
				choice = input.nextInt();

			}
			input.nextLine();
			PurchaseType purType = null;
			switch (choice) {
			case 1:
				System.out.println("The current balance of card " + cardNum + " is " + card.getCurrentBalance());
				break;
			case 2:
				System.out.println("The current credit limit of card " + cardNum + " is " + card.getAvailCredit());
				break;
			case 3:
				System.out.print("Please enter the purchase type: ");
				System.out.print("\n1. Car \n2. Clothing \n3. Food \n4. Groceries"
						+ "\n5. Lodging \n6. Restaurant \n7. Travel \n8. Utilities ");
				int type = input.nextInt();
				while (type < 1 || type > 8) {
					System.out.println("That is not a valid option. Please choose again.");
					System.out.println("Enter the credit card type: (choose a number)");
					System.out.println("1. Car \n2. Clothing \n3. Food \n4. Groceries"
							+ "\n5. Lodging \n6. Restaurant \n7. Travel \n8. Utilities ");
					type = input.nextInt();
				}
				input.nextLine();

				switch (type) {
				case 1:
					purType = PurchaseType.CAR;
					break;
				case 2:
					purType = PurchaseType.CLOTHING;
					break;
				case 3:
					purType = PurchaseType.FOOD;
					break;
				case 4:
					purType = PurchaseType.GROCERIES;
					break;
				case 5:
					purType = PurchaseType.LODGING;
					break;
				case 6:
					purType = PurchaseType.RESTAURANT;
					break;
				case 7:
					purType = PurchaseType.TRAVEL;
					break;
				case 8:
					purType = PurchaseType.UTILITIES;
					break;
				}

				System.out.print("Please enter the amount: ");
				double amount = input.nextDouble();
				while (amount < 0) {
					System.out.print("Invalid amount. Please re-enter the amount: ");
					amount = input.nextDouble();
				}
				if (amount > card.getAvailCredit()) {
					System.out.println("Sorry, you cannot make this purchase. It's over your credit limit.");
					break;
				}
				input.nextLine();
				System.out.print("Please enter the vendor's name: ");
				String name = input.nextLine();
				System.out.print("Please enter the vendor's email address:  ex:xyz@gmail.com ");
				String email = input.nextLine();
				boolean checkEmail = checkEmailValidity(email);
				while (!checkEmail) {
					System.out.print("Invalid email. Please re-enter the email address: ");
					email = input.nextLine();
					checkEmail = checkEmailValidity(email);
				}

				Vendor vendor = new Vendor(name, email);
				card.addPurchase(new Purchase(amount, purType, vendor));
				break;

			case 4:
				while (bankAccounts.isEmpty()) {
					System.out.print(
							"You have no bank accounts added. Please add a bank account before you make a payment. ");
					addBankAccount(input, bankAccounts);
				}
				System.out.print("Please enter the PaymentType type: Choose 1 for Check and 2 for Online: ");
				int paymentOption = input.nextInt();
				while (paymentOption < 1 || paymentOption > 2) {
					System.out.println("Invalid option.");
					System.out.print("1. Check 2. Online ");
					paymentOption = input.nextInt();
				}
				PaymentType payment = null;
				switch (paymentOption) {
				case 1:
					payment = PaymentType.CHECK;
					break;
				case 2:
					payment = PaymentType.ONLINE;
					break;
				}
				input.nextLine();
				System.out.print("Please enter the bank account ID affiliated with this payment: ");
				String bankID = input.nextLine();
				while (bankAccounts.findAccount(bankID) == null) {
					System.out.print("You entered an incorrect bank number. Please try again. ");
					bankID = input.nextLine();
				}
				BankAccount account = bankAccounts.findAccount(bankID);

				System.out.print("Please enter how much you would like to pay. ");
				double paymentAmount = input.nextDouble();

				try {
					card.addPayment(new Payment(paymentAmount, payment, account));
				} catch (addPaymentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (cantPayException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 5:
				System.out.print("Please enter the fee type: Choose 1 for Late Payment and 2 for Interest: ");
				int feeOption = input.nextInt();
				while (feeOption < 1 || feeOption > 2) {
					System.out.println("Invalid option.");
					System.out.print("1. Late Payment 2. Interest ");
					feeOption = input.nextInt();
				}
				FeeType fee = null;
				switch (feeOption) {
				case 1:
					fee = FeeType.LATEPAYMENT;
					break;
				case 2:
					fee = FeeType.INTEREST;
					break;
				}
				System.out.print("Please enter the amount: ");
				double feeAmount = input.nextDouble();
				while (feeAmount < 0) {
					System.out.print("Invalid amount. Please re-enter the amount: ");
					feeAmount = input.nextDouble();
				}
				card.addFee(new Fee(feeAmount, fee));
				break;
			case 6:
				System.out.println("The most recent purchase is " + card.getMostRecentPurchase());
				break;
			case 7:
				System.out.println("the most recent payment is: " + card.getMostRecentPayment());
				break;
			default:
				System.out.println("Returning to main menu...");
				again = false;
			}
		} while (again);
	}

	public static boolean checkEmailValidity(String emailaddress) {
		boolean email_valid = true;
		if (emailaddress.matches("[\\w]+@[\\w]+\\.[a-zA-Z]{2,3}"))
			email_valid = true;
		else
			email_valid = false;

		return email_valid;
	}

	public static void addBankAccount(Scanner input, BankAccounts bankAccounts) {
		String bankName=null;
		String bankID=null;
		double balance =0;
		do {
		if(bankAccounts.contains(bankID)) {
			System.out.println("You already have that bank added. Please add a different one");
		}
		System.out.print("Please enter the bank name: ");
		bankName = input.nextLine();
		System.out.print("Please enter the bank ID: ");	
		 bankID = input.nextLine();
		System.out.print("Please enter the balance: ");
		 balance = input.nextDouble();
		while (balance < 0) {
			System.out.print("Invalid amount. Please enter the amount again:");
			balance = input.nextDouble();
		}
		}
		while(bankAccounts.contains(bankID));
		bankAccounts.addBankAccount(new BankAccount(bankName, bankID, balance));
	}
}
