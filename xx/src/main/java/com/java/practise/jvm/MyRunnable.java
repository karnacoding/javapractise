package com.java.practise.jvm;

public class MyRunnable implements Runnable {

    private int count = 0;

    private MyObject myObject = new MyObject();

    public MyRunnable() {
    }

    public MyRunnable(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {

        // MyObject myObject = new MyObject(); // local variable,
        // so each thread will have its own MyObject instance

        System.out.println(myObject);

        for (int i = 0; i < 1_000_000; i++) {
            this.count++;
        }
        System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }

}
