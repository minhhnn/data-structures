package com.minhhnn.graph;

public class DirectedAdjacencyListGraph extends AdjacencyListGraph implements Graph {

    @Override
    public void addVertex(String label) {
        Vertex newVertex = new Vertex(label);
        vertices.add(newVertex);
    }

    @Override
    public void addEdge(Vertex source, Vertex destination) {
        Edge newEdge = new Edge(source, destination);
        edges.add(newEdge);

        // Because this is directed graph, we only need to add source to destination path
        source.addAdjacent(destination);
    }
}
