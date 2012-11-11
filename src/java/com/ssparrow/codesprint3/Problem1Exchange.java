/**
 * 
 */
package com.ssparrow.codesprint3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
	A permutation is a list of  K numbers, each between 1 and K (both inclusive), that has no duplicate elements.
	
	Permutation X is lexicographically smaller than Permutation Y iff for some i <= K:
	
	All of the first i-1 elements of X are equal to first i-1 elements of Y.
	ith element of X is smaller than ith element of Y.
	You are given a permutation P, you can exchange some of its elements as many times as you want in any order. You have to find the lexicographically smallest Permutation that you can obtain from P.
	
	K is less than 101.
	
	Input Format:
	
	First line of input contains K being the size of permutation.
	Next line contains K single spaced numbers indicating the permutation.
	Each of next K lines contains K characters, character j of line i is equal to 'Y' if you can exchange ith and jth element of a permutation, and 'N' otherwise.
	
	Output Format:
	
	Print K numbers with a space separating each of them indicating the permutation.
	
	Sample Input
	
	3
	3 1 2
	NNY
	NNN
	YNN
	
	Sample Output
	
	2 1 3
	
	Sample Input 
	
	3
	3 2 1
	NYN
	YNY
	NYN
	
	Sample Output
	
	1 2 3 
	
	In the first example you can exchange first element with last element to obtain 2 1 3 from 3 1 2.
	
	
	In the second example, first can be exchanged with second. So, from 3 2 1 , we can get 2 3 1. 2 3 1 is
	lexicographically smaller than 3 2 1. Matrix also says the second the third element can be swapped.
	From this we get, 2 1 3. 2 1 3 is lexicographically smaller than 2 3 1. As the matrix says the first and the
	second element can be swapped, we get 1 2 3 from 2 1 3 and hence the answer 1 2 3.
 * @author Gao, Fei
 *
 */
public class Problem1Exchange {

	public static int [] getSmallestPossiblePermutationByExchange(String fileName) throws IOException{
		BufferedReader reader=new BufferedReader(new FileReader(fileName));
		
		int k;
		int [] initialPermutation;
		boolean [][] exchange;
		
		String line=reader.readLine();
		if(line!=null){
			k=Integer.parseInt(line);
			initialPermutation=new int [k];
			exchange=new boolean [k][k];
		}else{
			return null;
		} 
		
		line=reader.readLine();
		if(line!=null){
			StringTokenizer st=new StringTokenizer(line," ");
			
			int index=0;
			while(st.hasMoreTokens()){
				initialPermutation[index++]=Integer.parseInt(st.nextToken());
			}
		}
		
		int row=0;
		while((line=reader.readLine())!=null && row<k){
			for(int column=0;column<k;column++){
				exchange[row][column]=line.charAt(column)=='Y'?true:false;
			}
			row++;
		}
		
		int [] permutation=Arrays.copyOf(initialPermutation, k);
		
		while(true){
			boolean exchanged=false;
			
			for(int currentIndex=0;currentIndex<k;currentIndex++){
				boolean [] possibleExchanges=exchange[currentIndex];
				
				for(int i=0;i<k;i++){
					if(possibleExchanges[i]
						&&((i<currentIndex && permutation[i]>permutation[currentIndex])||
									(i>currentIndex && permutation[i]<permutation[currentIndex]))){
						exchanged=true;
							
						int temp=permutation[currentIndex];
						permutation[currentIndex]=permutation[i];
						permutation[i]=temp;
						
						currentIndex=i;
						break;
					}
				}
			}
			
			if(!exchanged){
				break;
			}
		}
		
		StringBuffer result=new StringBuffer();
		for(int i=0;i<k;i++){
			result.append(permutation[i]);
			if(i<k-1){
				result.append(" ");
			}
		}
		System.out.println(result.toString());
		
		return permutation;
	}
	
	
	/**
	 * @param k
	 * @param initialPermutation
	 * @param exchange
	 * @param minIndex
	 * @return
	 */
	private static int[] getMinimumPermutation1(int k, int[] initialPermutation,boolean[][] exchange) {

		
		int minIndex=0;
		for(int i=1;i<k;i++){
			if(initialPermutation[i]<initialPermutation[minIndex]){
				minIndex=i;
			}
		}
		
		int [] permutation=Arrays.copyOf(initialPermutation, k);
		boolean [] moved =new boolean [k];
		int currentIndex=minIndex;
		while(true){
			boolean [] possibleExchanges=exchange[currentIndex];
			
			boolean found=false;
			boolean canMove=false;
			for(int i=0;i<k;i++){
				if(possibleExchanges[i]){ 
					canMove=true;
					
					if(((i<currentIndex && permutation[i]>permutation[currentIndex])||
								(i>currentIndex && permutation[i]<permutation[currentIndex]))){
						found=true;
						
						int temp=permutation[currentIndex];
						permutation[currentIndex]=permutation[i];
						permutation[i]=temp;
						
						moved[currentIndex]=true;
						currentIndex=i;
						break;
					}
				}
			}
			
			if(!canMove){
				moved[currentIndex]=true;
				
				for(int i=0;i<k;i++){
					if(!moved[i]){
						currentIndex=i;
					}
				}
				
				continue;
			}
			
			if(!found){
				break;
			}
		}
		return permutation;
	}
	
}
