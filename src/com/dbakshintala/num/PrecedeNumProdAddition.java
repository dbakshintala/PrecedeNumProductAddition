package com.dbakshintala.num;

import java.math.BigInteger;


/**
 * This class calculates the sum of product of all preceding "C" numbers.
 * If there are less than C previous elements, it just uses the available numbers.
 * 
 * Example: if n=5 and C=2, then the result is : 0 + 1 + 2 + 6 + 12 = 21
 * 
 * @author DurgaAkshintala
 *
 */
public class PrecedeNumProdAddition {
	
	
	/**
	 * This method gets the sum of product of all preceding "precNumbers" numbers 
	 * for the range of "range" numbers
	 * @param range
	 * @param precNumbers
	 * @return
	 */
	public BigInteger getSum(BigInteger range, BigInteger precNumbers) {
		BigInteger result = BigInteger.ZERO;
		for (BigInteger i = BigInteger.ZERO; i.compareTo(range) < 0; i=i.add(BigInteger.ONE)) {
			result = result.add(getCalculatedProduct(i, i.subtract(BigInteger.ONE), precNumbers));
		}
		return result;
	}
	
	/**
	 * This method multiplies the preceding numbers and returns the result.
	 * @param ithNumber
	 * @param jthNumber
	 * @param precNums
	 * @return
	 */
	private BigInteger getCalculatedProduct(BigInteger ithNumber, BigInteger jthNumber, BigInteger precNums) {
		//if jthNumber is a -ve number then return 0
		if (jthNumber.compareTo(BigInteger.ZERO) < 0) return BigInteger.ZERO;
		
		//if jthNumber is 0 then return 1
		if (jthNumber.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
		
		//if ithNumber - jthNumber is less than or equal to precNumbers then add the product 
		//of preceding numbers by call the same method recursively till the if condition is true.
		if ((ithNumber.subtract(jthNumber).compareTo(precNums)) <= 0){
			jthNumber = jthNumber.add(BigInteger.ONE).multiply(getCalculatedProduct(ithNumber, jthNumber.subtract(BigInteger.ONE), precNums));
			return jthNumber;
		}else
			return BigInteger.ONE;
	}
	
	/**
	 * Main method to test the functionality
	 * @param args
	 */
	public static void main(String[] args){
		PrecedeNumProdAddition preNumProdAdd = new PrecedeNumProdAddition();
				
		String nrange = "5";
		String precNum = "2";
		
		if (args.length == 0 )
			System.out.println(" Number range and Preceding numbers are missing, "
					+ "so result for NumRange 5 with 2 Preceding numbers is calculated");
		
		if(args.length >0 && !("".equals(args[0]))){
			nrange = args[0];
		}
		if (args.length >1 && !("".equals(args[1]))){
			precNum = args[1];
		}
		
		BigInteger numRange = new BigInteger(nrange);
		BigInteger precNums = new BigInteger(precNum);
		
		BigInteger result = preNumProdAdd.getSum(numRange, precNums);
		System.out.println("result: "+result);
		
	}

}
