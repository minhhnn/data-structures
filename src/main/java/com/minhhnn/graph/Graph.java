package com.minhhnn.graph;

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
}
