package threads.task1;

public class Task1 extends Thread{
	
	int sum;
	
	public int quickSum(int[] arr) {
		this.sum = 0;
		
		int length = arr.length;
		
		Thread t1 = new Thread(new SimpleSumThread(this, arr, 0, length/2));
		Thread t2 = new Thread(new SimpleSumThread(this, arr, length/2+1, length-1));
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return sum;
	}
	
	synchronized public void addToSum(int partSum) {
		System.out.println("[" + partSum + "] added to [" + sum + "]");
		sum += partSum;
	}
}
