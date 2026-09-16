import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Graph {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);

        boolean[] visited = new boolean[5];
        dfs(0, graph, visited);
        bfs(0,graph);
    }

    static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        System.out.println(node);

        for (int next : graph.get(node)) {
            dfs(next, graph, visited);
        }
    }

    static void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
