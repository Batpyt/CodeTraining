package TreadPool;

import java.util.concurrent.*;

public class NewTestThreadPool {
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
//		fixedThreadPool.submit(new MyRun());
//		fixedThreadPool.submit(new MyRun());
//		fixedThreadPool.submit(new MyRun());
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		Thread t3 = new MyThread();
		Thread t4 = new MyThread();
		Thread t5 = new MyThread();

		fixedThreadPool.execute(t1);
		fixedThreadPool.execute(t2);
		fixedThreadPool.execute(t3);
		fixedThreadPool.execute(t4);
		fixedThreadPool.execute(t5);

		fixedThreadPool.shutdown();
	}

	static class MyRun implements Runnable {

		@Override
		public void run() {
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
		}
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+" running");
		}
	}
}
