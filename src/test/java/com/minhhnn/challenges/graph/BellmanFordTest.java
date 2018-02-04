package com.minhhnn.challenges.graph;

import com.minhhnn.graph.DirectedWeigthedAdjacencyList;
import com.minhhnn.graph.Vertex;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BellmanFordTest {
    @Test
    public void findShortestPath() {
        DirectedWeigthedAdjacencyList graph = new DirectedWeigthedAdjacencyList();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge(graph.getVertex("A"), graph.getVertex("B"),10);
        graph.addEdge(graph.getVertex("A"), graph.getVertex("C"), 15);
        graph.addEdge(graph.getVertex("B"), graph.getVertex("D"), 12);
        graph.addEdge(graph.getVertex( "B"), graph.getVertex("F"), 15);
        graph.addEdge(graph.getVertex("C"), graph.getVertex("E"), 10);
        graph.addEdge(graph.getVertex("D"), graph.getVertex("E"), 2);
        graph.addEdge(graph.getVertex("D"), graph.getVertex("F"), 1);
        graph.addEdge(graph.getVertex("F"), graph.getVertex("E"), 5);

        Vertex source = graph.getVertex("A");
        Vertex target = graph.getVertex("E");
        BellmanFord bellmanFord = new BellmanFord(graph);
        Optional<List<Vertex>> path = bellmanFord.findShortestPath(source, target);

        Assert.assertThat("Must find a valid path from A to E", path.isPresent(), CoreMatchers.equalTo(true));
        Assert.assertThat("Path must be A, B, D, E", Arrays.toString(path.get().toArray()),
                CoreMatchers.equalTo(Arrays.toString(Arrays.asList("A", "B", "D", "E").toArray())));
    }
}
