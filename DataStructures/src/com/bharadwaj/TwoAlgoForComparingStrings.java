package com.bharadwaj;

public class TwoAlgoForComparingStrings {

	public static String repeat1(char c, int n) {
		String answer = "";
		for(int i=0; i<n; i++) {
			answer+=c;
		}
		return answer;
	}
	
	public static String repeat2(char c, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		repeat2('*', 50000);
		long endTime = System.currentTimeMillis();
		long elapsed = endTime-startTime;
		System.out.println(elapsed);
	}
}	
