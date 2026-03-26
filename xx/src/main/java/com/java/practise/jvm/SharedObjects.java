package com.java.practise.jvm;

public class SharedObjects {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Runnable runnable = new MyRunnable(myObject);// both threads share same myObject instance,
        // so they will print the same MyObject instance and interfere with each other's
        // count variable

        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");
        thread1.start();
        thread2.start();
        // JVM will create separate stack for each thread,
        // so each thread will have its own count variable and myObject reference
        // variable,
        // but they will point to the same MyObject instance in the heap memory
        // and they will print the same MyObject instance,
        // and they will interfere with each other's count variable
        // because they are sharing the same MyRunnable instance
        // and the count variable is an instance variable

    }

}
