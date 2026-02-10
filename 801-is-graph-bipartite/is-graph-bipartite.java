class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;
                while (q.size() > 0) {
                    int front = q.remove();
                    for (int neig : graph[front]) {
                        if (color[neig] == -1) {
                            color[neig] = 1 - color[front];
                            q.add(neig);
                        } 
                        else if (color[neig] == color[front]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
