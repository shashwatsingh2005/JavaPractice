package com.java.features.eight.lambda;

/**
 * This is demo for use of lambda expression for functional Use.
 */
public class LambdaWithFI {
    public static void main(String[] args) {
        System.out.println("Before Runnable Thread Name : "+Thread.currentThread().getId());
        Runnable runnable = ()->{
            System.out.println("Thread Name : "+Thread.currentThread().getId());
        };

        runnable.run();

        Thread myThread = new Thread(()->{System.out.println("Thread Details : "+Thread.currentThread().getId());});
        myThread.start();
    }
}
