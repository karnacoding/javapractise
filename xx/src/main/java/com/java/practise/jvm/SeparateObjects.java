package com.java.practise.jvm;

public class SeparateObjects {

    public static void main(String[] args) {

        MyObject myObject = new MyObject();
        Runnable runnable1 = new MyRunnable(myObject);// both threads share same myObject instance,
        // so they will print the same MyObject instance and won't interfere with each
        // other's
        // count variable because they have their own count variable
        Runnable runnable2 = new MyRunnable(myObject);
        Thread thread1 = new Thread(runnable1, "Thread-1");
        Thread thread2 = new Thread(runnable2, "Thread-2");
        thread1.start();
        thread2.start();
        // JVM will create separate stack for each thread,
        // so each thread will have its own count variable and myObject reference
        // variable,
        // but they will point to the same MyObject instance in the heap memory
        // and they will print the same MyObject instance,
        // but they won't interfere with each other's count variable
        // because they have their own count variable in their own stack memory
    }

}
