import java.util.*;
class Solution {
    class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int q = queries.length;
        int[][] q2 = new int[q][4];
        for (int i = 0; i < q; i++) {
            q2[i][0] = queries[i][0];
            q2[i][1] = queries[i][1];
            q2[i][2] = queries[i][2];
            q2[i][3] = i;
        }
        Arrays.sort(q2, (a, b) -> a[2] - b[2]);
        DSU dsu = new DSU(n);
        boolean[] ans = new boolean[q];
        int j = 0;
        for (int i = 0; i < q; i++) {
            int p = q2[i][0];
            int r = q2[i][1];
            int limit = q2[i][2];
            int idx = q2[i][3];
            while (j < edgeList.length && edgeList[j][2] < limit) {
                dsu.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            if (dsu.find(p) == dsu.find(r)) {
                ans[idx] = true;
            } else {
                ans[idx] = false;
            }
        }
        return ans;
    }
}