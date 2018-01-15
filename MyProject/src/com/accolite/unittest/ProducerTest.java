package com.accolite.unittest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.accolite.source.Market;
import com.accolite.source.Producer;
import com.accolite.util.FruitConstant;

public class ProducerTest {
@Test
public void constructorTest()
{
	Market m=Mockito.mock(Market.class);
	Producer p=new Producer(m,"Test Producer");
	int sum_of_fruits=0;

	for(int i=0;i<FruitConstant.TYPES_OF_FRUITS;i++)
		sum_of_fruits+=p.getProduce()[i];
	assertEquals(sum_of_fruits,p.getNumber_of_produce());
	assertEquals("Test Producer",p.getName());
	
}
}
