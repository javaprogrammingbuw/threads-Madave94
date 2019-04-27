package threads.task1;

public class SimpleSumThread implements Runnable{
	
	private int start;
	private int end;
	private int[] arr;
	Task1 returnToMe;
	
	public SimpleSumThread (Task1 returnToMe, int[] arr, int start, int end) {
		this.start = start;
		this.end = end;
		this.arr = arr;	
		this.returnToMe = returnToMe;
	}
	
	public SimpleSumThread (int[] arr, int start, int end) {
		this(null, arr, start, end);
	}

	@Override
	public void run() {
		Thread thisThread = Thread.currentThread();
		System.out.println("Running " + thisThread.getName());
		arr = partArray();
		returnToMe.addToSum(sumArray());
	}
	
	public int sumArray() {
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	int[] partArray() {
		int[] newArr = new int[end-start+1];
		
		for (int i=0; i<newArr.length; i++) {
			newArr[i] = arr[start+i];
		}
		
		return newArr;
	}

}
