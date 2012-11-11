/**
 * 
 */
package com.ssparrow.codesprint3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Gao, Fei
 *
 */
public class Problem7RandomNumberGenerator {
	public static List<String> getProbablity(String fileName) throws IOException{
		BufferedReader reader=new BufferedReader(new FileReader(fileName));
		
		int k;
		int [][] problems;
		
		String line=reader.readLine();
		if(line!=null){
			k=Integer.parseInt(line);
			problems=new int [k][3];
		}else{
			return null;
		} 
		
		int row=0;
		while((line=reader.readLine())!=null && row<k){
			int column=0;
			StringTokenizer st=new StringTokenizer(line," ");
			while(st.hasMoreTokens() && column<3){
				problems[row][column]=Integer.parseInt(st.nextToken());
				column++;
			}
			row++;
		}
		
		List<String> result=new ArrayList<String>();
		for(int i=0;i<k;i++){
			result.add(getProbablity(problems[i][0], problems[i][1], problems[i][2]));
		}
		
		 for(String item:result){
             System.out.println(item);
         }
		
		return result;
	}
	
	private static String getProbablity(int a, int b, int c){
		StringBuffer result=new StringBuffer();
		
		int sum=a+b;
		
		if(c<sum){
			int [] primeList=getAllPrimesLessThanOrEqualNumber(c);
			
			for(int i=0;i<primeList.length && primeList[i]<=c;i++){
				while(c% primeList[i]==0 && sum%primeList[i]==0){
					c=c/primeList[i];
					sum=sum/primeList[i];
				}
			}
			
			result.append(c).append("/").append(sum);
		}else{
			result.append("1/1");
		}
		
		return result.toString();
	}
	
	private static int [] getAllPrimesLessThanOrEqualNumber(int number){
		int [] temp=new int [number];
		
		boolean [] flags=new boolean[number+1];
		
		int index=0;
		int prime=2;
		
		temp[index++]=prime;
		
		while(true){
			for(int i=2;i*prime<=number;i++){
				flags[i*prime]=true;
			}
			
			boolean found=false;
			
			for(int i=prime+1;i<=number;i++){
				if(!flags[i]){
					prime=i;
					temp[index++]=prime;
					found=true;
					break;
				}
			}
			
			if(!found){
				break;
			}
		}
		
		int [] result=new int[index];
		System.arraycopy(temp, 0, result, 0, index);
		
		return result;
	}
	
}
