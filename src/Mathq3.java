
public class Mathq3 {
	public static boolean isPower(int a) {

		if (a <= 0){ return false;}
		if (a == 1){ return true;}
		if (a <= 3){ return false;}


		double Sqrt = Math.sqrt((double) a);
		if (Sqrt == Math.floor(Sqrt)){
			return true;
		}

		int intSqrt = (int) Sqrt;


		for (int i=2 ; i < intSqrt ; i++){

			int currVal = (int) (Math.log((double) a) / Math.log((double) i));
			if (Math.pow(i, currVal) == a){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args){
		boolean gg = isPower(536870912);
	}
}
