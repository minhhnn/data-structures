package com.minhhnn.graph;

public class WeightedEdge extends Edge {

    private int weight;

    public WeightedEdge(Vertex pointA, Vertex pointB, int weight) {
        super(pointA, pointB);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
