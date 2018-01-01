package com.minhhnn.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author minh on 01/01/2018.
 *
 * Implement Graph using Adjacency list
 */
public abstract class AdjacencyListGraph {
    protected List<Vertex> vertices;
    protected List<Edge> edges;

    public AdjacencyListGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
