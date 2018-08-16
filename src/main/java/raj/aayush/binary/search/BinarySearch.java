package raj.aayush.binary.search;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 5, 8, 9, 11, 30, 15 };
		int x = binarySearch(arr, arr.length, 30);
		System.out.println(x);
	}

	// Binary Search Algorithm – Iterative Way
	public static int binarySearch(int arr[], int size, int value) {
		int mid;
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			mid = low + (high - low) / 2; // To avoid the overflow
			if (arr[mid] == value) {
				return mid;
			} else if (arr[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
