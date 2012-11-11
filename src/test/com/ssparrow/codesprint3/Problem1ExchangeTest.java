/**
 * 
 */
package com.ssparrow.codesprint3;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

/**
 * @author Gao, Fei
 *
 */
public class Problem1ExchangeTest {

	@Test
	public void testGetSmallestPossiblePermutationByExchange() throws IOException {
		assertArrayEquals(new int []{2,1,3}, Problem1Exchange.getSmallestPossiblePermutationByExchange("test/exchange/input1"));
		

		assertArrayEquals(new int []{1,2,3}, Problem1Exchange.getSmallestPossiblePermutationByExchange("test/exchange/input2"));
	}

}
