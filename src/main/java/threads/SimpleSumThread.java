package threads;

public class SimpleSumThread implements Runnable{
	
	private int start;
	private int end;
	private int[] arr;
	
	public SimpleSumThread (int[] arr, int start, int end) {
		this.start = start;
		this.end = end;
		this.arr = arr;		
	}

	@Override
	public void run() {
		Thread thisThread = Thread.currentThread();
		System.out.println("Running " + thisThread.getName());	
		
	}
	
	public int sumArray(int[] arr) {
		return 0;
	}
	
	int[] partArray() {
		int[] newArr = new int[end+1];
		
		for (int i=0; i<newArr.length; i++) {
			newArr[i] = arr[start+i];
		}
		
		return newArr;
	}

}
