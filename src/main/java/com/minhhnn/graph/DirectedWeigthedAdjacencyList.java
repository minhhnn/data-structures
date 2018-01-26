package com.minhhnn.graph;

/**
 * Created by @author minh on 01/01/2018.
 * UndirectedWeigthedAdjacencyList
 */
public class DirectedWeigthedAdjacencyList extends UndirectedAdjacencyList {

    @Override
    public void addEdge(Vertex pointA, Vertex pointB) {
        addEdge(pointA, pointB, 1);
    }

    public void addEdge(Vertex pointA, Vertex pointB, int weight) {
        WeightedEdge weightedEdge = new WeightedEdge(pointA, pointB, weight);
        addEdge(weightedEdge);

        // Because this is directed graph, we need to add adjacent to both vertex
        pointA.addAdjacent(pointB);
    }

    public int getDistance(Vertex pointA, Vertex pointB) {
        Edge edge = getEdge(pointA, pointB);
        if (edge != null) {
            return ((WeightedEdge) edge).getWeight();
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
