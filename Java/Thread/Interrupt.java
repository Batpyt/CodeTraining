package Java.Thread;

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                while(true) {
                    System.out.println("Still running");
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted");
                        break;
                    }
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
