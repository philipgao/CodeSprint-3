/**
 * 
 */
package com.ssparrow.codesprint3;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * @author Gao, Fei
 *
 */
public class Problem6ConcatenatedPalindromeTest {

	@Test
	public void testGetLongestConcatenatedPalindrome() throws IOException {
		BufferedReader reader=new BufferedReader(new FileReader("test/concatenatedpalindrome/input1"));
		
		assertEquals("abbbba", Problem6ConcatenatedPalindrome.getLongestConcatenatedPalindrome(reader));
		
		reader=new BufferedReader(new FileReader("test/concatenatedpalindrome/input2"));
		
		assertEquals("1laduB84wsu8YkELyZzMOBzz7Qm5wbLp1I4bDoccoDb4I1pLbw5mQ7zzBOMzZyLEkY8usw48Budal1", Problem6ConcatenatedPalindrome.getLongestConcatenatedPalindrome(reader));
	}

}
