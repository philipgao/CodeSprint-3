/**
 * 
 */
package com.ssparrow.codesprint3;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

/**
 * @author Gao, Fei
 *
 */
public class Problem7RandomNumberGeneratorTest {

	@Test
	public void testGetProbablity() throws IOException {
		
		List<String> result = Problem7RandomNumberGenerator.getProbablity("test/randomnumbergenerator/input");
		assertEquals("1/2", result.get(0));
		assertEquals("1/1", result.get(1));
		assertEquals("1/1", result.get(2));
		assertEquals("2/3", result.get(3));
	}

}
