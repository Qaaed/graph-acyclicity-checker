import java.util.List;

public class AcyclicityChecker {

    public static boolean isAcyclic(DirectedGraph graph) {

        while (!graph.isEmpty()) {

            Integer sink = graph.findSink();

            if (sink == null) {
                System.out.println("No sink found - cycle exists!");

                List<Integer> cycle = CycleFinder.findCycle(graph);
                System.out.print("Cycle: ");
                for (int i = 0; i < cycle.size(); i++) {
                    if (i < cycle.size() - 1) {
                        System.out.print(cycle.get(i) + " -> ");
                    } else {
                        System.out.print(cycle.get(i));
                    }
                }
                System.out.println();
                return false;
            }

            System.out.println("Removing sink: " + sink);
            graph.removeVertex(sink);
        }

        System.out.println("Graph is empty - no cycle found!");
        return true;
    }
}