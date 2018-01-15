package com.accolite.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.accolite.source.Consumer;
import com.accolite.source.Market;

public class ConsumerTest {
	@Test
	public void constructorTest()
	{
		Market m=Mockito.mock(Market.class);
		Consumer c=new Consumer(m,"Test Producer");
		assertEquals("Test Producer",c.getName());
		
	}

}
