package dsa;

import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

class BellmanFordAlgorithmwithCaracters {
    // Edge class to represent an edge with destination and weight
    static class Edge {
        char destination;
        int weight;

        public Edge(char destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void bellmanFord(List<List<Edge>> graph, Map<Character, Integer> vertexMap, char source) {
        int V = vertexMap.size();
        int[] dist = new int[V];

        // Initialize distances
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[vertexMap.get(source)] = 0;

        // Relax edges |V| - 1 times
        for (int i = 1; i < V; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge edge : graph.get(u)) {
                    int v = vertexMap.get(edge.destination);
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + edge.weight < dist[v]) {
                        dist[v] = dist[u] + edge.weight;
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int u = 0; u < V; u++) {
            for (Edge edge : graph.get(u)) {
                int v = vertexMap.get(edge.destination);
                if (dist[u] != Integer.MAX_VALUE && dist[u] + edge.weight < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        // Print distances
        System.out.println("Vertex\tDistance from Source");
        for (Map.Entry<Character, Integer> entry : vertexMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + dist[entry.getValue()]);
        }
    }

    public static void main(String[] args) {
        // Define vertices
        char[] vertices = {'A', 'B', 'C', 'D', 'E'};

        // Create a map for vertex indices
        Map<Character, Integer> vertexMap = new HashMap<>();
        for (int i = 0; i < vertices.length; i++) {
            vertexMap.put(vertices[i], i);
        }

        // Create graph
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices.length; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(vertexMap.get('A')).add(new Edge('B', -1));
        graph.get(vertexMap.get('A')).add(new Edge('C', 4));
        graph.get(vertexMap.get('B')).add(new Edge('C', 3));
        graph.get(vertexMap.get('B')).add(new Edge('D', 2));
        graph.get(vertexMap.get('B')).add(new Edge('E', 2));
        graph.get(vertexMap.get('D')).add(new Edge('C', 5));
        graph.get(vertexMap.get('D')).add(new Edge('B', 1));
        graph.get(vertexMap.get('E')).add(new Edge('D', -3));

        // Run Bellman-Ford algorithm
        bellmanFord(graph, vertexMap, 'A');
    }
}

