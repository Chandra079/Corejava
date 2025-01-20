package dsa;

public class GraphAdjMatrix {
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int[][] graph = new int[V][V];

        // Add edges
        graph[0][1] = 1; // Edge from vertex 0 to 1 with weight 1
        graph[0][2] = 4; // Edge from vertex 0 to 2 with weight 4
        graph[1][2] = 2; // Edge from vertex 1 to 2 with weight 2
        graph[1][3] = 7; // Edge from vertex 1 to 3 with weight 7
        graph[2][3] = 3; // Edge from vertex 2 to 3 with weight 3

        // Print adjacency matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
