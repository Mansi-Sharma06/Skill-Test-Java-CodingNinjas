/*Two Substrings
You are given a string S. Your task is to determine if the given string S contains two non-overlapping substrings "AB" and "BA" (the substrings can go in any order). Print "YES" or "NO".
The string S contains uppercase Latin letters only.
Input format :
Line 1: String S
Output format :
YES or NO
Constraints :
1 <= n (Length of String s) <= 10^5
Sample Input 1 :
ABA
Sample Output 1 :
NO
Sample Input 2 :
BACFAB
Sample Output 2 :
YES
Sample Input 3 :
AXBYBXA
Sample Output 3 :
NO*/



// public class Solution {

//     public static void twoSubstrings(String s) {
//         // Write your code here
//     }
// }

public class Solution {
    public static void twoSubstrings(String s) {
        int abIndex = s.indexOf("AB"); // search for the first occurrence of "AB"
        int baIndex = s.indexOf("BA"); // search for the first occurrence of "BA"

        // Check if "AB" followed by "BA" is found
        if (abIndex >= 0 && s.indexOf("BA", abIndex + 2) >= 0) {
            System.out.println("YES");
            return;
        }

        // Check if "BA" followed by "AB" is found
        if (baIndex >= 0 && s.indexOf("AB", baIndex + 2) >= 0) {
            System.out.println("YES");
            return;
        }

        // No non-overlapping substrings "AB" and "BA" found
        System.out.println("NO");
    }

    public static void main(String[] args) {
        // Test the function
        String s = "ABBAACDBAB";
        twoSubstrings(s);
    }
}
