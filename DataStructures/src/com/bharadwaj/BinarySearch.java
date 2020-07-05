package com.bharadwaj;

public class BinarySearch {
	
	public static void main(String args[]) {
		int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		System.out.println(binarySearch(input, 1 , 0, input.length-1));
	}

	public static boolean binarySearch(int[] data, int target, int low, int high) {
		if(low>high) {
			return false;
		}
		else {
			int mid = (low+high)/2;
			if(target == data[mid]) {
				return true;
			}
			else if (target < data[mid]) {
				return binarySearch(data, target, low, mid-1);
			}
			else {
				return binarySearch(data, target, mid+1, high);
			}
		}
	}
}
