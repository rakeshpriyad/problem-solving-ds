package raj.aayush.program.searching;

import java.util.Arrays;
import java.util.HashSet;

public class DuplicateInArray {

	public static void main(String[] args) {
		int arr[] = { 5, 1, 4, 5, 3, 3, 1 };
		printRepeatingBruteForce(arr, arr.length);

		printRepeating2(arr, arr.length);
		printRepeating3(arr,arr.length);
		
		printRepeating4(arr,arr.length);

	}

	public static void printRepeatingBruteForce(int[] arr, int size) {
		int i, j;
		System.out.println(" Repeating elements are ");
		for (i = 0; i < size; i++) {
			for (j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					System.out.println(" " + arr[i]);
				}
			}
		}
	}

	/**
	 * Sorting algorithms take time and single scan take time. The Time Complexity
	 * of an algorithm is and Space Complexity is O(1)
	 * 
	 * @param arr
	 * @param size
	 */
	public static void printRepeating2(int[] arr, int size) {
		int i;
		Arrays.sort(arr); // Sort(arr,size);
		System.out.println(" Repeating elements are ");
		for (i = 1; i < size; i++) {
			if (arr[i] == arr[i - 1])
				System.out.println(" " + arr[i]);
		}
	}

	public static void printRepeating3(int[] arr, int size) {
		HashSet<Integer> hs = new HashSet<Integer>();
		int i;
		System.out.println(" Repeating elements are ");
		for (i = 0; i < size; i++) {
			if (hs.contains(arr[i]))
				System.out.println(" " + arr[i]);
			else
				hs.add(arr[i]);
		}
	}

	/**
	 * Forth approach: Counting, this approach is only possible if we know the range of the input. If we
know that, the elements in the array are in the range 0 to n-1. We can reserve and array of length n
and when we see an element we can increase its count. In just one single scan, we know the
duplicates. If we know the range of the elements, then this is the fastest way to find the duplicates.
	 * @param arr
	 * @param size
	 */
	public static void printRepeating4(int[] arr, int size) {
		int[] count = new int[size];
		int i;
		for (i = 0; i < size; i++) {
			count[i] = 0;
		}
		System.out.println(" Repeating elements are ");
		for (i = 0; i < size; i++) {
			if (count[arr[i]] == 1)
				System.out.println(" " + arr[i]);
			else
				count[arr[i]]++;
		}
	}
}
