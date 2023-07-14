/* Keep Score of Brackets
Vaibhavi loves to play with strings of brackets. She likes the balanced string of brackets, so much so, that she has decided to score them. She follows the following grading system:
1. A bracket group like () has score of  3
2. XY has a score of score X + Y, where X and Y are balanced parentheses strings.
3. A bracket group like (A) has score 3 * A, where A is a balanced parentheses string.
Given a balanced paranthesis string, your job is to find the score of it and solve the riddle.
Input Format:
First and only line of input contains a balanced paranthesis string, S.
Constraints:
S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50
Output Format:
Print the score of the input string.
Sample Input:
(()(()))
Sample Output:
36
Explanation:
Let us break down the () first.
(3(3)) 
Now, (3) evaluates to 9
(3 9)
3 and 9 are two pairs of balanced results, hence add them
(12)
This evaluates to 24.*/


// import java.util.*;
// class Solution {
//     static public int scoreOfParentheses(String S) {
//         // Write your code here
//     }
// }

/*
    Time complexity: O(N)
    Space complexity: O(N) 

    Where  N represents the size of given string.
*/

import java.util.Stack;

public class Solution {
    public static int scoreOfParentheses(String S) {
        Stack<String> s = new Stack<>();
        int i = 0;
        int n = S.length();

        // Stores total scores obtained from the string.
        int ans = 0;

        // Iterate over string character by character.
        while (i < n) {

            // If s[i] is '('.
            if (S.charAt(i) == '(') {
                s.push("(");
            }

            else {

                // If top element of stack is '('.
                if (s.peek() == "(") {
                    s.pop();
                    s.push("3");
                }

                else {

                    // Stores score of inner parentheses.
                    int count = 0;

                    // Calculate score of inner parentheses.
                    while (!s.empty() && s.peek() != "(") {

                        int x = Integer.parseInt(s.peek());
                        // Update count.
                        count += x;
                        s.pop();
                    }

                    // Pop from stack.
                    s.pop();

                    // Insert score of inner parentheses.
                    s.push(new String(Integer.toString(3 * count)));
                }
            }

            // Update i.
            i++;
        }

        // Calculate score of the string.
        while (!s.empty()) {
            // Update ans.
            ans += Integer.parseInt(s.peek());
            s.pop();
        }

        return ans;
    }

}
