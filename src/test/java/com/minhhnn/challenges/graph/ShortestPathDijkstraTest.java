package com.minhhnn.challenges.graph;

import com.minhhnn.graph.DirectedWeigthedAdjacencyList;
import com.minhhnn.graph.Vertex;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by @author minh on 26/01/2018.
 * Test find shortest path using Dijkstra's algorithm
 */
public class ShortestPathDijkstraTest {

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
        ShortestPathDijkstra dijkstra = new ShortestPathDijkstra(graph, graph.getVertex("A"));
        Optional<List<Vertex>> path = dijkstra.findShortestPath(graph, graph.getVertex("A"), graph.getVertex("E"));

        Assert.assertThat("Must find a valid path from A to E", path.isPresent(), CoreMatchers.equalTo(true));
        Assert.assertThat("Path must be A, B, D, E", Arrays.toString(path.get().toArray()),
                CoreMatchers.equalTo(Arrays.toString(Arrays.asList("A", "B", "D", "E").toArray())));
        /*if (path.isPresent()) {
            List<Vertex> vertices = path.get();
            System.out.print("Path from Vertex " + source + " to Vertex " + target + " : " + Arrays.toString(vertices.toArray()));
        } else {
            System.out.println("No Path from Vertex " + graph.getVertex("A") + " to Vertex " + graph.getVertex("E"));
        }*/
    }
}
