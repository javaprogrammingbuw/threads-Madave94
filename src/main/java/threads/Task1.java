package threads;

public class Task1 extends Thread{
	
	volatile int sum;
	
	public int quickSum(int[] arr) {
		this.sum = 0;
		
		int length = arr.length;
		
		Thread t1 = new Thread(new SimpleSumThread(arr, 0, length/2-1));
		t1.start();
		Thread t2 = new Thread(new SimpleSumThread(arr, length/2, length-1));
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return sum;
	}
	
	public void addToSum(int partSum) {
		sum += partSum;
	}
}
