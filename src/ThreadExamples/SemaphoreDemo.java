package ThreadExamples;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) throws Exception{
		Semaphore semaphore = new Semaphore(1);
		
		MyThread thread1 = new MyThread(semaphore);
		thread1.setName("A");
		MyThread thread2 = new MyThread(semaphore);
		thread2.setName("B");
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}

}

class MyThread extends Thread {
	Semaphore semaphore;
	MyThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	public void run() {
		if (currentThread().getName().equalsIgnoreCase("A")) {
			try {
				semaphore.acquire();
				for(int i=0; i < 5; i++) 
                { 
                    SharedResource.count++; 
                    System.out.println(SharedResource.count); 
          
                    // Now, allowing a context switch -- if possible. 
                    // for thread B to execute 
                    Thread.sleep(10); 
                } 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			semaphore.release();
		} else {
			try {
				semaphore.acquire();
				for (int i = 0; i < 5; i++) {
					SharedResource.count--;
					System.out.println(SharedResource.count);

					// Now, allowing a context switch -- if possible.
					// for thread B to execute
					Thread.sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			semaphore.release();
		}
	}
}

class SharedResource {
	public static int count = 0;
}