package raj.aayush.program.recursion;

public class RotateArray {
	public static void main(String[] args) {
		int arr[] = { 5, 8, 9, 11, 30, 15 };
		rotateArray(arr,arr.length,3);
		//System.out.println(arr);
		printArray(arr);
		
	}
	
	public static void printArray(int arr[]){
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void rotateArray(int[] a, int n, int k) {
		reverseArray(a, 0, k - 1);
		reverseArray(a, k, n - 1);
		reverseArray(a, 0, n - 1);
	}

	public static void reverseArray(int[] a, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

}
