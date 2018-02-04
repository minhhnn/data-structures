package com.minhhnn.challenges.graph;

import com.minhhnn.graph.DirectedWeigthedAdjacencyList;
import com.minhhnn.graph.Edge;
import com.minhhnn.graph.Vertex;
import com.minhhnn.graph.WeightedEdge;

import java.util.*;

/**
 * Created by @author minh on 04/02/2018.
 * Find shortest path using Bellman-Ford's algorithm
 */
public class BellmanFord {
    private DirectedWeigthedAdjacencyList graph;
    private Map<Vertex, Integer> distance;
    private Map<Vertex, Vertex> predecessors;

    public BellmanFord(DirectedWeigthedAdjacencyList graph) {
        this.graph = graph;
        distance = new HashMap<>();
        predecessors = new HashMap<>();
    }

    /**
     * Find shortest path from source to target using Bellman-Ford algorithm
     * @param source source vertex
     */
    public Optional<List<Vertex>> findShortestPath(Vertex source, Vertex target) {
        findShortestPath(source);
        return getPath(target);
    }

    /**
     * Find shortest path from source to all other vertices using Bellman-Ford algorithm
     * @param source source vertex
     */
    private void findShortestPath(Vertex source) {
        for (Vertex v: graph.getVertices()) {
            if (v.equals(source)) {
                distance.put(source, 0);
            } else {
                distance.put(v, Integer.MAX_VALUE);
            }
        }

        // Relax all edges n times where n is the number of Vertices
        for (Vertex v: graph.getVertices()) {
            for (Edge e: graph.getEdges()) {
                Vertex start = e.getPointA();
                Vertex end = e.getPointB();
                int weight = ((WeightedEdge) e).getWeight();
                if (distance.get(start) != Integer.MAX_VALUE && distance.get(start) + weight < distance.get(end)) {
                    distance.put(end, distance.get(start) + weight);
                    predecessors.put(end, start);
                }
            }
        }

        // Detect negative weight cycle
        // If we can still relax edges here, mean that there is a negative weight cycle
        for (Edge e: graph.getEdges()) {
            Vertex start = e.getPointA();
            Vertex end = e.getPointB();
            int weight = ((WeightedEdge) e).getWeight();
            if (distance.get(end) != Integer.MAX_VALUE && distance.get(start) != Integer.MAX_VALUE
                    && distance.get(start) + weight < distance.get(end)) {
                System.out.println("Graph contains negative weight cycle");
            }
        }

        // Print result
        for (Vertex v: graph.getVertices()) {
            System.out.println("Min distance between Vertex " + source.getLabel() + " and Vertex " + v.getLabel()
                    + " = " + distance.get(v));
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * return Optional.Empty if no path exists
     */
    private Optional<List<Vertex>> getPath(Vertex target) {
        List<Vertex> path = new LinkedList<>();
        Vertex step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return Optional.empty();
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return Optional.of(path);
    }
}
