import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;
//conflict
public class Threadexample {
        static final int CAPACITY=10;
        static final int TYPES_OF_FRUITS=3;
        static final int APPLE=1;
        static final int BANANA=2;
        static final int MANGO=3;
        public static final String[] fruittype={"APPLE","BANANA","MANGO"};

        public static class Market
        {
            int fruits[];
            int currentNumber;
            Market()
            {
                fruits=new int[TYPES_OF_FRUITS];
                for(int i=0;i<TYPES_OF_FRUITS;i++)
                    fruits[i]=0;
                currentNumber=0;
            }
            synchronized boolean canIsell(int n,String Name)
            {
                try
                {
                while(n+currentNumber>CAPACITY)
                {
                System.out.println(Name+" is waiting to Sell.");
                    wait();
                }
                }catch(InterruptedException e)  
                {

                }
                return true;
            }
            synchronized boolean isavailable(int fruit[],String Name)
            {
                try{
                for(int i=0;i<TYPES_OF_FRUITS;i++)
                    if(fruits[i]<fruit[i])
                        {
                            System.out.println(Name+" is waiting to Buy.");
                            wait();
                            i=0;
                        }
                    }catch(Exception e)
                    {

                    }
                    return true;
            }
            synchronized void produce(int fruit[],String Name)
            {
                for(int i=0;i<TYPES_OF_FRUITS;i++)
                    {
                        fruits[i]+=fruit[i];
                        currentNumber+=fruit[i];
                        System.out.println(Name+" Produced "+fruit[i]+" "+fruittype[i]);
                    }
                    notify();
            }
            synchronized void consume(int fruit[],String Name)
            {
                for(int i=0;i<TYPES_OF_FRUITS;i++)
                    {
                        fruits[i]-=fruit[i];
                        currentNumber-=fruit[i];

                        System.out.println(Name+" consumed "+fruit[i]+" "+fruittype[i]);
                    }
                    notify();
            }

        }
        public static class Producer implements Runnable {
                private Market market;
                private int[] produce;
                private int number_of_produce;
                private String Name;
                public Producer(Market market,String Name) {
                        this.Name=Name;
                        produce=new int[TYPES_OF_FRUITS];
                        this.market = market;
                        int maxsum=ThreadLocalRandom.current().nextInt(1,TYPES_OF_FRUITS+1);
                        number_of_produce=maxsum;
                        int t;
                        for(int i=0;i<TYPES_OF_FRUITS-1 && maxsum>0;i++)
                        {
                            t=ThreadLocalRandom.current().nextInt(1,maxsum+1);
                            maxsum-=t;
                            produce[i]=t;
                        }   
                            produce[TYPES_OF_FRUITS-1]=maxsum;        
                }
 
                @Override
                public void run() {
                     //               {
                                        market.canIsell(number_of_produce,Name);
                                        market.produce(produce,Name);
                         //           }

                                    //    System.out.println(fruittype[t-1]+" produced");
                                
                }
        }
        public static class Consumer implements Runnable {
                private Market market;
                private int[] consume;
                private int number_of_consume;
                private String Name;
                public Consumer(Market market,String Name) {
                        this.Name=Name;
                        consume=new int[TYPES_OF_FRUITS];
                        this.market = market;
                        int maxsum=ThreadLocalRandom.current().nextInt(1,TYPES_OF_FRUITS+1);
                        number_of_consume=maxsum;
                        int t;
                        for(int i=0;i<TYPES_OF_FRUITS-1&&maxsum>0;i++)
                        {
                            t=ThreadLocalRandom.current().nextInt(1,maxsum+1);
                            maxsum-=t;
                            consume[i]=t;
                        }   
                            consume[TYPES_OF_FRUITS-1]=maxsum;        
                
                }
 
                @Override
                public void run() {
                                market.isavailable(consume,Name);
                                market.consume(consume,Name);
                                 /*       Fruit next;
                                        try {
                                                next = queue.take();
                                                System.out.println(fruittype[next.getType()-1]+" Consumed\n");
                                        } catch (InterruptedException e) {
                                        }
                                }*/
                        
                }
        }
 
        public static void main(String args[]) throws Exception {
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
