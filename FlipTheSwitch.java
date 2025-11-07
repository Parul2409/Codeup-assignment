import java.util.*;
public class FlipTheSwitch{
	public static int count(int[] arr){
		int count0=0,count1=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
			count0++;
			}
			else
			count1++;
		}
		min=Math.min(count0,count1);
		return min;
		}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array");
		if(!sc.hasNextInt()){
			System.err.println("Error!please enter a valid size");
			sc.close();
		}
		int n=sc.nextInt();
		System.out.println("Enter the elements of the array");
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			boolean valid_input = false;
            while (!valid_input) {
                if (sc.hasNextInt()) {
                    int input = sc.nextInt();
                    if (input == 0 || input == 1) {
                        arr[i] = input;
                        valid_input = true;
                    } else {
                        System.out.println("Error: Element must be 0 or 1. Please re-enter element at index " + i + ":");
                    }
                } else {
                    
                    System.out.println("Error: Input is not an integer. Please re-enter element at index " + i + ":");
                    sc.next(); 
                }
		}
		}
		int result=count(arr);
		System.out.println("Minimum swap is:"+result);
		}
}
		