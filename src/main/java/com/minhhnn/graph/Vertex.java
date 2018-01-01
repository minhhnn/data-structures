package com.minhhnn.graph;

import java.util.ArrayList;
import java.util.List;

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
}
