
public class Fibonacci1 {
	
	// Fibonacci Series using recursion
	public static int fibonacciRec(int number) {
		
		if (number == 1 || number == 2) {
			return 1;
		}
		return fibonacciRec(number - 1) + fibonacciRec(number - 2); // tail recursion
	}
	
	// Using loop
	public static int fibonacciLoop(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		int fibo1 = 1, fibo2 = 1, fibonacci = 1;
		for (int i = 3; i <= number; i++) {
			fibonacci = fibo1 + fibo2; // Fibonacci number is sum of previous two Fibonacci number
			fibo1 = fibo2;
			fibo2 = fibonacci;
 
		}
		return fibonacci; // Fibonacci number
	}
}
