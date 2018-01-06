package com.minhhnn.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {
    private String label;
    private List<Vertex> adjacents;

    public Vertex(String label) {
        this.label = label;
        adjacents = new ArrayList<>();
    }

    public void addAdjacent(Vertex pointB) {
        adjacents.add(pointB);
    }

    public List<Vertex> getAdjacentVertices() {
        return new ArrayList<>(adjacents);
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label;
    }
}
