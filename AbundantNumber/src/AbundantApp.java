import java.util.Scanner;

public class AbundantApp {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter a number");
		int num=scan.nextInt();
		
		Abundant ab=new Abundant();
		boolean res=ab.isAbundant(num);
		
		if(res==true) {
			System.out.println("Abundant number");
		}
		else {
			System.out.println("Deficient Number");
		}

	}

}
