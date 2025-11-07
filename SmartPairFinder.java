import java.util.*;
public class SmartPairFinder{
	public static boolean sum(int[] arr,int n,int k){
		int i=0,j=1;
		while(i<arr.length&&j<arr.length){
			if(arr[i]+arr[j]==k){
				return true;
			}
			i++;
			j++;
		}
		return false;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array:");
		if (!sc.hasNextInt()) {
            System.err.println("ERROR: Invalid input for the number of cities. Please enter an integer.");
            sc.close();
        }
        int n = sc.nextInt();
        int [] nums = new int[n];
        System.out.println("Enter elements of array:");
        for(int i=0;i<nums.length;i++){
			if (!sc.hasNextInt()) {
            System.err.println("ERROR: Invalid input for the number of cities. Please enter an integer.");
            sc.close();
        }
            nums[i] = sc.nextInt();
        }
		System.out.println("Enter the target element");
		if (!sc.hasNextInt()) {
            System.err.println("ERROR: Invalid input for the number of cities. Please enter an integer.");
            sc.close();
        }
        int k= sc.nextInt();
		boolean result=sum(nums,n,k);
		System.out.println("Is target present:"+result);
		}
}