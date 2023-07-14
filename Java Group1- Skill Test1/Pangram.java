/*Pangram
A word or a sentence is called a pangram if all the characters of this language appear in it at least once. You are given a string s consisting of lowercase and uppercase Latin letters. Check whether this string is a pangram. Print "YES" or "NO".
We say that the string contains a letter of the Latin alphabet, if this letter occurs in the string in either uppercase or in lowercase.
Input format :
Line 1 : n (Number of characters in string)
Line 2 : Input string s
Output format :
YES or NO
Constraints :
1 <= n <= 100
Sample Input 1 :
12
toosmallword
Sample Output 1 :
NO
Sample Input 2 :
35
TheQuickBrownFoxJumpsOverTheLazyDog
Sample Output 2 :
YES*/

// import java.util.Scanner;

// public class Solution {

// 	public static void ans(int n, String str) {
// 		//Write your code here
// 	}

	

	
// }
import java.util.Scanner;

public class Solution {
    public static void ans(int n, String str) {
        boolean[] isPresent = new boolean[26]; // to track presence of each letter

        // Convert the input string to lowercase
        String s = str.toLowerCase();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if the character is a lowercase letter
            if (ch >= 'a' && ch <= 'z') {
                int index = ch - 'a';
                isPresent[index] = true;
            }
        }

        // Check if any letter is missing
        for (boolean present : isPresent) {
            if (!present) {
                System.out.println("NO");
                return;
            }
        }

        // All letters are present
        System.out.println("YES");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of test cases

        for (int i = 0; i < n; i++) {
            String str = scanner.next(); // input string
            ans(n, str);
        }
    }
}


