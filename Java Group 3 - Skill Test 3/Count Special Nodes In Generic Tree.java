/* Count Special Nodes In Generic Tree
You have been given a Generic Tree of Integers. The task is to count the number of 'Special Nodes'.
A Node is a Special Node if there is a path from the root to that Node with all distinct elements.
Input format :
The first line contains an integer 'T' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and only line of each test case or query contains Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Elements are in the level order form and on a level from left to right.

For example, the input for the tree depicted in the below image would be :
alt text

1
2
2 3
1
4
2
5 6
1
7
0
0
0

Explanation :

Level 1 :
The root node of the tree has value 1 hence the first value. Now, on the second line, we have 2 which means root has 2 children. The values of the two children are 2 and 3 which is given on the third line.

Level 2 :
Now, in the level order traversal, we visit the data node 2 and see the number of children it has, which is given on the fourth line followed by the value(s) of its child/children. Here, data node 2 has only 1 child and hence the value mentioned on the fifth line is 4.

Next node in the level order traversal is the data node 3. It has 2 children as given on the 6th line. After that, on the 7th line, we have the values of its children which are 5 and 6.

Level 3 :
The first node on level three is 4 and it has 1 child as mentioned on the eighth line. On the ninth line, we have the value of the child as 7.
The second node is 5 which has 0 or no children and has been mentioned on the tenth line.
The third node is 6 which has 0 or no children and has been mentioned on the eleventh line.

Level 4 :
There is only 1 node at level 4 which is 7 and has 0 children or no children as mentioned on the twelfth line. 

As every node has 0 children now the input ends.
Note :
The above format was just to provide clarity on how the input is formed for a given tree. 

The sequence will be put together in a single line separated by a single space. Hence, for the above-depicted tree, the input will be given as:

1 2 2 3 1 4 2 5 6 1 7 0 0 0
Output format :
For each test case/query, print the number of Special Nodes present in the given Generic Tree.

Output for every test case will be printed in a separate line.
Note:
You are not required to print the output explicitly, it has already been taken care of. Just implement the function.
Constraints :
1 <= T <= 10^2
1 <= N <= 3000
0 <= Value of Tree Node <= 10^9

Time Limit: 1sec

Where 'T' is the number of Test Cases and 'N' is the number of nodes in Generic Tree.
Sample Input 1 :
2
10 3 20 30 10 2 50 10 0 0 0 0
5 3 5 5 4 0 0 2 1 5 0 0
Sample Output 1 :
4
3
 Explanation to Sample Input 1 :
For Test Case 1:
We have 4 Special Nodes:
10 Path: 10
20 Path: 10 -> 20
30 Path: 10 -> 30
50 Path: 10 -> 20 -> 50

For Test Case 2:
We have 3 Special Nodes:
5 Path: 5
4 Path: 5 -> 4
1 Path: 5 -> 4 -> 1 */


/* 

    Following is the class defined to represent the node of a generic tree

    class TreeNode<T> {
        T data;
        ArrayList<TreeNode<T>> children;

        public TreeNode(T data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public int numChildren() {
            return this.children.size();
        }

        public TreeNode<T> getChild(int index) {
            if (index > this.children.size()) {
                return null;
            }

            return this.children.get(index);
        }
    }

*/


// public class Solution {


//     public static int countSpecialNodes(TreeNode<Integer> root) {
//         //Your code goes here
//     }
// }

/*
    Time Complexity : O(N)
    Space Complexity : O(N)
    
    Where N is the number of nodes in Generic Tree
*/

import java.util.Set;
import java.util.HashSet;

public class Solution {

    private static int countSpecialNodesHelper(TreeNode<Integer> root, Set<Integer> distinctElements) {
        //  If the Node doesn't contain distinct element.
        if (distinctElements.contains(root.data)) {
            return 0;
        }

        //  Inserting Current Element
        distinctElements.add(root.data);

        int specialNodesInChild = 0;

        int childCount = root.numChildren();

        for (int i = 0; i < childCount; i++) {
            specialNodesInChild += countSpecialNodesHelper(root.getChild(i), distinctElements);
        }

        //  Removing Current Element
        distinctElements.remove(root.data);

        return (1 + specialNodesInChild);
    }

    public static int countSpecialNodes(TreeNode<Integer> root) {
        Set<Integer> distinctElements = new HashSet<>();
        return countSpecialNodesHelper(root, distinctElements);
    }
}
