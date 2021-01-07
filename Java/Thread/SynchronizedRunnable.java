package Java.Thread;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class SynchronizedRunnable implements Runnable {

    private int index = 1;
    private final static int max = 200;
    private final Object monitor = new Object();
    @Override
    public void run() {
        while(true) {
            //synchronized修饰代码块
            synchronized (monitor) {
                if(index > max) break;
                try{
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+" is dealing number: "+index++);
            }
        }

    }
}

class Synchronized2 implements Runnable {

    private int index = 1;

    private final static int MAX = 200;

    @Override
    public void run() {
        while (true){
            if(!callNumber()){
                break;
            }
        }

    }
    // 叫号 同步实例方法
    //synchronized修饰实例方法
    private synchronized boolean callNumber(){
        if(index > MAX){
            return false;
        }
        try {
            // 模拟取号耗时
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
        return  true;
    }
}

class Client {
    public static void main(String[] args) {
        final SynchronizedRunnable s = new SynchronizedRunnable();
        final Synchronized2 s2 = new Synchronized2();
        Thread window1 = new Thread(s, "window1");
        Thread window2 = new Thread(s, "window2");
        Thread window3 = new Thread(s, "window3");
//        window2.start();
//        window1.start();
//        window3.start();

        Thread w1 = new Thread(s2, "window1");
        Thread w2 = new Thread(s2, "window2");
        Thread w3 = new Thread(s2, "window3");
        w2.start();
        w1.start();
        w3.start();
    }
}


