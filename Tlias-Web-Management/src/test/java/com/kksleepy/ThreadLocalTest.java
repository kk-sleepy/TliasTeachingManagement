package com.kksleepy;

public class ThreadLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();
    public static void main(String[] args) {
        local.set("Hello, ThreadLocal!");
        System.out.println(local.get());
        new Thread(new Runnable() {
            public void run(){
                System.out.println(Thread.currentThread().getName()+":" + local.get());
            }
        }).start();
        local.remove();
        System.out.println(local.get());
    }
}
