package javabootcamp.basic.arrays;

import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6,7},
				{8}
		};
		
		
		// print 2 dimentional array
		for (int i=0; i < arr.length; i++){
			for (int j=0; j < arr[i].length; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		// print two dimentional array for each
		for (int[] row:arr) {
			for (int element:row) {
				System.out.print(element);
			}
			System.out.println();
		}

		// Deep copy arrays
		int[] originalArr = {5, -1, -2, 4, 6, 0};
		int[] arrCopy = new int[originalArr.length];
		
		for (int i=0; i<originalArr.length; i++) {
			arrCopy[i] = originalArr[i]*originalArr[i];
		}
		
		for (int element : originalArr) {
			System.out.print(element + " ");
		}
		System.out.println();
		for (int element : arrCopy) {
			System.out.print(element + " ");
		}
	}
}
