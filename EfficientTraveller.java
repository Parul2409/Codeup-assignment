import java.util.*;
public class EfficientTraveller{
	public static int index(String[] args){
		Scanner sc=new Scanner(System.in);
		int farthest=0;
		System.out.println("Enter the number of city");
		if (!sc.hasNextInt()) {
            System.err.println("ERROR: Invalid input for the number of cities. Please enter an integer.");
            sc.close();
			return 0;
        }
		int n=sc.nextInt();
		
		System.out.println("Enter the cost of energy");
		int[] arr=new int[n];
		for(int i=0;i<arr.length;i++){	
			if (!sc.hasNextInt()) {
            System.err.println(" ERROR: Invalid input for the number of cities. Please enter an integer.");
            sc.close();
			return 0;}
			arr[i]=sc.nextInt();
        }
		System.out.println("Enter the initial energy");
		if (!sc.hasNextInt()) {
            System.err.println("ERROR: Invalid input for the number of cities. Please enter an integer.");
            sc.close();
			return 0;
        }
		int initialEnergy=sc.nextInt();
		for(int i=0;i<arr.length;i++){
			int currEle=arr[i];
				if(initialEnergy>=currEle){
					initialEnergy-=currEle;
					farthest=i+1;
				}
				else{
					return farthest;
				}
			}
			return arr.length;
		}
		public static void main(String[] args){
			int result=index(args);
			System.out.println("Index is:"+result);
		}
}
			