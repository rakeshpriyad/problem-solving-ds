package raj.aayush.program.recursion;

public class GCDDemo {

	public static void main(String[] args) {
		int res = GCD(50,4);
		System.out.println(res);
		int res1 = GCD(80,7);
		System.out.println(res1);
	}
	public static int GCD(int m, int n) {
		if(m<n) {
			return GCD(n,m);
		}
		
		if(m%n==0) {
			return n;
		}
		
		return GCD(m%n, n);
	}
}
