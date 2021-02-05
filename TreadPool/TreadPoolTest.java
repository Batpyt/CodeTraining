package TreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	}
}
