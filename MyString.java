
import java.util.*;

public class MyString {

    // 1. Expand String (e.g., a3b2 → aaabb)
    public static void expandString(String input) {
        int size=0,i=0;
		while(i<input.length()){
			char ch=input.charAt(i++);
			int start=i;
			while(i<input.length() && Character.isDigit(input.charAt(i))){
			i++;}
		int count=(start<i)?Integer.parseInt(input.substring(start,i)):1;
		size += count;
	}
		char[] result=new char[size];
		int index=0;
		i=0;
		while(i<input.length()){
			char ch=input.charAt(i++);
			int start=i;
			while(i<input.length() && Character.isDigit(input.charAt(i))){
			i++;}
		int count=(start<i)?Integer.parseInt(input.substring(start,i)):1;
		for(int j=0;j<count;j++){
			result[index++]=ch;
		}
		}
		System.out.print("Expanded String is"+new String(result));
	}

    // 2. Frequency Encoding 
    public static void frequencyEncode(String input) {
		int index=0;
		char[] result=new char[input.length()*2];
		for(int i=0;i<input.length();){
			char current=input.charAt(i);
			int number=1;
			while(i+1<input.length() && input.charAt(i+1)==current){
				 number++;
				 i++;
			}
			result[index++]=current;
			String numberstr=String.valueOf(number);
			for(int j=0;j<numberstr.length();j++){
				result[index++]=numberstr.charAt(j);
			}
			i++;
		}
			System.out.print("Frequency of String" +new String(result,0,index));
		
    }

    // 3. Check Prime Number
    public static void checkPrime(long n) {
        if (n <= 1) {
            System.out.println("Not a prime number");
            return;
        }
        boolean prime = true;
        for (int i = 2; i <= n*n; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not a prime number");
        }
    }

    /*
	// 4. Longest substring without repeating characters
    public static void longestUniqueSubstring(String str) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int start = 0;

        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(end);
            while (set.contains(c)) {
                set.remove(str.charAt(start));
                start++;
            }
            set.add(c);
            max = Math.max(max, end - start + 1);
        }
        System.out.println("Longest Unique Substring Length: " + max);
    }*/
    public static void longestUniqueSubstring(String s) {
        int[] charLastIndex = new int[128];
        for (int i = 0; i < charLastIndex.length; i++) {
            charLastIndex[i] = -1; 
        }

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charLastIndex[currentChar] >= left) {
                left = charLastIndex[currentChar] + 1;
            }
            charLastIndex[currentChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

       System.out.print(maxLength);
    }
    // 5. Number to Words
	static String integerToEnglish(int n) {
        String[] belowTen = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] belowTwenty = {"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] belowHundred = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(n == 0){
            return "Zero";
        }
        if(n < 10){
            return belowTen[n];
        }
        if(n < 20 && n != 10){
            return belowTwenty[n - 10];
        }
        if(n < 100){
            return belowHundred[n / 10] +  (n % 10 != 0 ? " " + belowTen[n % 10]:"");
        }
        if(n < 1000){
            return belowTen[n / 100] + " Hundred" + (n % 100 != 0 ? " " + integerToEnglish(n % 100): "");
        }
        return integerToEnglish(n / 1000) + " Thousand" + (n % 1000 != 0 ? " " + integerToEnglish(n % 1000) : "");
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose option:\n1. Expand String\n2. Frequency Encode\n3. Prime Check\n4. Longest Unique Substring\n5. Number To Words");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter encoded string (e.g. a3b2): ");
                String str1 = sc.nextLine();
                expandString(str1);
                break;

            case 2:
                System.out.print("Enter string (e.g. aabcc): ");
                String str2 = sc.nextLine();
                frequencyEncode(str2);
                break;
            case 3:
                System.out.print("Enter number: ");
                long n = sc.nextLong();
                checkPrime(n);
                break;

            case 4:
                System.out.print("Enter string: ");
                String str3 = sc.nextLine();
                longestUniqueSubstring(str3);
                break;
			
            case 5:
                System.out.print("Enter number: ");
                int num = sc.nextInt();
                System.out.println("In words: " + integerToEnglish(num));
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
