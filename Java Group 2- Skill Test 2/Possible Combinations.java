/* Possible Combinations
You are given N integers (12<N<20) in sorted order and your task is to print all the possible combinations of the numbers that can be used to choose 12 numbers out of the given N numbers in sorted order.
Input Format:
First line contains N - (Integer)
Second line contains N spaced integers which are player Id of players. Note that, all the N integers are given in sorted order.
Output Format:
Print the space separated combinations in N lines
Constraints
12<= N <= 20
1 <= Ai <=1000
Sample Input :
13
1 2 3 4 5 6 7 8 9 10 11 12 13
Sample Output :
1 2 3 4 5 6 7 8 9 10 11 12
1 2 3 4 5 6 7 8 9 10 11 13 
1 2 3 4 5 6 7 8 9 10 12 13 
1 2 3 4 5 6 7 8 9 11 12 13 
1 2 3 4 5 6 7 8 10 11 12 13 
1 2 3 4 5 6 7 9 10 11 12 13 
1 2 3 4 5 6 8 9 10 11 12 13 
1 2 3 4 5 7 8 9 10 11 12 13 
1 2 3 4 6 7 8 9 10 11 12 13 
1 2 3 5 6 7 8 9 10 11 12 13 
1 2 4 5 6 7 8 9 10 11 12 13 
1 3 4 5 6 7 8 9 10 11 12 13 
2 3 4 5 6 7 8 9 10 11 12 13  */


// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Solution {
// 	public static void main (String[] args) {
// 	    // Write your code here
//         // Take input and print desired output
	
// 	}
// }

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        int[] combination = new int[12];
        printCombinations(numbers, combination, 0, 0);
    }

    public static void printCombinations(int[] numbers, int[] combination, int currentIndex, int currentNumberIndex) {
        if (currentIndex == 12) {
            for (int i = 0; i < 12; i++) {
                System.out.print(combination[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = currentNumberIndex; i < numbers.length; i++) {
            combination[currentIndex] = numbers[i];
            printCombinations(numbers, combination, currentIndex + 1, i + 1);
        }
    }
}
