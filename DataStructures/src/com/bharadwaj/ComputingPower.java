package com.bharadwaj;

public class ComputingPower {
	
	public static void main(String args[]) {
		System.out.println(power(20,5));
		System.out.println(power2(20,4));
	}
	
	//Computing power with O(n) complexity
	public static double power(double x, int n) {
		if(n==0) {
			return 1;
		}
		else {
			return x*power(x, n-1);
		}
	}
	
	//Computing power with a better complexity than O(n) and it is O(log n)
	public static double power2(double x, int n) {
		if(n==0) {
			return 1;
		}
		double partial = power2(x, n/2);
		double result = partial * partial;
		if(n%2==1) {
			return result*x;
		}
		else {
			return result;
		}
	}
}
