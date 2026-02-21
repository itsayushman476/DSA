import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < pre.length; i++){
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int front = q.remove();
            ans.add(front);

            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }

        if(ans.size() != numCourses) return new int[0];

        int[] ans2 = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            ans2[i] = ans.get(i);
        }
        return ans2;
    }
}
