import java.util.Scanner;
public class Cipher{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=input.nextLine();
		System.out.println("Enter the value to be shifted:");
		int d=input.nextInt();
		String res="";
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			int value=ch+d;
			res+=(char)value;
			
		}
		System.out.print(res);
	}
}