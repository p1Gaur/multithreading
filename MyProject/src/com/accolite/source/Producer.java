package com.accolite.source;

import com.accolite.util.FruitConstant;
import com.accolite.util.FruitRandomUtil;

public class Producer implements Runnable {
        private Market market;
        private int[] produce;
        private int number_of_produce;
        private String Name;
        public Producer(Market market,String Name) {
                this.Name=Name;
                produce=new int[FruitConstant.TYPES_OF_FRUITS];
                this.market = market;
                number_of_produce=FruitRandomUtil.getFruits(produce);
        }

        @Override
        public void run() {
                                market.canIsell(number_of_produce,Name);
                                market.produce(produce,Name);                        
        }
}
