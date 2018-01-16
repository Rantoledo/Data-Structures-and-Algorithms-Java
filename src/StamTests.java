
public class StamTests {
	
	public static int returnZero(){
		int one = 1;
		int two = 2;
		if(two > one){
			return 0;
		}
		return 0;
	}
	public static void main(String[] args){
	
		for (int i=1;i<10;i++){
			if(i%2==0){continue;}
			System.out.println(i);
		}
		System.out.println("END");
	}
}
