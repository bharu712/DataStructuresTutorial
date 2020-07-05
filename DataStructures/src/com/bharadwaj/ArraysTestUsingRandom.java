package com.bharadwaj;

import java.util.Arrays;
import java.util.Random;

public class ArraysTestUsingRandom {

	public static void main(String args[]) { 
		int[] data = new int[100];
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis()); //use the current time as a seed
		
		for(int i=0; i<data.length; i++) {
			data[i] = rand.nextInt(100);
		}
		
		int[] orig = Arrays.copyOf(data, data.length);
		System.out.println("Arrays equality before sort : "+ Arrays.equals(data, orig));
		System.out.println(Arrays.toString(data));
		System.out.println(Arrays.toString(orig));
		Arrays.sort(data);
		System.out.println("Arrays equality before sort : "+ Arrays.equals(data, orig));
		System.out.println(Arrays.toString(data));
		System.out.println(Arrays.toString(orig));
		
	}
}
