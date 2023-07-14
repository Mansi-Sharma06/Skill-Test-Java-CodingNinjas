/* Break Numbers
Given an integer n, break it into smaller numbers such that their summation is equal to n. Print all such combinations in different lines.
Note : [1, 2, 1] and [1,1, 2] are same, so print the particular sequence with increasing order. Order of different combinations doesn't matter.
Input format :
Integer n
Output format :
Print all possible combinations in different lines
Constraints :
1 <= n <= 100
Input :
4
Output :
1 1 1 1
1 1 2
1 3
2 2
4   */

// public class solution {
// 	public static void printCombination(int num){
// 		//Write your code here
// 	}
// }

import java.util.ArrayList;
import java.util.List;
public class solution {
    public static void main(String[] args) {
        int num = 4;
        printCombination(num);
    }

    public static void printCombination(int num) {
        List<Integer> combination = new ArrayList<>();
        printCombinationHelper(num, 1, combination);
    }

    public static void printCombinationHelper(int num, int start, List<Integer> combination) {
        if (num == 0) {
            for (int value : combination) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= num; i++) {
            combination.add(i);
            printCombinationHelper(num - i, i, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
