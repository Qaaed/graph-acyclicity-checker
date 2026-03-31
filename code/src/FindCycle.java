import java.util.ArrayList;
import java.util.List;

public class FindCycle {

    public static List<Integer> findCycle(DirectedGraph graph) {
        //tracks all the vertices visited in order
        List<Integer> completed = new ArrayList<>();

        //picks any vertex from the graph to start from
        int start = graph.getVertices().iterator().next();

        //vertex we are currently at
        int current = start;

        while (!completed.contains(current)) {
            completed.add(current);
            current = graph.getNeighbours(current).iterator().next();
        }

        //holds the cycle part
        List<Integer> cycle = new ArrayList<>();
        //when a cycle start is noticed.
        boolean cycleStartFound = false;

        //finding where the cycle start
        for (int vertex : completed) {
            if (vertex == current)  cycleStartFound = true;
            if (cycleStartFound) cycle.add(vertex);
        }

        //adds the current value at the end (this confirms the cycle)
        cycle.add(current);
        return cycle;
    }
}