package threads.task2;

public class Employee implements Runnable{
	
	private BankAccount consignor;
	private BankAccount addressee;
	
	public Employee(BankAccount consignor, BankAccount addressee) {
		this.consignor = consignor;
		this.addressee = addressee;
	}

	@Override
	public void run() {
		consignor.transfer(addressee, 20);
	}

}
