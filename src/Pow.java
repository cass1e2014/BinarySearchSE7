/**
 * Implement pow(x, n).
 * 
 * @author cassie9082
 * 
 */

/*
 * Recursion做法 pow(x,n)就是求x的n次方。x的N次方可以看做：x^n =
 * x^(n/2)*x^(n/2)*x^(n%2)。所以利用递归求解，当n==1的时候，x^n=x。
 * 
 * 当然n是可以小于0的，2^(-3) = 1/(2^3)。按照上面那个规律就可以解决了。
 */
public class Pow {

	public static void main(String[] args) {
		System.out.println(pow(2, 3));
	}

	// recursion
	public static double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}

		double value = pow(x, n / 2);

		if (n % 2 == 0) {
			return value * value;
		} else {
			return value * value * x;
		}
	}

	public static double power(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}

}
