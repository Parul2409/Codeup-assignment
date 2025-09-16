import java.util.*;

public class MyString {

    // 1. Expand String (e.g., a3b2 → aaabb)
    public static void expandString(String input) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            char ch = input.charAt(i);
            i++;

            int start = i;
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                i++;
            }

            int count = (start < i) ? Integer.parseInt(input.substring(start, i)) : 1;
            result.append(String.valueOf(ch).repeat(count));
        }
        System.out.println("Expanded String: " + result.toString());
    }

    // 2. Frequency Encoding (Run-length encoding, e.g., aabcc → a2b1c2)
    public static void frequencyEncode(String input) {
        int number = 1;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                number++;
            } else {
                result.append(input.charAt(i)).append(number);
                number = 1;
            }
        }
        result.append(input.charAt(input.length() - 1)).append(number);

        System.out.println("Frequency Encoded: " + result.toString());
    }

    // 3. Check Prime Number
    public static void checkPrime(int n) {
        if (n <= 1) {
            System.out.println("Not a prime number");
            return;
        }
        boolean prime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
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

    // 4. Longest substring without repeating characters
    public static void longestUniqueSubstring(String str) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int start = 0;

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            while (set.contains(c)) {
                set.remove(str.charAt(start));
                start++;
            }
            set.add(c);
            max = Math.max(max, end - start + 1);
        }
        System.out.println("Longest Unique Substring Length: " + max);
    }

    // 5. Number to Words
    private static final String[] belowTwenty = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        if (num < 0) return "Negative " + numberToWords(-num);

        String words = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        return words.trim();
    }

    private static String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return belowTwenty[num] + " ";
        else if (num < 100) return tens[num / 10] + " " + helper(num % 10);
        else return belowTwenty[num / 100] + " Hundred " + helper(num % 100);
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Call whichever function you want here 👇
        System.out.println("Choose option:\n1. Expand String\n2. Frequency Encode\n3. Prime Check\n4. Longest Unique Substring\n5. Number To Words");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

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
                int n = sc.nextInt();
                checkPrime(n);
                break;

            case 4:
                System.out.print("Enter string: ");
                String str3 = sc.nextLine();
                longestUniqueSubstring(str3);
                break;

            case 5:
                System.out.print("Enter number (-2,147,483,648 to 2,147,483,647): ");
                int num = sc.nextInt();
                System.out.println("In words: " + numberToWords(num));
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
