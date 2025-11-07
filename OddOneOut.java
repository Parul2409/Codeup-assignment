import java.util.*;;
public  class OddOneOut{
	public static int unique(int[] arr,int n){
		int xor=0;
		for(int i=0;i<n;i++){
			xor^=arr[i];
		}
		return xor;
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
		int result=unique(nums,n);
		System.out.println("Unique element is:"+result);
		}
	}