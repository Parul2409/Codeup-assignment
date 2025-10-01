import java.util.Scanner;
public class Sum{
        public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		if(sc.hasNextInt()){
		int num=sc.nextInt();
		int sum=0;
		while(num>0){
			int rem=num%10;
			sum+=rem;
			num=num/10;
		}
		System.out.print("Sum is:"+sum);
		}
		else{
		System.out.println("Invalid input. Please enter an integer.");}
		}
}