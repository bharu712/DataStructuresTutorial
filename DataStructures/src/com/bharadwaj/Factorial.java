package com.bharadwaj;

public class Factorial {

	public static void main(String args[]) {
		System.out.println(nonrecursiveFactorial(-1));
	}
	
	public static int recursiveFactorial(int n) {
		if(n<0) {
			throw new IllegalArgumentException("Inavlid Input :" +n);
		}
		else if(n==0) {
			return 1;
		}
		else {
			return n*recursiveFactorial(n-1);
		}
	}
	
	public static int nonrecursiveFactorial(int n) {
		int fact = 1; 
		if(n<0) {
			throw new IllegalArgumentException("Inavlid Input :" +n);
		}
		else if(n==0) {
			return fact;
		}
		else {
			for(int i=n; i>0; i--) {
				fact *= i;
			}
			return fact;
		}
	}
}
