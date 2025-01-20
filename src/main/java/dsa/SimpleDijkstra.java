package dsa;

import java.util.*;

class SimpleDijkstra {

    static class Edge {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int source) {
        int V = graph.size(); // Number of vertices
        int[] distances = new int[V];
        boolean[] visited = new boolean[V];

        // Initialize distances to infinity
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Priority queue to store the vertex and its distance
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        priorityQueue.offer(new Edge(source, 0));

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();
            int currentVertex = current.vertex;

            if (visited[currentVertex]) continue; // Skip already processed vertices
            visited[currentVertex] = true;

            // Process neighbors
            for (Edge neighbor : graph.get(currentVertex)) {
                int neighborVertex = neighbor.vertex;
                int weight = neighbor.weight;

                if (!visited[neighborVertex] && distances[currentVertex] + weight < distances[neighborVertex]) {
                    distances[neighborVertex] = distances[currentVertex] + weight;
                    priorityQueue.offer(new Edge(neighborVertex, distances[neighborVertex]));
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        // Graph representation as adjacency list
        int V = 4; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>();

        // Initialize graph
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (vertex, weight)
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));
        graph.get(2).add(new Edge(3, 3));

        // Call Dijkstra's algorithm
        dijkstra(graph, 0); // Source vertex is 0
    }
}
