package com.accolite.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.accolite.util.FruitConstant;
import com.accolite.util.FruitRandomUtil;

public class UtilTest {
@Test
public void RandomUtilTest()
{
	int[] fruitArr=new int[FruitConstant.TYPES_OF_FRUITS];
	int returnValue=FruitRandomUtil.getFruits(fruitArr);
	int sum_of_fruits=0;
	for(int i=0;i<FruitConstant.TYPES_OF_FRUITS;i++)
		sum_of_fruits+=fruitArr[i];
	assertEquals(sum_of_fruits, returnValue);
}

}
