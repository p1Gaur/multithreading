package com.accolite.source;

import com.accolite.util.FruitRandomUtil;
import com.accolite.util.FruitConstant;

public class Consumer implements Runnable {
    private Market market;
    private int[] consume;
    //private int number_of_consume;
    private String Name;
    public Consumer(Market market,String Name) {
                    this.Name=Name;
                    this.market = market;
                    consume=new int[FruitConstant.TYPES_OF_FRUITS];            
                    FruitRandomUtil.getFruits(consume);
                  //  System.out.println(Name+consume[0]+consume[1]+consume[2]);
    }
    @Override
    public void run() {
                    market.isavailable(consume,Name);
                    market.consume(consume,Name);        
    }
    public int[] getConsume() {
		return consume;
	}
	public void setConsume(int[] consume) {
		this.consume = consume;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
