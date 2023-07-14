/* Special Walk
Marry and John are happy couple. They usually go on long drive on the weekend.
But today is Marry's birthday and John wants to make it special for her. He wants to again take her on a "special walk" as a birthday gift.

The city in which they lives is represented as an unweighted directed graph with N nodes and M edges. A "special walk" in the graph starting at node u is a simple path that begins and ends at the same node u.
Formally, A special walk is path u , a1 , a2 , a3 ,..., ai ,.... , u where ai are distinct and not equal to u for all i.
Now since John is really nervous about taking his girl out, he needs your help. For every node in the given graph, tell whether it is possible for John to take his girl on a "special walk" starting at that node.
Input Format:
First line of a two space separated integers denoting N and M, the number of nodes and number of directed edges in the corresponding graph. 
Following M lines contain two space separated integers u v denoting a directed edge in the graph from vertex numbered u to vertex numbered v.
Constraints:
1 ≤ N ≤ 100000
1 ≤ M ≤ 2 · 100000
1 ≤ u, v ≤ N 
Time limit : 2 sec
Output Format:
Print N space separated integers, where ith integer can be either 1 or 0 depicting whether it is possible to go on a special walk starting at node i or not.
Sample Input 1:
5 5
1 2 
2 3 
3 4 
4 5
4 2 
Sample Output 1:
0 1 1 1 0 
Explanation:
In the given graph , there is just one directed cycle : 2-->3-->4-->2. Hence, for all nodes on this cycle, the answer is yes and for others the answer is no.*/

import java.util.*;

public class Main {
    private static int index = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            int N = scanner.nextInt(); // Number of nodes
            int M = scanner.nextInt(); // Number of edges

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph.get(u).add(v);
            }

            int[] specialWalk = findSpecialWalks(graph, N);

            for (int i = 1; i <= N; i++) {
                System.out.print(specialWalk[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static int[] findSpecialWalks(List<List<Integer>> graph, int N) {
        int[] visited = new int[N + 1];
        int[] specialWalk = new int[N + 1];
        int[] lowLink = new int[N + 1];
        boolean[] onStack = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                dfs(i, graph, visited, specialWalk, lowLink, onStack, stack);
            }
        }

        return specialWalk;
    }

    private static void dfs(int node, List<List<Integer>> graph, int[] visited, int[] specialWalk, int[] lowLink, boolean[] onStack, Stack<Integer> stack) {
        visited[node] = lowLink[node] = ++index;
        stack.push(node);
        onStack[node] = true;

        if (node < graph.size()) {
            for (int neighbor : graph.get(node)) {
                if (visited[neighbor] == 0) {
                    dfs(neighbor, graph, visited, specialWalk, lowLink, onStack, stack);
                    lowLink[node] = Math.min(lowLink[node], lowLink[neighbor]);
                } else if (onStack[neighbor]) {
                    lowLink[node] = Math.min(lowLink[node], visited[neighbor]);
                }
            }
        }

        if (visited[node] == lowLink[node]) {
            while (!stack.isEmpty()) {
                int v = stack.pop();
                onStack[v] = false;
                specialWalk[v] = 1;
                if (v == node) {
                    break;
                }
            }
        }
    }
}
