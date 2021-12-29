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
		//assuming last credit card added has the most recent payment
		for (int i = cards.size() - 1; i > 0; i--) {
			if (!cards.get(i).getMostRecentPayment().equals(null)) {
				return cards.get(i).getMostRecentPayment();

			}

		}
		return null;

	}
	
	public double getTotalCar() {
		double total=0;
		for(int i = 0;i<cards.size();i++) {
			total+=cards.get(i).getTotalCar();
		}
		return total;
	}
	
	public double getTotalFood() {
		double total=0;
		for(int i = 0;i<cards.size();i++) {
			total+=cards.get(i).getTotalFood();
		}
		return total;
	}

	public double getTotalClothing() {
		double total=0;
		for(int i = 0;i<cards.size();i++) {
			total+=cards.get(i).getTotalClothing();
		}
		return total;
	}
	public double getTotalGroceries() {
		double total=0;
		for(int i = 0;i<cards.size();i++) {
			total+=cards.get(i).getTotalGroceries();
		}
		return total;
	}
	
	public double getTotalRestaurant() {
		double total=0;
		for(int i = 0;i<cards.size();i++) {
			total+=cards.get(i).getTotalRestaurant();
		}
		return total;
	}
	
	public double getTotalLodging() {
		double total=0;
		for(int i = 0;i<cards.size();i++) {
			total+=cards.get(i).getTotalLodging();
		}
		return total;
	}
	public double getTotalUtilities() {
		double total=0;
		for(int i = 0;i<cards.size();i++) {
			total+=cards.get(i).getTotalUtilities();
		}
		return total;
	}
	public double getTotalTravel() {
		double total=0;
		for(int i = 0;i<cards.size();i++) {
			total+=cards.get(i).getTotalTravel();
		}
		return total;
	}
	
	public PurchaseType getMostPurchase() {

		PurchaseType largest=cards.get(0).getMostMoneySpent();
		for(int i =1; i<cards.size();i++) {//how do I compare to see which purchase is the greatest??
			double carTotal = getTotalCar();
			double clothTotal = getTotalClothing();
			double foodTotal = getTotalFood();
			double grocerTotal = getTotalGroceries();
			double lodgeTotal = getTotalLodging();
			double restaurantTotal = getTotalRestaurant();
			double travelTotal = getTotalTravel();
			double utilitiesTotal = getTotalUtilities();
			
			//go through purchases...
			if(cards.get(i).getMostMoneySpent().compareTo(largest)>0) { //make a compare to method which compares purchases???
				largest=cards.get(i).getMostMoneySpent();
			}
		}
		return largest;
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
			if (cards.get(i).getCreditCardID().equals(id)) {
				return cards.get(i);
			}
		}
		return null;// check if right
	}

	public void addPurchase(CreditCard creditCard, Purchase purchase) {
		creditCard.addPurchase(purchase);
		// why do we need this?
	}

	public void addFee(CreditCard creditCard, Fee fee) {
		creditCard.addFee(fee);
	}

	public void addPayment(CreditCard creditCard, Payment payment) throws addPaymentException, cantPayException {
		creditCard.addPayment(payment);
	}

}
