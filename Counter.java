package dataStructures;

public class Counter {
	private int counter;
	
	public Counter(int counter) {
		this.counter=counter;
	}
	
	public void increment(){
		counter++;
	}
	
	public int getIncCounter() {
		return counter;
	}

}
