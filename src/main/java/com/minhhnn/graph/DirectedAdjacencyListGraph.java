package com.minhhnn.graph;

public class DirectedAdjacencyListGraph extends AdjacencyListGraph {

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

    /**
     * Get edge base on source and destination vertex
     * Because this is directed graph, source must be pointA and destination must be pointB
     * @param pointA source vertex
     * @param pointB destination vertex
     * @return edge if found or null if not found
     */
    @Override
    public Edge getEdge(Vertex pointA, Vertex pointB) {
        return edges.stream().filter(e -> (e.getPointA().equals(pointA) && e.getPointB().equals(pointB)))
                .findFirst().orElse(null);
    }
}
