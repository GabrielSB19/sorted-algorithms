package SortingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortingAlgorithms {
	
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = "";
		
		String amountLineString = br.readLine();
		int amountLine = Integer.parseInt(amountLineString);
		String [] childAgeString = new String [amountLine];
		
		for(int i = 0; i<childAgeString.length; i++) {
			line = br.readLine();
			childAgeString[i] = line;
		}
		
		for(int i = 0; i<childAgeString.length; i++) {
			if(i != childAgeString.length-1) {
				bw.write(bubbleSort(stringToDouble(childAgeString[i]))+"\n");
			} else {
				bw.write(bubbleSort(stringToDouble(childAgeString[i])));
			}
			
			
		}

		br.close();
		bw.close();
	}
	
	public static double [] stringToDouble(String line) {
		String [] parts = line.split("\\ ");
		double [] nums = new double [parts.length];
		for(int i = 0; i<parts.length; i++) {
			nums[i] = Double.parseDouble(parts[i]);
		}
		return nums;
	}
	
	public static String bubbleSort(double [] nums) {
		String test = "";
		double count = 0;
		boolean out = true;
		boolean out2 = false;
		for(int i = 1; i<nums.length && out; i++) {
			out = false;
			for(int j = 0; j<nums.length-1; j++) {
				if(nums[j]>nums[j+1]) {
					count++;
					double aux = nums[j];
					nums[j] = nums[j+1]; 
					nums[j+1] = aux;
					out = true;
				}
			}
		}
		for(int i = 0; i<nums.length; i++) {
			if(out2) {
				test += " ";
			}
			test += nums[i];
			out2 = true;
		}
		double average = 0;
		if(nums.length == 1) {
			 average = count;
		} else {
			 average = count/(nums.length-1);
		}
		double averagefinal = Math.floor(average*100)/100;
		return averagefinal+"-"+test;
	}
}


