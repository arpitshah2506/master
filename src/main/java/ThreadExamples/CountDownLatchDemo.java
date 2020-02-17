package ThreadExamples;

import java.util.concurrent.CountDownLatch;


/**
 * @author Arpit
 * CountDownLatch is used to make service start once all the threads have started their execution
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(4); 
		//change this number so your service started stmt will wait for that no. of thread
		
		WorkerThread thread1 = new WorkerThread(countDownLatch,"t1");
		WorkerThread thread2 = new WorkerThread(countDownLatch,"t2");
		WorkerThread thread3 = new WorkerThread(countDownLatch,"t3");
		WorkerThread thread4 = new WorkerThread(countDownLatch,"t4");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		countDownLatch.await();
		System.out.println("Service started");
	}

}

class WorkerThread extends Thread {
	CountDownLatch countDownLatch;
	String threadName;
	WorkerThread(CountDownLatch countDownLatch, String threadName) {
		this.countDownLatch = countDownLatch;
		this.threadName = threadName;
	}
	
	public void run() {
		System.out.println(currentThread().getName() + " decremented latch");
		countDownLatch.countDown();
	}
}