package dataStructures;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreditCard {

	private String creditCardId;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private String issueCompany;// is this right?
	private CreditCardType creditCardType; // create enum
	private CreditCardStatus creditCardStatus;// create enum
	private double creditCardLimit;
	private double currentBalance;
	private double availCredit;
	private ArrayList<Transaction> transactions; // create class
	private double[] totals;

	public CreditCard(String creditCardID, LocalDate expirationDate, String issueCompany, CreditCardType creditCardType,
			double creditCardLimit) {
		this.creditCardId = creditCardID;
		issueDate = LocalDate.now();
		this.expirationDate = expirationDate;
		this.issueCompany = issueCompany;
		this.creditCardType = creditCardType;
		creditCardStatus = CreditCardStatus.ACTIVE;
		this.creditCardLimit = creditCardLimit;
		currentBalance = 0;
		availCredit = creditCardLimit;
		transactions = new ArrayList<Transaction>();
	}

	public void addPurchase(Purchase purchase) {
		// should we check if avaialable credit has enought
		currentBalance += purchase.getAmount();
		availCredit -= purchase.getAmount();
		transactions.add(purchase);

	}

	public void addPayment(Payment payment) throws addPaymentException, cantPayException {
		try {
			if (payment.getAmount() > currentBalance) {
				throw new addPaymentException();
			}
			payment.withdrawal(payment.getAmount());
			currentBalance -= payment.getAmount();
			availCredit += payment.getAmount();
			transactions.add(payment);
		} catch (addPaymentException e) {
			e.getMessage();
		}

	}

	public void addFee(Fee fee) {
		currentBalance += fee.getAmount();
		availCredit -= fee.getAmount();
		transactions.add(fee);

	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public double getAvailCredit() {
		return availCredit;
	}

	public Purchase getLargestPurchase() {
		ArrayList<Transaction> purchases = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				purchases.add(transactions.get(i));
			}
		}
		Purchase largest = (Purchase) purchases.get(0);

		for (int i = 1; i < purchases.size(); i++) {
			if (purchases.get(i).getAmount() > largest.getAmount()) {
				largest = (Purchase) purchases.get(i);
			}
		}
		return largest;
	}

	public double getTotalFees() {
		ArrayList<Transaction> fees = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.FEE)) {
				fees.add(transactions.get(i));
			}
		}

		double total = 0;
		for (int i = 0; i < fees.size(); i++) {
			total += fees.get(i).getAmount();
		}
		return total;
	}

	public Purchase getMostRecentPurchase() {

		for (int i = transactions.size() - 1; i > 0; i--) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				return (Purchase) transactions.get(i);

			}

		}
		return null;

	}

	public double getTotalTravel() {
		ArrayList<Transaction> purchases = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				purchases.add(transactions.get(i));
			}
		}
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) {
			Purchase purchaseType = (Purchase) purchases.get(i);
			if (purchaseType.getPurchaseType().equals(PurchaseType.TRAVEL)) {
				total += purchases.get(i).getAmount();
			}
		}
		return total;
	}

	public double getTotalUtilities() {
		ArrayList<Transaction> purchases = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				purchases.add(transactions.get(i));
			}
		}
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) {
			Purchase purchaseType = (Purchase) purchases.get(i);
			if (purchaseType.getPurchaseType().equals(PurchaseType.UTILITIES)) {
				total += purchases.get(i).getAmount();
			}
		}
		return total;
	}

	public double getTotalLodging() {
		ArrayList<Transaction> purchases = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				purchases.add(transactions.get(i));
			}
		}
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) {
			Purchase purchaseType = (Purchase) purchases.get(i);
			if (purchaseType.getPurchaseType().equals(PurchaseType.LODGING)) {
				total += purchases.get(i).getAmount();
			}
		}
		return total;
	}

	public double getTotalRestaurant() {
		ArrayList<Transaction> purchases = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				purchases.add(transactions.get(i));
			}
		}
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) {
			Purchase purchaseType = (Purchase) purchases.get(i);
			if (purchaseType.getPurchaseType().equals(PurchaseType.RESTAURANT)) {
				total += purchases.get(i).getAmount();
			}
		}
		return total;
	}

	public double getTotalCar() {
		ArrayList<Transaction> purchases = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				purchases.add(transactions.get(i));
			}
		}
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) {
			Purchase purchaseType = (Purchase) purchases.get(i);
			if (purchaseType.getPurchaseType().equals(PurchaseType.CAR)) {
				total += purchases.get(i).getAmount();
			}
		}
		return total;
	}

	public double getTotalClothing() {
		ArrayList<Transaction> purchases = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				purchases.add(transactions.get(i));
			}
		}
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) {
			Purchase purchaseType = (Purchase) purchases.get(i);
			if (purchaseType.getPurchaseType().equals(PurchaseType.CLOTHING)) {
				total += purchases.get(i).getAmount();
			}
		}
		return total;
	}

	public double getTotalFood() {
		ArrayList<Transaction> purchases = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				purchases.add(transactions.get(i));
			}
		}
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) {
			Purchase purchaseType = (Purchase) purchases.get(i);
			if (purchaseType.getPurchaseType().equals(PurchaseType.FOOD)) {
				total += purchases.get(i).getAmount();
			}
		}
		return total;
	}

	public double getTotalGroceries() {
		ArrayList<Transaction> purchases = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).getType().equals(TransactionType.PURCHASE)) {
				purchases.add(transactions.get(i));
			}
		}
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) {
			Purchase purchaseType = (Purchase) purchases.get(i);
			if (purchaseType.getPurchaseType().equals(PurchaseType.GROCERIES)) {
				total += purchases.get(i).getAmount();
			}
		}
		return total;
	}

	public Payment getMostRecentPayment() {
		for (int i = transactions.size() - 1; i > 0; i--) {
			if (transactions.get(i).getType().equals(TransactionType.PAYMENT)) {
				return (Payment) transactions.get(i);

			}

		}
		return null;

	}

	// make method that returns which purchase the most money was spent for
	public PurchaseType getMostMoneySpent() {

		double carTotal = getTotalCar();
		double clothTotal = getTotalClothing();
		double foodTotal = getTotalFood();
		double grocerTotal = getTotalGroceries();
		double lodgeTotal = getTotalLodging();
		double restaurantTotal = getTotalRestaurant();
		double travelTotal = getTotalTravel();
		double utilitiesTotal = getTotalUtilities();

		double[] totals = { carTotal, clothTotal, foodTotal, grocerTotal, lodgeTotal, restaurantTotal, travelTotal,
				utilitiesTotal };
		PurchaseType[] types = { PurchaseType.CAR, PurchaseType.CLOTHING, PurchaseType.FOOD, PurchaseType.GROCERIES,
				PurchaseType.LODGING, PurchaseType.RESTAURANT, PurchaseType.TRAVEL, PurchaseType.UTILITIES };

		double largest = totals[0];
		PurchaseType largestPurchase = types[0];
		for (int i = 1; i < totals.length; i++) {
			if (totals[i] > largest) {
				largest = totals[i];
				largestPurchase = types[i];
			}

		}
		
		return largestPurchase;
	}

	public CreditCardStatus getCreditCardStatus() {
		return creditCardStatus;
	}

	public String getCreditCardID() {
		return creditCardId;
	}

	public int compareTo(CreditCard other) {
		if (getMostRecentPurchase().compareTo(other.getMostRecentPurchase()) > 0) {
			return 1;
		}
		return 0; // } see if we need this later
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (creditCardId == null) {
			if (other.creditCardId != null)
				return false;
		} else if (!creditCardId.equals(other.creditCardId))
			return false;
		return true;
	}
}
