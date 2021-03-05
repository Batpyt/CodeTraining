package Java.Thread;

public class UnSafeThreads {
    private static int i = 0;
    public static class Mythread extends Thread{
        @Override
        public void run() {
//            synchronized (this){
//                for (int j = 0; j < 1000; j++) {
//                    i++;
//                }
//            }
            for (int j = 0; j < 1000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Mythread t1 = new Mythread();
        Mythread t2 = new Mythread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i最后的值是：" + i);
    }
}
