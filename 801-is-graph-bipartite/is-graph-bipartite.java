class Solution {
    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        // 0 = not colored
        // 1 = Red
        // 2 = Blue

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {

            // Already part of a previous BFS
            if (color[i] != 0) {
                continue;
            }

            // Start a new component
            color[i] = 1;
            queue.offer(i);

            // BFS
            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int nei : graph[node]) {

                    // Neighbor is not colored
                    if (color[nei] == 0) {

                        // Give opposite color
                        color[nei] = 3 - color[node];

                        queue.offer(nei);
                    }

                    // Neighbor already has a color
                    else if (color[nei] == color[node]) {

                        // Both have the same color
                        return false;
                    }
                }
            }
        }

        return true;
    }
}