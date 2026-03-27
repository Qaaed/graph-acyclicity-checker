public class AcyclicityChecker {

    public static boolean isAcyclic(DirectedGraph graph) {

        // Keep going until the graph is empty or no sink is found
        while (!graph.isEmpty()) {

            // Step 1: Try to find a sink
            Integer sink = graph.findSink();

            // Step 2: If no sink exists, there is a cycle
            if (sink == null) {
                System.out.println("No sink found - cycle exists!");
                return false;
            }

            // Step 3: Found a sink, remove it and repeat
            System.out.println("Removing sink: " + sink);
            graph.removeVertex(sink);
        }

        // If we emptied the graph, it is acyclic
        System.out.println("Graph is empty - no cycle found!");
        return true;
    }
}