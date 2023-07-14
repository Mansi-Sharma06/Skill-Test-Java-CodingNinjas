/* Limited Subway Surfer
Nidhi has created an alternate version of Subway Surfer game. Her new version is not on a train track unlimited length, rather limited to a track of length N + 1. Just like the original game, this alternate version also has three lanes.
The track has points on it ranging from 0 to N.
In the three lanes, at some points, certain manholes are present. Now, to avoid these manholes, our player needs to jump sideways and switch lanes, as he cannot go from i to (i + 1)th point on the same lane if there is no manhole on the lane at point i + 1.
You are given an array manholes of length N + 1 where manholes[i] tells us on which lane is the manhole present for point i. For example, if manholes[2] = 1, this means that on point 2 of the train track, a manhole is present on lane 1.
Find the minimum number of lane changes our player has to perform in order to reach from point 0 to point N on the train track.
Note:
If manholes[i] = 0, this means that for point i, there is no manhole present on any lane.
manholes[0] and manholes[N] are always 0.
Input Format:
First line of input contains integer T, representing the number of test cases.
First line of each test case contains the integer N.
Second line of each test case contains N + 1 space separated integers, representing manholes[i].
Our player always begins from the middle lane.
Constraints:
manholes.length == n + 1
1 <= t <= 100
1 <= N <= 5 * 10^4
0 <= manholes[i] <= 3
manholes[0] == manholes[n] == 0
Output Format:
Minimum number of lane changes to reach from point 0 to N.
Sample Input:
4
0 1 2 3 0
Sample Output:
2
Explanation:
The optimal path followed by our player is shown in the image below:


It is clear that to reach from point 0 till point N optimally, out player will have to change lanes twice at minimum. */



// public class Solution {
//     static public int minLaneChanges(int[] manholes) {
     
//         // Write your code here


        
//     }    
 
// }

public class Solution {
    static public int minLaneChanges(int[] A) {
     	int[] dp = new int[]{1, 0, 1};
        for (int a: A) {
            if (a > 0)
                dp[a - 1] = 1000000;
            for (int i = 0; i < 3; ++i)
                if (a != i + 1)
                    dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + 1);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }    
 
}
