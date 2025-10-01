import java.util.Scanner;
public class Consequence{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		if(sc.hasNextInt()){
			int num=sc.nextInt();
			int count=0;
			for(int start=1;start<=num/2;start++){
				int sum=0;
				for(int i=start;i<=num;i++){
					sum=sum+i;
					if(sum==num && i>start){
						count++;
						System.out.println(start+" to "+i);
						break;
					}
					if(sum>num){
						break;
					}
				}
			}
			System.out.println("Number of ways: "+count);
		}
		else{
			System.out.println("Invalid input. Please enter an integer.");
		}
	}
}