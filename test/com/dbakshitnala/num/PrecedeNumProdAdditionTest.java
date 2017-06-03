package com.dbakshitnala.num;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;


/**
 * Test class for PrecedeNumProdAddition
 * @author DurgaAkshintala
 *
 */
public class PrecedeNumProdAdditionTest {
	
	PrecedeNumProdAddition precNumProdAdd = new PrecedeNumProdAddition();
	
	/**
	 * Test case for given number range and preceding numbers (Ex: 5 number with 2 preceding numbers)
	 * Returns "21" (0+1+2+6+12) as result.
	 */
	@Test
	public void testCaseOne(){
		
		BigInteger numRange = new BigInteger("5");
		BigInteger precNums = new BigInteger("2");
		BigInteger result = precNumProdAdd.getSum(numRange, precNums);
		displayResult(numRange, precNums, result);
		
		Assert.assertEquals(new BigInteger("21"), result);
	}
	
	/**
	 * Test case for one number (Ex: 1)
	 * Retuns "0" as result.	
	 */
	@Test
	public void numRangeOnePrecTwo_ReturnZero(){
		
		BigInteger numRange = BigInteger.ONE;
		BigInteger precNums = new BigInteger("2");
		BigInteger result = precNumProdAdd.getSum(numRange, precNums);
		
		displayResult(numRange, precNums, result);
		
		Assert.assertEquals(BigInteger.ZERO, result);
	}
	
	/**
	 * Test case for two numbers (Ex: 1,2)
	 * Retuns "1" as result.	
	 */
	@Test
	public void numRangeTwoPrecTwo_ReturnOne(){
		
		BigInteger numRange = new BigInteger("2");
		BigInteger precNums = new BigInteger("2");
		BigInteger result = precNumProdAdd.getSum(numRange, precNums);
		
		displayResult(numRange, precNums, result);
		
		Assert.assertEquals(BigInteger.ONE, result);
	}
	/**
	 * Test case for 10 numbers with 3 Preceding numbers
	 * Retuns "1263" as result.	
	 */
	@Test
	public void numRange10Prec3_Return1263(){
		
		BigInteger numRange = BigInteger.TEN;
		BigInteger precNums = new BigInteger("3");
		BigInteger result = precNumProdAdd.getSum(numRange, precNums);
		
		displayResult(numRange, precNums,result);
		
		Assert.assertEquals(new BigInteger("1263"), result);
	}
	
	/**
	 * Test case for number range 100 with 10 preceding numbers.
	 * returns "513946235090696089113" as result
	 */
	@Test
	public void numRange100Prec10_returnResult(){
		
		BigInteger numRange = new BigInteger("100");
		BigInteger precNums = new BigInteger("10");
		BigInteger result = precNumProdAdd.getSum(numRange, precNums);
		
		displayResult(numRange, precNums,result);
		
		Assert.assertEquals(new BigInteger("513946235090696089113"), result);
	}
	/**
	 * Test case of number range 1000000 with 200 preceding numbers.
	 * returns "4876116127" as result for first 10 digits.
	 */
	@Test
	public void numberRangeBig_returnFirst10Digits(){
		
		BigInteger numRange = new BigInteger("1000000");
		BigInteger precNums = new BigInteger("200");
		BigInteger result = precNumProdAdd.getSum(numRange, precNums);
		
		System.out.print("First ten digits only: ");
		String substring = result.toString().substring(0, 10);
		
		System.out.println(String.format("Result for N=%s C=%s = %s", 
				numRange.toString(),precNums.toString(),substring));
		
		Assert.assertEquals("4876116127", substring);
		//Assert.assertTrue("4876116127".equals(substring));
	}
	/**
	 * 
	 * @param numRange
	 * @param precNums
	 * @param result
	 */
	private void displayResult(BigInteger numRange, BigInteger precNums,BigInteger result) {
		System.out.println(String.format("Result for N=%s C=%s  is  %s", 
						numRange.toString(),precNums.toString(),result.toString()));
	}

}
