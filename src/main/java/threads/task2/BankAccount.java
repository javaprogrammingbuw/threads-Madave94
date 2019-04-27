package threads.task2;

public class BankAccount {
	
	private String IBAN;
	private double balance;
	private double limit;
	
	public BankAccount(String IBAN, double balance, double limit) {
		this.IBAN = IBAN;
		this.balance = balance;
		this.limit = limit;
	}
	
	public void transfer(BankAccount addressee, double amount) {
		// TODO
	}
		
	public void withdraw(double amount) {
		// TODO
	}

	public void deposit(double amount) {
		// TODO
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getLimit() {
		return limit;
	}
	
	public String getIBAN() {
		return IBAN;
	}
}
