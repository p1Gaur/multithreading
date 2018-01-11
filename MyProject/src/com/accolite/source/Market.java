package com.accolite.source;

import com.accolite.util.FruitConstant;
public class Market {
    int fruits[];
    int currentNumber;
    Market()
    {
        fruits=new int[FruitConstant.TYPES_OF_FRUITS];
        for(int i=0;i<FruitConstant.TYPES_OF_FRUITS;i++)
            fruits[i]=0;
        currentNumber=0;
    }
    
    synchronized boolean canIsell(int n,String Name)
    {
        try
        {
        while(n+currentNumber>FruitConstant.CAPACITY)
        {
        	System.out.println(Name+" is waiting to Sell.");
            wait();
        }
        }catch(InterruptedException e)  
        {
        	System.out.println(e.getStackTrace());
        }
        return true;
    }
    
    
    synchronized boolean isavailable(int fruit[],String Name)
    {
        try{
        for(int i=0;i<FruitConstant.TYPES_OF_FRUITS;i++)
            if(fruits[i]<fruit[i])
                {
                    System.out.println(Name+" is waiting to Buy.");
                    wait();
                    i=0;
                }
            }catch(InterruptedException e)
            {
            	System.out.println(e.getStackTrace());
            }
            return true;
    }
    
    
    synchronized void produce(int fruit[],String Name)
    {
        for(int i=0;i<FruitConstant.TYPES_OF_FRUITS;i++)
            {
                fruits[i]+=fruit[i];
                currentNumber+=fruit[i];
                System.out.println(Name+" Produced "+fruit[i]+" "+FruitConstant.fruittype[i]);
            }
            notify();
    }
    
    
    
    synchronized void consume(int fruit[],String Name)
    {
        for(int i=0;i<FruitConstant.TYPES_OF_FRUITS;i++)
            {
                fruits[i]-=fruit[i];
                currentNumber-=fruit[i];
                System.out.println(Name+" consumed "+fruit[i]+" "+FruitConstant.fruittype[i]);
            }
            notify();
    }

}
