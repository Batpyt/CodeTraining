package Java.Thread;

public class MyThread extends Thread{
    public void run() {
        try{
            Thread.sleep(5000);
            System.out.println("My thread is: " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("MyThread running");
    }

    /**
     * start()是表示线程就绪，等待cpu调用
     * run()存在于main中，相当于直接调用函数
     */
    static class MyThreadDemo{
        public static void main(String[] args) {
            MyThread myThread = new MyThread();
            //myThread.start();
            myThread.run();
            System.out.println("Main Thread: " + Thread.currentThread().getName());
        }
    }

}
