package dataStructures;

import java.util.ArrayList;

public class CreditCards {
	private ArrayList<CreditCard> cards;

	public CreditCards() {
		cards = new ArrayList<CreditCard>();
	}

	public ArrayList<CreditCard> activeCards() {
		ArrayList<CreditCard> activeCards = new ArrayList<CreditCard>();
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getCreditCardStatus().equals(CreditCardStatus.ACTIVE)) {
				activeCards.add(cards.get(i));
			}
		}
		return activeCards;
	}

	public double totalBalance() {
		double totBalance = 0;
		for (int i = 0; i < cards.size(); i++) {
			totBalance += cards.get(i).getCurrentBalance();
		}
		return totBalance;
	}

	public double totalAvailCredit() {
		double totCredit = 0;
		for (int i = 0; i < cards.size(); i++) {
			totCredit += cards.get(i).getAvailCredit();
		}
		return totCredit;
	}

	public Payment getMostRecentPayment() {
		Payment recent = cards.get(0).getMostRecentPayment();
		// assuming last credit card added has the most recent payment
		for (int i = cards.size() - 1; i > 0; i--) {
			if (!cards.get(i).getMostRecentPayment().equals(null)) {
				return cards.get(i).getMostRecentPayment();

			}

		}
		return null;

	}

	public double getTotalCar() {
		double total = 0;
		for (int i = 0; i < cards.size(); i++) {
			total += cards.get(i).getTotalCar();
		}
		return total;
	}

	public double getTotalFood() {
		double total = 0;
		for (int i = 0; i < cards.size(); i++) {
			total += cards.get(i).getTotalFood();
		}
		return total;
	}

	public double getTotalClothing() {
		double total = 0;
		for (int i = 0; i < cards.size(); i++) {
			total += cards.get(i).getTotalClothing();
		}
		return total;
	}

	public double getTotalGroceries() {
		double total = 0;
		for (int i = 0; i < cards.size(); i++) {
			total += cards.get(i).getTotalGroceries();
		}
		return total;
	}

	public double getTotalRestaurant() {
		double total = 0;
		for (int i = 0; i < cards.size(); i++) {
			total += cards.get(i).getTotalRestaurant();
		}
		return total;
	}

	public double getTotalLodging() {
		double total = 0;
		for (int i = 0; i < cards.size(); i++) {
			total += cards.get(i).getTotalLodging();
		}
		return total;
	}

	public double getTotalUtilities() {
		double total = 0;
		for (int i = 0; i < cards.size(); i++) {
			total += cards.get(i).getTotalUtilities();
		}
		return total;
	}

	public double getTotalTravel() {
		double total = 0;
		for (int i = 0; i < cards.size(); i++) {
			total += cards.get(i).getTotalTravel();
		}
		return total;
	}

	public PurchaseType getMostPurchase() {

		
		double clothTotal = cards.get(0).getTotalClothing();
		double carTotal = cards.get(0).getTotalCar();
		double foodTotal = cards.get(0).getTotalFood();
		double grocerTotal = cards.get(0).getTotalGroceries();
		double lodgeTotal = cards.get(0).getTotalLodging();
		double restaurantTotal = cards.get(0).getTotalRestaurant();
		double travelTotal = cards.get(0).getTotalTravel();
		double utilitiesTotal = cards.get(0).getTotalUtilities();
		for (int i = 1; i < cards.size(); i++) {// how do I compare to see which purchase is the greatest??
			carTotal += cards.get(i).getTotalCar();
			clothTotal += cards.get(i).getTotalClothing();
			foodTotal += cards.get(i).getTotalFood();
			grocerTotal += cards.get(i).getTotalGroceries();
			lodgeTotal += cards.get(i).getTotalLodging();
			restaurantTotal += cards.get(i).getTotalRestaurant();
			travelTotal += cards.get(i).getTotalTravel();
			utilitiesTotal += cards.get(i).getTotalUtilities();
		}	
			double[] totals = { carTotal, clothTotal, foodTotal, grocerTotal, lodgeTotal, restaurantTotal, travelTotal,
					utilitiesTotal };
			PurchaseType[] types = { PurchaseType.CAR, PurchaseType.CLOTHING, PurchaseType.FOOD, PurchaseType.GROCERIES,
					PurchaseType.LODGING, PurchaseType.RESTAURANT, PurchaseType.TRAVEL, PurchaseType.UTILITIES };
			PurchaseType largestPurchase = types[0];
			double largest = totals[0];
			for (int i = 1; i < totals.length; i++) {
				if (totals[i] > largest) {
					largest = totals[i];
					largestPurchase = types[i];
				}

			
		}
		return largestPurchase;
	}

	public void addCard(CreditCard creditCard) {
		if (!cards.contains(creditCard)) {
			cards.add(creditCard);
		}
	}

	public void removeCard(CreditCard creditCard) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).equals(creditCard)) {
				cards.remove(i);
			}
		}
	}

	public CreditCard findCard(String id) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).equals(id)) {
				return cards.get(i);
			}
		}
		return null;
	}

	public void addPurchase(CreditCard creditCard, Purchase purchase) {
		creditCard.addPurchase(purchase);

	}

	public void addFee(CreditCard creditCard, Fee fee) {
		creditCard.addFee(fee);
	}

	public void addPayment(CreditCard creditCard, Payment payment) throws addPaymentException, cantPayException {
		creditCard.addPayment(payment);
	}

}
