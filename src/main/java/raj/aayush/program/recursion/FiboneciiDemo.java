package raj.aayush.program.recursion;

public class FiboneciiDemo {
	public static void main(String[] args) {
		int n = 10;
		printFibonacciSeries(n);
	}

	public static int fibonacci(int n) {
		if (n <= 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void printFibonacciSeries(int n) {
		for (int i = 0; i <= n; i++) {
			int x = fibonacci(i);
			System.out.println(x);
		}
	}

}
