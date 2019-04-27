package threads.task2;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;

public class Task2Test {
	
	private static final double DELTA = 0.001;
	
	@Test
	public void testWithdraw() {
		BankAccount a = new BankAccount ("DE52 1200 3000 4000 5000", 300, 50);
		a.withdraw(50);
		assertEquals(250, a.getBalance(), DELTA);
	}
	
	@Test
	public void testDeposit() {
		BankAccount a = new BankAccount ("DE52 1200 3000 4000 5000", 300, 50);
		a.deposit(50);
		assertEquals(350, a.getBalance(), DELTA);
	}
	
	@Test
	public void testSimpleTransfer() {
		BankAccount a = new BankAccount ("DE52 1200 3000 4000 5000", 300, 50);
		BankAccount b = new BankAccount ("FR74 9800 7000 6000 0005", 300, 50);
		a.transfer(b, 50);
		assertEquals(250, a.getBalance(), DELTA);
		assertEquals(350, b.getBalance(), DELTA);
	}
	
	@Test
	public void testBankingSituation() throws InterruptedException {
		BankAccount a = new BankAccount ("DE52 1200 3000 4000 5000", 300, 50);
		BankAccount b = new BankAccount ("FR74 9800 7000 6000 0005", 300, 50);
		BankAccount c = new BankAccount ("GB31 4000 3200 5400 7198", 300, 50);
		Thread employeeX = new Thread(new Employee(a,b));
		Thread employeeY = new Thread(new Employee(b,c));
		Thread employeeZ = new Thread(new Employee(c,a));
		employeeX.start();
		employeeY.start();
		employeeZ.start();
		// Wait before checking assertions
		Thread.sleep(100);
		assertEquals(300, a.getBalance(), DELTA);
		assertEquals(300, b.getBalance(), DELTA);
		assertEquals(300, c.getBalance(), DELTA);
	}

}
