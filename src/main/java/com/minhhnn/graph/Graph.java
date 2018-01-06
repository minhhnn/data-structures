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
     * @param newEdge new edge
     */
    void addEdge(Edge newEdge);

    /**
     * Get a vertex by label name
     * @param label Vertex label
     * @return vertex
     */
    Vertex getVertex(String label);

    /**
     * Get a edge by source and destination vertex
     * @param pointA source vertex
     * @param pointB destination vertex
     * @return edge
     */
    Edge getEdge(Vertex pointA, Vertex pointB);

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
