package com.accolite.source;

public class ThreadExample {


	public static void main(String[] args) {
        Market market=new Market();
        Thread producer1 = new Thread(new Producer(market,"Producer 1"));
        Thread producer2 = new Thread(new Producer(market,"Producer 2"));
        Thread producer3 = new Thread(new Producer(market,"Producer 3"));
        Thread producer4 = new Thread(new Producer(market,"Producer 4"));
        Thread consumer1 = new Thread(new Consumer(market,"Consumer 1"));
        Thread consumer2 = new Thread(new Consumer(market,"Consumer 2"));
        Thread consumer3 = new Thread(new Consumer(market,"Consumer 3"));
        Thread consumer4 = new Thread(new Consumer(market,"Consumer 4"));
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        producer3.start();
        producer4.start();
	}


}
