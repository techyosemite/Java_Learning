package careercup;

/*
 * Following is the link for Fibonacci Series Questions
 * http://commoninterview.com/Programming_Interview_Questions/fibonacci-numbers-interview-questions-1/
 */
public class FibonacciSeries {

	/*
	 * Find the nTh term in the fibonacci series. n is passed as a parameter.
	 */

	public static int nthNumberInFiboacciSeriesUsingrecursion(int n)
			throws Exception {

		if (n < 0)
			throw new Exception("Input parameter invalid");

		int num;

		if (n == 0)
			num = 0;
		else if (n == 1 || n == 2)
			return num = 1;
		else
			num = generateFibonacciSeriesUsingRecursion(n - 1)
					+ generateFibonacciSeriesUsingRecursion(n - 2);

		return num;

	}

	public static int generateFibonacciSeriesUsingRecursion(int n) {

		if (n <= 2)
			return 1;

		return generateFibonacciSeriesUsingRecursion(n - 1)
				+ generateFibonacciSeriesUsingRecursion(n - 2);
	}

	/*
	 * Nth number in the fibonnaci series without storing the numbers.
	 */
	public static void fibonacciSeries(int n) {

		int a = 0;
		int b = 1;

		int i = 0;
		int sum = 0;
		System.out.println(a);
		System.out.println(b);
		while (i != n - 2) {
			sum = a + b;
			System.out.println(sum);

			a = b;
			b = sum;
			i++;
		}
		System.out.println("Sum is ::" + sum);
	}

	// Iteration logic to get the nth term in the fibonacci series
	public static int nThTermInFibonacciSeriesUsingIteration(int n) {

		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int a, b;
		a = b = 1;
		int sum = 0;
		for (int i = 3; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;
	}

	public static double getNthNumberInFibonacciSeries(int n) {

		double sqrt = Math.sqrt(5);

		return Math.round((sqrt / 5) * Math.pow(((1 + sqrt) / 2), (double) n));
	}

	// It consumes extra memory
	public static void fibonacciSeriesUsingArrays(int n) {
		int[] arr = new int[n + 1];

		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		for (int i = 0; i <= n; i++) {
			System.out.println(arr[i]);
		}

	}

	// By Alfred Posamentier and Ingmar Lehmann
	public static boolean isNumberInFibonacci(int w) {
		double X1 = 5 * Math.pow(w, 2) + 4;
		double X2 = 5 * Math.pow(w, 2) - 4;
		long X1_sqrt = (long) Math.sqrt(X1);
		long X2_sqrt = (long) Math.sqrt(X2);
		return (X1_sqrt * X1_sqrt == X1) || (X2_sqrt * X2_sqrt == X2) ? true
				: false;
	}

	public static void generateFibonacciSeries() {

		long a = 0;
		long b = 1;
		long sum = 0;
		System.out.println(a + "," + b);
		while (true) {
			sum = a + b;
			a = b;
			b = sum;
			System.out.println(sum);
		}
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(" 5 number in fbonnaci sequence ::"
		// + nthNumberInFiboacciSeriesUsingrecursion(4));
		// System.out.println("using formula ::"
		// + getNthNumberInFibonacciSeries(4));
		// System.out.println("Using Iteration :: "
		// + nThTermInFibonacciSeriesUsingIteration(4));
		// StringBuffer strBuf = new StringBuffer();
		// strBuf.append(30);
		// InputStreamReader inputStreamReader = new
		// InputStreamReader(System.in);
		// BufferedReader in = new BufferedReader(inputStreamReader);
		// System.out.println("Please enter the number to generate the Fibonnacci series");
		// generateFibonacciSeries(new Integer(in.readLine()));
		// System.out.println(generateFibonacciSeriesUsingRecursion(5));
		// fibonacciSeries(5);
		// System.out.println(nThTermInFibonacciSeriesUsingIteration(10));
		// System.out.println((int) getNthNumberInFibonacciSeries(10));
		// System.out.println("55 is in Fibonacci Series :: "
		// + isNumberInFibonacci(55));
		 fibonacciSeriesUsingArrays(5);
//		generateFibonacciSeries();
	}

}
