package com.minhhnn.graph;

public class Edge {
    private Vertex pointA;
    private Vertex pointB;

    public Edge(Vertex pointA, Vertex pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Vertex getPointA() {
        return pointA;
    }

    public void setPointA(Vertex pointA) {
        this.pointA = pointA;
    }

    public Vertex getPointB() {
        return pointB;
    }

    public void setPointB(Vertex pointB) {
        this.pointB = pointB;
    }

    @Override
    public String toString() {
        return "{" + pointA + ", "  + pointB + "}";
    }
}
