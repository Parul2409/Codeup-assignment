import java.util.Scanner;
public class EncodeAscii{
    public static String asciiTrans(String str, int x) {
        String result = ""; 

        for (int i = 0; i < str.length(); i++) {  
            char originalChar = str.charAt(i);
            int shiftedValue = originalChar + x;
            char shiftedChar = (char) shiftedValue;
            result = result + shiftedChar;
        } 
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String str = sc.next(); 
        System.out.println("Enter the shift value:");
        int x = sc.nextInt();
        String result = asciiTrans(str, x);
        System.out.println("Shifted string: " + result);
        sc.close(); 
    }
}