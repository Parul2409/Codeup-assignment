import java.util.*;
public class MinimalistPainter{
	public static int painter(int[] arr,int n){
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		int total=0;
		for(int i=0;i<n;i++){
			total+=arr[i];
		}
		int result=total-max;
		return result;
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
		int result=painter(nums,n);
		System.out.println("Minimum total time is:"+result);
		}
}
			