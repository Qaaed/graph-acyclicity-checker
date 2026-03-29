// Student ID: [YOUR STUDENT ID]
// Name: [YOUR NAME]
// Module: 5SENG003W Algorithms Coursework 2025/26

import java.util.ArrayList;
import java.util.List;

public class CycleFinder {

    public static List<Integer> findCycle(DirectedGraph graph) {
        List<Integer> visited = new ArrayList<>();

        int start = graph.getVertices().iterator().next();
        int current = start;

        while (!visited.contains(current)) {
            visited.add(current);
            current = graph.getNeighbours(current).iterator().next();
        }

        List<Integer> cycle = new ArrayList<>();
        boolean recording = false;

        for (int vertex : visited) {
            if (vertex == current) recording = true;
            if (recording) cycle.add(vertex);
        }

        cycle.add(current);
        return cycle;
    }
}