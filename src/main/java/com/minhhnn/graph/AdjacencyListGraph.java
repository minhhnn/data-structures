package com.minhhnn.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author minh on 01/01/2018.
 *
 * Implement Graph using Adjacency list
 */
public abstract class AdjacencyListGraph implements Graph {
    protected List<Vertex> vertices;
    protected List<Edge> edges;

    public AdjacencyListGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public Vertex getVertex(String label) {
        return vertices.stream().filter(v -> v.getLabel().equals(label)).findFirst().orElse(null);
    }

    @Override
    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    @Override
    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }
}
