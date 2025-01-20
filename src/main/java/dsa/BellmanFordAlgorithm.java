package dsa;

import java.util.*;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class BellmanFordAlgorithm {
    public static void bellmanFord(int vertices, int edgesCount, List<Edge> edges, int source) {
        // Step 1: Initialize distances from source to all vertices as infinite
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Step 2: Relax all edges (V-1) times
        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.destination;
                int weight = edge.weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Step 3: Check for negative weight cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.destination;
            int weight = edge.weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print the result
        printSolution(distance, vertices);
    }

    private static void printSolution(int[] distance, int vertices) {
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " -> " + (distance[i] == Integer.MAX_VALUE ? "∞" : distance[i]));
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        int edgesCount = 8; // Number of edges

        List<Edge> edges = new ArrayList<>();
        // Add edges: source, destination, weight
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        int source = 0; // Source vertex

        bellmanFord(vertices, edgesCount, edges, source);
    }
}
