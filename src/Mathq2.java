
public class Mathq2 {
	public static int titleToNumber(String a) {

		if (a == null){ return -1;}

		int strlen = a.length();
		int sum = 0;

		for (int i=0 ; i < a.length() ; i++){
			char currChar = a.charAt(i); // take the char from the string in place i
			int currAsciiVal = (int) currChar; // get the ascii value
			int currCharVal = currAsciiVal - 64; // get the relevant value
			int powRes = (int) Math.pow(26, (strlen-(i+1)));
			sum += currCharVal*powRes;
		}

		return sum;
	}
	
	public static void main(String[] args){
		int res = titleToNumber("A");
	}
}
