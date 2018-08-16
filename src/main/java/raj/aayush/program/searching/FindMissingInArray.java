package raj.aayush.program.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindMissingInArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,7,8,9};
		System.out.println("Missing no: " + findMissingNumber2(arr, arr.length));
	}

	/**
	 * First approach: Exhaustive search or Brute force, for each value in the range
	 * 1 to n, find if there is some element in array which have the same value.
	 * This is done using two for loop, first loop to select value in the range 1 to
	 * n and the second loop to find if this element is in the array or not. The
	 * Time Complexity is O(n2) and Space Complexity is O(1)
	 * 
	 * @param arr
	 * @param size
	 * @return
	 */
	public static int findMissingNumber(int[] arr, int size) {
		int i, j, found = 0;
		for (i = 1; i <= size; i++) {
			found = 0;
			for (j = 0; j < size; j++) {
				//as soon as found break the inner loop and start searching next no
				if (arr[j] == i) {
					found = 1;
					break;
				}
			}
			if (found == 0)
				return i;
		}
		return Integer.MAX_VALUE;
	}
	
	/**Second approach: Sorting, Sort all the elements in the array and after this in a single scan, we can
	find the duplicates.
	**/
	public static int findMissingNumber2(int[] arr, int size) {
		Arrays.sort(arr);
		int j=1;
		for (int i = 0; i <= size && j<=size; i++,j++) {
			if(arr[i] != j) {
				return j;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	/**
	 * Third approach: Hash-Table, using Hash-Table, we can keep track of the elements we have
already seen and we can find the missing element in just one scan.
	 */

	public static int findMissingNumber3(int[] arr, int size) {
		HashMap<Integer, Integer> valMap= new HashMap<Integer, Integer>();
		//HashSet<Integer> valSet = new HashSet<Integer>();
		int j=1;
		for (int i = 0; i <= size; i++) {
			if(valMap.containsKey(arr[i])) {
				valMap.put(arr[i], arr[i]);
			}else {
				valMap.put(arr[i], arr[i]);
			}
		}
		return Integer.MAX_VALUE;
	}
}
