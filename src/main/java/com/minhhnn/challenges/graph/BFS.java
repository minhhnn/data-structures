package com.minhhnn.challenges.graph;

import com.minhhnn.graph.Graph;
import com.minhhnn.graph.UndirectedAdjacencyList;
import com.minhhnn.graph.Vertex;

import java.util.*;

/**
 * Created by @author minh on 06/01/2018.
 * Breadth-First Search
 */
public class BFS {
    public static void main(String[] args) {
        Graph graph = createUndirectedAdjacencyListGraph();

        System.out.println("Vertices : " + Arrays.toString(graph.getVertices().toArray()));
        System.out.println("Edges    : " + Arrays.toString(graph.getEdges().toArray()));

        System.out.println("BFS:");
        printBFS(graph.getVertex("A"));
    }

    private static void printBFS(Vertex currentVertex) {
        Queue<Vertex> vertices = new LinkedList<>();
        List<Vertex> visited = new ArrayList<>();
        vertices.add(currentVertex);
        while (!vertices.isEmpty()) {
            Vertex nextVertexToVisit = vertices.remove();
            if (!visited.contains(nextVertexToVisit)) {
                System.out.print(nextVertexToVisit + " ");
                visited.add(nextVertexToVisit);

                // The above code can be replace with
                // vertices.addAll(nextVertexToVisit.getAdjacentVertices());
                for (Vertex v : nextVertexToVisit.getAdjacentVertices()) {
                    vertices.add(v);
                }
            }

        }

        if (!visited.contains(currentVertex)) {
            visited.add(currentVertex);
        }
    }

    private static UndirectedAdjacencyList createUndirectedAdjacencyListGraph() {
        UndirectedAdjacencyList graph = new UndirectedAdjacencyList();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge(graph.getVertex("A"), graph.getVertex("B"));
        graph.addEdge(graph.getVertex("A"), graph.getVertex("C"));
        graph.addEdge(graph.getVertex("B"), graph.getVertex("D"));
        graph.addEdge(graph.getVertex("B"), graph.getVertex("E"));
        graph.addEdge(graph.getVertex( "B"), graph.getVertex("F"));
        graph.addEdge(graph.getVertex("C"), graph.getVertex("D"));
        graph.addEdge(graph.getVertex("D"), graph.getVertex("F"));

        return graph;
    }
}
