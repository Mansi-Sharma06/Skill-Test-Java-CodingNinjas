/* Maximum Sum BST
Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
Input Format:
The first and only line of input contains data of the nodes of the tree in level order form. The order is: data for root node, data for left child to root node,  data for right child to root node and so on and so forth for each node. The data of the nodes of the tree is separated by space. Data -1 denotes that the node doesn't exist.
Output Format:
Print the maximum sum
Sample Input 1:
1 4 3 2 4 2 5 -1 -1 -1 -1 -1 -1 4 6 -1 -1 -1 -1
Sample Output 1:
20
Explanation */ 

// public class Solution {
//     static public int maxSumBST(BinaryTreeNode<Integer> root) 
//     {
//         // Write your code here
//     }
// }

// class BinaryTreeNode<T> {
//     T data;
//     BinaryTreeNode<T> left;
//     BinaryTreeNode<T> right;

//     public BinaryTreeNode(T data) {
//         this.data = data;
//         this.left = null;
//         this.right = null;
//     }
// }

public class Solution {
    static class Result {
        int maxSum;
        int minKey;
        int maxKey;
        boolean isBST;

        public Result(int maxSum, int minKey, int maxKey, boolean isBST) {
            this.maxSum = maxSum;
            this.minKey = minKey;
            this.maxKey = maxKey;
            this.isBST = isBST;
        }
    }

    public static int maxSumBST(BinaryTreeNode<Integer> root) {
        Result result = maxSumBSTHelper(root);
        return result.maxSum;
    }

    private static Result maxSumBSTHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Result leftResult = maxSumBSTHelper(root.left);
        Result rightResult = maxSumBSTHelper(root.right);

        if (leftResult.isBST && rightResult.isBST && root.data > leftResult.maxKey && root.data < rightResult.minKey) {
            int sum = leftResult.maxSum + rightResult.maxSum + root.data;
            int minKey = Math.min(leftResult.minKey, root.data);
            int maxKey = Math.max(rightResult.maxKey, root.data);
            return new Result(sum, minKey, maxKey, true);
        } else {
            int maxSum = Math.max(leftResult.maxSum, rightResult.maxSum);
            return new Result(maxSum, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }
    }
}




