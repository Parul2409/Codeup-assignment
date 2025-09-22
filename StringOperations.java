import java.util.*;

public class StringOperations {

    public static String Append(String original, String appended) {
        return original + appended;
    }
	public static String Replace(String str){
		if (str == null || str.trim().isEmpty()) {
        throw new IllegalArgumentException("Invalid input! Original string cannot be null or empty.");
    }

		Scanner sc = new Scanner(System.in);
		String target = "";
		String replace = "";
		System.out.println("Enter the old char or word: ");
		target = sc.nextLine();
		System.out.println("Enter the new char or word ");
		replace = sc.nextLine();
		
		String finalstr = "";
		
		for(int i=0; i<str.length(); i++){
			
			if(str.charAt(i) == target.charAt(0)){
				int start = i;
				int end = i;
				for(int j=1; j<target.length(); j++){
					if(str.charAt(i+1) == target.charAt(j)){
						end++;
						i++;
					} else {
						break;
					}
				}
				if((end-start) == (target.length() - 1)){
					finalstr += replace;
				}
			} else {
				finalstr += str.charAt(i);
			}
		}
		return finalstr;
	}
    public static String Sort(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] > chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }

    public static String Reverse(String input) {
        char[] chars = new char[input.length()];
        int n = input.length();
        for (int i = 0; i < n; i++) {
            chars[i] = input.charAt(n - 1 - i);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the string:");
            String input = sc.nextLine();

            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid input! String cannot be empty.");
            }

            System.out.println("""
			Enter the operation which you want to execute:
            Append
            Replace
            Sort
            Reverse""");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter string to append:");
                    String appendStr = sc.nextLine();
                    input = Append(input, appendStr);
                    System.out.println("Result: " + input);
                    break;

                case 2:
                    System.out.println("Result: " + Replace(input));
                    break;

                case 3:
                    System.out.println("Sort of the string: " + Sort(input));
                    break;

                case 4:
                    System.out.println("Reverse of the string: " + Reverse(input));
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number (1 to 4) instead of characters.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
