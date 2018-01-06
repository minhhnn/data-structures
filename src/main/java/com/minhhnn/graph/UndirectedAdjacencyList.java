package com.minhhnn.graph;

/**
 * Created by @author minh on 01/01/2018.
 * UndirectedAdjacencyList
 */
public class UndirectedAdjacencyList extends AdjacencyList {

    public void addEdge(Vertex pointA, Vertex pointB) {
        Edge newEdge = new Edge(pointA, pointB);
        super.addEdge(newEdge);

        // Because this is undirected graph, we need to add adjacent to both vertex
        pointA.addAdjacent(pointB);
        pointB.addAdjacent(pointA);
    }

    /**
     * Get edge base on source and destination vertex
     * Because this is undirected graph, source and destination either pointA or pointB
     * @param pointA source vertex
     * @param pointB destination vertex
     * @return edge if found or null if not found
     */
    @Override
    public Edge getEdge(Vertex pointA, Vertex pointB) {
        return edges.stream().filter(e -> (e.getPointA().equals(pointA) && e.getPointB().equals(pointB))
                || (e.getPointA().equals(pointB) && e.getPointB().equals(pointA)))
                .findFirst().orElse(null);
    }
}
