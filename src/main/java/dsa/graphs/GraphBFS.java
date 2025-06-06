package dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

class Graph{
    int v; // for Vertices
    LinkedList<Integer>[] adj;

   public Graph(int v){
        this.v=v;
        adj=new LinkedList[v];
       for (int i = 0; i < v; ++i)
           adj[i] = new LinkedList<>();
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
      //  adj[w].add(v);// WE can remove for Directed Graph
    }
}
public class GraphBFS {

    public static void main(String[] args) {
        System.out.println("Started");

        GraphBFS graphBFS = new GraphBFS();
        Graph graph = graphBFS.adjcencyListGraph();


        graphBFS.printGraph(graph);
        graphBFS.bfs(graph,0);


    }

    public Graph adjcencyListGraph(){
        Graph graph=new Graph(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        return  graph;

    }
    public Graph adjcencyMatrixGraph(){
        Graph graph=new Graph(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        return  graph;

    }
    void printGraph(Graph graph){
        System.out.println(graph.adj.length);

        for (int i = 0; i < graph.adj.length; i++) {
            System.out.print(i + ": ");
            for (int neighbor : graph.adj[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }


    void bfs(Graph graph, int source){
        boolean[] visited = new boolean[graph.v];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;

        queue.add(source);
        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u + " ");
            for (int neighbor : graph.adj[u]) {

                //System.out.print(neighbor + " ");
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }


    }
}
