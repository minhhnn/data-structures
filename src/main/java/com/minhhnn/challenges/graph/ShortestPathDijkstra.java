package com.minhhnn.challenges.graph;

import com.minhhnn.graph.DirectedWeigthedAdjacencyList;
import com.minhhnn.graph.Vertex;

import java.util.*;

/**
 * Created by @author minh on 26/01/2018.
 * Find shortest path using Dijkstra's algorithm
 */
public class ShortestPathDijkstra {
    private DirectedWeigthedAdjacencyList graph;
    private Vertex source;
    private Map<Vertex, Integer> distance;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unsettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private PriorityQueue<Vertex> queue = new PriorityQueue<>();

    public ShortestPathDijkstra(DirectedWeigthedAdjacencyList graph, Vertex source) {
        this.graph = graph;
        this.source = source;
        distance = new HashMap<>();
        distance.put(source, 0);

        settledNodes = new HashSet<>();
        unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);
        predecessors = new HashMap<>();
        queue.add(source);
    }

    public Optional<List<Vertex>> findShortestPath(DirectedWeigthedAdjacencyList graph, Vertex source, Vertex target) {
        findShortestPath(graph, source);
        return getPath(target);
    }

    private void findShortestPath(DirectedWeigthedAdjacencyList graph, Vertex source) {
        while (!unsettledNodes.isEmpty()) {
            Vertex v = getMinDistanceNode(unsettledNodes);
            settledNodes.add(v);
            unsettledNodes.remove(v);
            relaxingNodes(v);
        }
    }

    private void relaxingNodes(Vertex startNode) {
        for (Vertex endNode: startNode.getAdjacentVertices()) {
            if (!isSettled(endNode)) { // ignore nodes already settled
                int tempDistance = getShortestDistance(startNode) + graph.getDistance(startNode, endNode);
                if (getShortestDistance(endNode) > tempDistance) {
                    distance.put(endNode, tempDistance);
                    predecessors.put(endNode, startNode);
                    unsettledNodes.add(endNode);
                }

            }
        }
    }

    private boolean isSettled(Vertex v) {
        return settledNodes.contains(v);
    }

    private Vertex getMinDistanceNode(Set<Vertex> unsettledNodes) {
        Vertex result = null;

        for (Vertex v: unsettledNodes) {
            if (result == null) {
                result = v;
            } else {
                if (getShortestDistance(result) > getShortestDistance(v)) {
                    result = v;
                }
            }
        }

        return result;
    }

    private int getShortestDistance(Vertex vertex) {
        if (distance.containsKey(vertex)) {
            return distance.get(vertex);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * return Optional.Empty if no path exists
     */
    private Optional<List<Vertex>> getPath(Vertex target) {
        List<Vertex> path = new LinkedList<Vertex>();
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
