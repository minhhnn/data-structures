package com.minhhnn.graph;

/**
 *
 */
public class UndirectedAdjacencyListGraph extends AdjacencyListGraph implements Graph {

    @Override
    public void addVertex(String label) {
        Vertex newVertex = new Vertex(label);
        vertices.add(newVertex);
    }


    @Override
    public void addEdge(Vertex pointA, Vertex pointB) {
        Edge newEdge = new Edge(pointA, pointB);
        edges.add(newEdge);

        // Because this is undirected graph, we need to add adjacent to both vertex
        pointA.addAdjacent(pointB);
        pointB.addAdjacent(pointA);
    }
}
