package TreadPool;

import java.util.Date;
import java.util.concurrent.*;

public class TreadPoolTest {
	public static void main(String[] args) {
		ExecutorService fixedTreadPool = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 10; i++) {
			final int index = i + 1;
			fixedTreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(600);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("delay 1 seconds, and excute every 3 seconds" + new Date());
			}
		}, 1, 3, TimeUnit.SECONDS);
	}

	public static ExecutorService newFixedThreadPool(int nThreads) {
		return new ThreadPoolExecutor(nThreads, nThreads, 3000, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
	}

	public static ExecutorService newSingleThreadExecutor() {
		return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}

	public static ExecutorService newCachedThreadPool() {
		return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
	}

}
