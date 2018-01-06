package com.minhhnn.graph;

/**
 * Created by @author minh on 01/01/2018.
 * UndirectedWeigthedAdjacencyList
 */
public class UndirectedWeigthedAdjacencyList extends UndirectedAdjacencyList {

    @Override
    public void addEdge(Vertex pointA, Vertex pointB) {
        addEdge(pointA, pointB, 1);
    }

    public void addEdge(Vertex pointA, Vertex pointB, int weight) {
        WeightedEdge weightedEdge = new WeightedEdge(pointA, pointB, weight);
        addEdge(weightedEdge);

        // Because this is undirected graph, we need to add adjacent to both vertex
        pointA.addAdjacent(pointB);
        pointB.addAdjacent(pointA);
    }
}
