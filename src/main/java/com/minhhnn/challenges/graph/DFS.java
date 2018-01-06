package com.minhhnn.challenges.graph;

import com.minhhnn.graph.Graph;
import com.minhhnn.graph.UndirectedAdjacencyList;
import com.minhhnn.graph.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by @author minh on 06/01/2018.
 * Depth-First Search
 */
public class DFS {
    public static void main(String[] args) {
        Graph graph = createUndirectedAdjacencyListGraph();

        System.out.println("Vertices : " + Arrays.toString(graph.getVertices().toArray()));
        System.out.println("Edges    : " + Arrays.toString(graph.getEdges().toArray()));

        System.out.println("DFS:");
        printDFS(graph.getVertex("A"));
    }

    private static void printDFS(Vertex currentVertex) {
        printDFS(currentVertex, new ArrayList<>());
    }

    private static void printDFS(Vertex currentVertex, List<Vertex> visited) {
        if (!visited.contains(currentVertex)) {
            System.out.print(currentVertex + " ");
            visited.add(currentVertex);
            for (Vertex v : currentVertex.getAdjacentVertices()) {
                printDFS(v, visited);
            }
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
