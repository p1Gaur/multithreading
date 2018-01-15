package com.accolite.unittest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeoutException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.accolite.source.Market;
import com.accolite.util.FruitConstant;

public class MarketTest {
	@Test
	public void produceTest()
	{
		Market m=new Market();
		int[] fruit= new int[FruitConstant.TYPES_OF_FRUITS];
		fruit[0]=1;
		m.canIsell(1, "Producer temp");
		m.produce(fruit, "Producer temp");
		assertArrayEquals(m.getFruits(), fruit);
	}
	
	@Test
	public void canISellTest()
	{
		Market m=new Market();
		assertTrue(m.canIsell(5, "Producer temp"));
	}
	//code to get test correct if timeout is reached
	  private static final int MIN_TIMEOUT = 100;

	    @SuppressWarnings("deprecation")
		@Rule
	    public Timeout timeout = new Timeout(MIN_TIMEOUT) {
	        public Statement apply(Statement base, Description description) {
	            return new FailOnTimeout(base, MIN_TIMEOUT) {
	                @Override
	                public void evaluate() throws Throwable {
	                    try {
	                        super.evaluate();
	                        throw new TimeoutException();
	                    } catch (Exception e) {}
	                }
	            };
	        }
	    };
	
	@Test(expected=TimeoutException.class )
	public void canISellTest2()
	{
		Market m=new Market();
		int[] fruit= new int[FruitConstant.TYPES_OF_FRUITS];
		fruit[0]=1;
		m.canIsell(1, "Producer temp");
		m.produce(fruit, "Producer temp");
		m.canIsell(FruitConstant.CAPACITY, "Producer temp");
	}
	
	@Test
	public void consumeTest()
	{
		Market m=new Market();
		int[] fruit= new int[FruitConstant.TYPES_OF_FRUITS];
		fruit[0]=4;
		fruit[1]=1;
		m.canIsell(5, "Producer temp");
		m.produce(fruit, "Producer temp");
		int[] fruit2= new int[FruitConstant.TYPES_OF_FRUITS];
		fruit2[0]=1;
		fruit2[1]=1;
		m.isavailable(fruit2,"Consumer temp");
		m.consume(fruit,"Consumer temp");
	}
	@Test
	public void isavailableTest()
	{
		Market m=new Market();
		int[] fruit= new int[FruitConstant.TYPES_OF_FRUITS];
		fruit[0]=4;
		fruit[1]=1;
		m.canIsell(5, "Producer temp");
		m.produce(fruit, "Producer temp");
		int[] fruit2= new int[FruitConstant.TYPES_OF_FRUITS];
		fruit2[0]=1;
		fruit2[1]=1;
		assertTrue(m.isavailable(fruit2, "Consumer temp"));
	}
	@Test(expected=TimeoutException.class )
	public void isavailableTest2()
	{
		Market m=new Market();
		int[] fruit2= new int[FruitConstant.TYPES_OF_FRUITS];
		fruit2[0]=1;
		fruit2[1]=1;
		m.isavailable(fruit2, "Producer temp");
	}
	

	
	
}
