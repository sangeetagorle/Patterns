import java.util.*;
public class Pattern10 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n=scan.nextInt();
		int count;
		for(int i=0;i<n;i++) {
			count=i+1;
			for(int j=0;j<n;j++) {
				System.out.print(count+++" ");
			}
			System.out.println();
		}
		// TODO Auto-generated method stub

	}

}
