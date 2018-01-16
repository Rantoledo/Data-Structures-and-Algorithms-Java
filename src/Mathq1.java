
public class Mathq1 {
	public static int gcd(int a, int b) {
		
		int counter = 0;
		if (b <= -1 || a <= -1){
			return -1;
		}

		if (a > b && a % b == 0){
			return b;
		}
		if (a < b && b % a == 0){
			return a;
		}

		if (a == 0 && b != 0){
			return b;

		}
		if (b == 0 && a != 0){ 
			return a;
		}
		if (a == 0 && b == 0){ 
			return -1;

		}

		double highersqrt = 0;
		if (a > b){
			highersqrt = Math.sqrt(a);
		}
		else{
			highersqrt = Math.sqrt(b);
		}

		int GCdivisor = 1;
		int tempdivisor = 1;
		for (int i=0 ; i < (int)highersqrt + 1 ; i++){
			if (a % tempdivisor == 0 && b % tempdivisor == 0){
				GCdivisor = tempdivisor;
				tempdivisor++;
			}
		}
		return GCdivisor;
	}
	
	public static void main(String[] args){
		gcd(1,0);
	}
}
