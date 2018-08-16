package raj.aayush.program.recursion;

public class BinarySearchRecursive {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 30, 50, 80 };
		int value = 30;
		int x = binarySearchRecursive(arr, 0, arr.length, value);
		System.out.println(value + " is found at index : " + x);

	}

	public static int binarySearchRecursive(int arr[], int low, int high, int value) {
		int mid = low + (high - low) / 2; // To avoid the overflow
		if (arr[mid] == value)
			return mid;
		else if (arr[mid] < value) {
			return binarySearchRecursive(arr, mid + 1, high, value);
		} else {
			return binarySearchRecursive(arr, low, mid - 1, value);
		}
	}

}
