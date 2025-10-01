import java.util.Scanner;
public class Paranthesis{
	public static void Generate(int open,int close,String res){
		if(open==0 && close==0){
		System.out.println(res);
		return;}
		if(open>0){
		Generate(open-1,close,res+"(");}
		if(close>open){
		Generate(open,close-1,res+")");}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the input");
		if(sc.hasNextInt()){
		int n=sc.nextInt();
		Generate(n,n,"");}
		else{
		System.out.println("Invalid input. Please enter an integer.");}
		}
	}