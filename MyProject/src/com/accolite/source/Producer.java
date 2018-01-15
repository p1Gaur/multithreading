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
        
        public int[] getProduce() {
			return produce;
		}
		public void setProduce(int[] produce) {
			this.produce = produce;
		}
		public int getNumber_of_produce() {
			return number_of_produce;
		}
		public void setNumber_of_produce(int number_of_produce) {
			this.number_of_produce = number_of_produce;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		
        @Override
        public void run() {
                                market.canIsell(number_of_produce,Name);
                                market.produce(produce,Name);                        
        }
}
