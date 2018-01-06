package com.minhhnn.graph;

import java.util.List;

/**
 * Created by @author minh on 01/01/2018.
 *
 * Graph interface
 */
public interface Graph {
    /**
     * Add new vertex
     * @param label Vertex label, make this easy to read
     */
    void addVertex(String label);

    /**
     * Add new Edge
     * @param pointA source
     * @param pointB destination
     */
    void addEdge(Vertex pointA, Vertex pointB);

    /**
     * Get a vertex by label name
     * @param label Vertex label
     * @return vertex
     */
    Vertex getVertex(String label);

    /**
     * Get a list of vertices
     * @return ist of vertices
     */
    List<Vertex> getVertices();

    /**
     * Get a list of edges
     * @return ist of edges
     */
    List<Edge> getEdges();
}
