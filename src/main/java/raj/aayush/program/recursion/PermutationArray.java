package raj.aayush.program.recursion;

public class PermutationArray {

	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = i;
		}
		permutation(arr, 0, 5);
	}

	public static void printArray(int[] arr, int count) {
		System.out.print("\n array : ");
		for (int i = 0; i < count; i++) {
			System.out.print(" " + arr[i]);
		}
	}

	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return;
	}

	public static void permutation(int[] arr, int i, int length) {
		if (length == i) {
			//printArray(arr, length);
			return;
		}
		int j = i;
		for (j = i; j < length; j++) {
			swap(arr, i, j);
			//System.out.println("\n after swap i="+i +" j=" + j);
			//printArray(arr, length);
			permutation(arr, i + 1, length);
			//System.out.println("\n after permutation i="+i +" j=" + j);
		//	printArray(arr, length);
			swap(arr, i, j);
			System.out.println("\n after permutation swap i="+i +" j=" + j);
			printArray(arr, length);
		}
		return;
	}

}
