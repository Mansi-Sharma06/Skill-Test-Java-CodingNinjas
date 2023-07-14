/* Number of Atoms
Given a string, representing a chemical formula, return the count of each atom.
An atomic element always starts with an uppercase character, then zero or more lowercase letters follow, representing the name.
One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
Two formulas can be concatenated together to produce another formula. For example, H2O2He3Mg4 is also a formula.
A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
Given a formula, return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
Note :
The given formula consists of English alphabets, digits, ‘(‘ and ’)’.

The given formula is always valid. 
Input Format
The first line of input contains an integer 'T' representing the number of test cases. Then the test cases follow.

The only line of each test case contains a string representing the formula.
Output Format:
For each test case, return the string representing the count of all the elements is printed.

The output for each test case is in a separate line.
Note:
You are not required to print the expected output, it has already been taken care of. Just implement the function.
Constraints:
1 <= T <= 10
1 <= |S| <= 10^4

Time Limit: 1 sec
Note :
The count of each element in the formula will not exceed 2^31.
Sample Input 1:
2
H2O
Mg(OH)2
Sample Output 1:
H2O
H2MgO2
Explanation of the Sample Input 1:
The first formula contains two elements H and O, with their count as 2 and 1 respectively. Since the count of O is not greater than 1, it is printed as O only and H is printed as H2. 

The second formula contains three elements : Mg, O and H. Mg has a count of 1 and since O and H are in parentheses followed by the digit 2, both have a count of 2. 
Sample Input 2:
1
K4(ON(SO3)2)2
Sample Output 2:
K4N2O14S4
Explanation of Sample Input 2
For the given formula, the elements are K, O, N and S. The count of K is 4, N is 2, O is 14 ( (1 + (3*2)) * 2 = 14) and that of S is 4 (2 * 2).
Sample Input 3
1
Be32
Sample Output 3
Be32*/ 

// public class Solution {
// 	public static String countNumberOfAtoms(String s) {
// 		// Write your code here.
// 	}
// }


import java.util.*;

public class Solution {
    public static String countNumberOfAtoms(String s) {
        Map<String, Integer> counts = getCounts(s.toCharArray(), new int[]{0});
        StringBuilder sb = new StringBuilder();
        for (String element : counts.keySet()) {
            sb.append(element);
            int count = counts.get(element);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    private static Map<String, Integer> getCounts(char[] arr, int[] index) {
        Map<String, Integer> counts = new TreeMap<>();
        int n = arr.length;
        while (index[0] < n && arr[index[0]] != ')') {
            if (arr[index[0]] == '(') {
                index[0]++;
                Map<String, Integer> innerCounts = getCounts(arr, index);
                int count = getCount(arr, index);
                for (String element : innerCounts.keySet()) {
                    counts.put(element, counts.getOrDefault(element, 0) + innerCounts.get(element) * count);
                }
            } else {
                String element = getElement(arr, index);
                int count = getCount(arr, index);
                counts.put(element, counts.getOrDefault(element, 0) + count);
            }
        }
        index[0]++; // Skip ')'
        return counts;
    }

    private static String getElement(char[] arr, int[] index) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[index[0]++]);
        while (index[0] < arr.length && Character.isLowerCase(arr[index[0]])) {
            sb.append(arr[index[0]++]);
        }
        return sb.toString();
    }

    private static int getCount(char[] arr, int[] index) {
        if (index[0] == arr.length || !Character.isDigit(arr[index[0]])) {
            return 1;
        }
        int count = 0;
        while (index[0] < arr.length && Character.isDigit(arr[index[0]])) {
            count = count * 10 + (arr[index[0]++] - '0');
        }
        return count;
    }
}


