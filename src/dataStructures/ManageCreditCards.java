package dataStructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ManageCreditCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		menu(input);

	}

	public static void menu(Scanner input) {

		System.out.println("Please choose a menu option: ");
		System.out.print("\n1. Add a new Credit Card \n2. Remove a Credit Card \n 3. Display total outstanding balances"
				+ "\n4. Display total available credit \n5. 5. Display largest purchase\n"
				+ "6. Display most recent payment\n" + "7. Display total spent on certain category of expense\n"
				+ "8. For which type of Purchase was the most money spent\n"
				+ "9. Manage a specific Credit Card \n10. Exit");

		int choice = input.nextInt();
		while (choice < 1 || choice > 10) {
			System.out.println("You can only enter 1-10. Please re-enter your choice");
			System.out.println("Please choose a menu option: ");
			System.out.print(
					"\n1. Add a new Credit Card \n2. Remove a Credit Card \n 3. Display total outstanding balances"
							+ "\n4. Display total available credit \n5. 5. Display largest purchase\n"
							+ "6. Display most recent payment\n"
							+ "7. Display total spent on certain category of expense\n"
							+ "8. For which type of Purchase was the most money spent\n"
							+ "9. Manage a specific Credit Card \n10. Exit");

			choice = input.nextInt();
		}
		input.nextLine();
		chooseOption(choice, input);

	}

	public static void chooseOption(int choice, Scanner input) throws ParseException {
		switch (choice) {
		case 1:
			System.out.print("Enter the Credit Card Number: ");
			String creditCardID = input.nextLine();
			boolean correct = true;
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
			}
			catch(ParseException e) {
				//figure out how to catch validating
			}
		}
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

	}

//	1. Add a new CreditCard
//	2. Remove a CreditCard
//	3. Display total outstanding balances
//	4. Display total available credit
//	5. Display largest purchase 
//	6. Display most recent payment
//	7. Display total spent on certain category of expense
//	8. For which type of Purchase was the most money spent
//	9. Manage a specific Credit Card
//	a. Display current balance
//	b. Display current credit limit
//	c. Add a Purchase
//	d. Add a Payment
//	e. Add a Fee
//	f. Display most recent Purchase
//	g. Display most recent Payment

}
