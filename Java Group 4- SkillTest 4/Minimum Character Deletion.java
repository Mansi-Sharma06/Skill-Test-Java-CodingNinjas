/* Minimum Character Deletion
You are given a string ‘STR’. You need to find and return the minimum number of characters to be deleted from ‘STR’ so that the frequency of each character in the string becomes unique.
Example:
If the given string is “aaBBccc” then the frequency of characters: { a:2, B:2, c:3 }. Now, as ‘a’ and ‘B’ both have the same frequency 2, we need to delete one character either one ‘a’ or one ‘B’, to make their frequency different. After deleting any character we will get frequency as 1,2 and 3, as they all are different. Thus we got our solution as 1.
Input Format:
The first line of input contains a single integer 'T', representing the number of test cases.

The first line of each test case contains a string 'STR'. 
Output Format:
For each test case, print an integer denoting the minimum number of characters to be deleted from the string 'STR'.
Note:
You are not required to print the output, it has already been taken care of. Just implement the given function.
Constraints:
1 <= T <= 10
1 <= |STR| <= 10^5

Where |STR| is the length of the string 'STR'.

Time limit: 1 sec
Sample Input 1:
2
aaabbbcc
pqr
Sample Output 1:
2
2
Explanation for output 1:
In test case 1, after removing 2 a’s or 2 b’s, the resulting string that formed will have distinct frequencies of each character. 

In test case 2, we need to remove any two characters from the string to make a unique frequency string.
Sample Input 2:
2
AAbbbC
yxyzyzz
Sample Output 2:
0
1
Explanation for Output 2:
In test case 1, as the frequency of each character is already unique, thus no need to delete any character.

In test case 2, remove any 1 of the occurrence of y or z, and then we can each character's frequency as unique.*/


// public class Solution {
// 	public static int minCharDeletion(String str) {
// 		// Write your code here.
// 	}
// }

/*
    Time Complexity = O(N * logM)
    Space Complexity = O(M)
    
    Where 'N' is the length of the string.
    Where 'M' is the number of unique characters in the string.
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    public static int minCharDeletion(String input) {

        int len = input.length();

        // Counter of characters to delete.
        int count = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        // Storing frqquency of each character in the map.
        for (int i = 0; i < len; i++) {
            if(map.containsKey(input.charAt(i))){
                map.put(input.charAt(i), map.get(input.charAt(i))+1);
            }
            else{
                map.put(input.charAt(i), 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Set<Character> keys = map.keySet();
        
        // Put frequencies of characters into the priority queue.
        for(char key : keys){
            int currFreq = map.get(key);
            pq.add(currFreq);
        }

        while (!pq.isEmpty()) {

            // Take the biggest frequency character.
            int mostFrequent = pq.peek();
            pq.remove();

            // If priority queue is empty, then return the number of characters to be deleted.
            if (pq.isEmpty()) {
                return count;
            }

            // If this frequency is equal to the next one, decrease it by 1 and put back to the priority queue.
            if (mostFrequent == pq.peek()) {
                if (mostFrequent > 1) {
                    pq.add(mostFrequent - 1);
                }
                count++;
            }
        }
        // Return the number of characters to be deleted.
        return count;
    }

}
