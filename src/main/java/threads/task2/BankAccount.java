package threads.task2;

import java.util.concurrent.locks.*;

public class BankAccount {
	
	private String IBAN;
	private double balance;
	private double limit;
	final Lock lock = new ReentrantLock();
	
	public BankAccount(String IBAN, double balance, double limit) {
		this.IBAN = IBAN;
		this.balance = balance;
		this.limit = limit;
	}
	
	public void transfer(BankAccount addressee, double amount) {
		this.withdraw(amount);
		addressee.deposit(amount);
	}
		
	public void withdraw(double amount) {
		if (amount <= limit) 
		{
			changeBalance(amount, false);
		}
	}
	
	public void deposit(double amount) {
		changeBalance(amount, true);
	}
	
	synchronized private void changeBalance(double amount, boolean isAddition) {
		if (isAddition) {
			balance += amount;
		} else {
			balance -= amount;
		}
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
