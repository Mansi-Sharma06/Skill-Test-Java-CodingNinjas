/*Print Matrix diagonally
Given a matrix of integers, you need to print it diagonally. Thats is, if input is a 3 x 3 matrix, then order will be -
(0, 0), (0, 1), (1, 0), (2, 0), (1, 1), (0, 2), (1, 2), (2, 1), (2, 2)
For eg. if input is -
 1  2  3
 4  5  6  
 7  8  9
Output : 1 2 4 7 5 3 6 8 9.
Input format :

Line 1 : m (No. of rows) and n (No. of columns)

Next m lines : Each row elements in different line

Output format : Print elements in specified order, separated by space

Sample Input :
4 4
 1  2   3  10
 4  5   6  11
 7  8   9  12
13 14  15  16
Sample Output :
1 2 4 7 5 3 10 6 8 13 14 9 11 12 15 16 */


import java.util.ArrayList;
import java.util.List;

public class solution {
    public static void printInDiagonalForm(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;

        int totalDiagonals = rows + columns - 1;
        List<Integer> diagonalElements = new ArrayList<>();

        // Traverse the diagonals
        for (int diagonal = 0; diagonal < totalDiagonals; diagonal++) {
            int startRow = Math.max(0, diagonal - columns + 1);
            int startCol = Math.max(0, diagonal - rows + 1);

            int endRow = Math.min(rows - 1, diagonal);
            int endCol = Math.min(columns - 1, diagonal);

            if (diagonal % 2 == 0) {
                // Traverse diagonals in upward direction
                for (int i = endRow, j = startCol; i >= startRow && j <= endCol; i--, j++) {
                    diagonalElements.add(arr[i][j]);
                }
            } else {
                // Traverse diagonals in downward direction
                for (int i = startRow, j = endCol; i <= endRow && j >= startCol; i++, j--) {
                    diagonalElements.add(arr[i][j]);
                }
            }
        }

        // Construct the diagonal string
        StringBuilder sb = new StringBuilder();
        for (int element : diagonalElements) {
            sb.append(element).append(" ");
        }

        // Print the diagonal string
        System.out.println(sb.toString());
    }
}


