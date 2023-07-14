/* Group sum
Given an integer array A of size N and an integer k, check if it is possible to choose a group of some of the integers in the array such that the group sums to the given target k.
There is one with this additional constraint -
if there are numbers in the array that are adjacent and having identical values, they must either all be chosen, or none of them chosen.
Return true or false.
For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group.
Input Format :
Line 1 : Integer N
Line 2 : Elements of array (separated by space)
Line 3 : Integer k
Output Format :
true or false
Constraints :
1 <= N <= 30
1 <= Ai <= 10^4
Sample Input 1 :
4
2 4 4 8
14
Sample Output 1 :
false
Sample Input 2 :
5
2 4 4 1 8
16
Sample Output 2 :
true */


// public class Solution {

// 	public static boolean subsetSumToKIdentical(int input[], int n,int k){
// 		/* Your class should be named Solution
// 		 * Don't write main().
// 		 * Don't read input, it is passed as function argument.
// 	 	 * Taking input and printing output is handled automatically.
// 		 */

// 	}
// }


public class Solution {
    public static void main(String[] args) {
        int input[] = {2, 4, 4, 8};
        int k = 14;
        int n = input.length;

        boolean result = subsetSumToKIdentical(input, n, k);
        System.out.println(result);
    }

    public static boolean subsetSumToKIdentical(int input[], int n, int k) {
        return subsetSumToKIdenticalHelper(input, n, k, 0, 0, false);
    }

    public static boolean subsetSumToKIdenticalHelper(int input[], int n, int k, int index, int sum, boolean prevMatch) {
        if (sum == k) {
            return true;
        }

        if (index >= n) {
            return false;
        }

        // If previous number matched the current number, either choose all or skip all
        if (index > 0 && input[index] == input[index - 1] && !prevMatch) {
            return subsetSumToKIdenticalHelper(input, n, k, index + 1, sum, false);
        }

        boolean include = subsetSumToKIdenticalHelper(input, n, k, index + 1, sum + input[index], true);
        boolean exclude = subsetSumToKIdenticalHelper(input, n, k, index + 1, sum, false);

        return include || exclude;
    }
}
