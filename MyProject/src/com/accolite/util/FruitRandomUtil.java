package com.accolite.util;

import java.util.concurrent.ThreadLocalRandom;

public class FruitRandomUtil {
	public static int getFruits(int consume[])
	{
        int maxsum=ThreadLocalRandom.current().nextInt(1,FruitConstant.TYPES_OF_FRUITS+1);
        int number_of_consume=maxsum;
        int t;
        for(int i=0;i<(FruitConstant.TYPES_OF_FRUITS-1)&&maxsum>0;i++)
        {
            t=ThreadLocalRandom.current().nextInt(1,maxsum+1);
            maxsum-=t;
            consume[i]=t;
        }   
            consume[FruitConstant.TYPES_OF_FRUITS-1]=maxsum;        
            return number_of_consume;
	}
	
}
