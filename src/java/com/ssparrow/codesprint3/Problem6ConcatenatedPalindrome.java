/**
 * 
 */
package com.ssparrow.codesprint3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author Gao, Fei
 *
 */
public class Problem6ConcatenatedPalindrome {
	public static void main(String args[] ) throws Exception{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		String maxPalindrome=getLongestConcatenatedPalindrome(reader);
	
		System.out.println(maxPalindrome.length());
	}
	
	public static String getLongestConcatenatedPalindrome(BufferedReader reader) throws IOException{
		int k;
		int m;
		String [] strings;
		
		String line=reader.readLine();
		if(line!=null){
			StringTokenizer st = new StringTokenizer(line);
			k=Integer.parseInt(st.nextToken());
			strings=new String [k];
			m=Integer.parseInt(st.nextToken());
		}else{
			return null;
		} 
		
		int row=0;
		while((line=reader.readLine())!=null && row<k){
			strings[row++]=line;
		}
		
		String maxPalindrome="";
		for(int i=0;i<k;i++){
			for(int j=1;j<m;j++){
				String left1=strings[i].substring(0,j);
				String right1=strings[i].substring(j);
				
				for(int x=i+1;x<k;x++){
					for(int y=1;y<m;y++){
						String left2=strings[x].substring(0,y);
						String right2=strings[x].substring(y);
						
						String concat1=left1+right2;
						if(concat1.length()>maxPalindrome.length() && isPalindrome(concat1)){
							maxPalindrome=concat1;
						}
						
						String concat2=left2+right1;
						if(concat2.length()>maxPalindrome.length() && isPalindrome(concat2)){
							maxPalindrome=concat2;
						}
					}
				}
			}
		}
		
		System.out.println(maxPalindrome.length());
		
		return maxPalindrome;
	}
	
	
	private static boolean isPalindrome(String str){
		int start=0;
		int end=str.length()-1;
		
		while(start<end){
			if(str.charAt(start)!=str.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
}
