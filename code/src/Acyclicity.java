import java.util.List;

public class Acyclicity {

    public static boolean isAcyclic(DirectedGraph graph) {
        System.out.println("Running sink elimination algorithm...");

        //loops until no sink is found
        while (!graph.isEmpty()) {
            Integer sink_find = graph.findingSink();

            //if no sink exists
            if (sink_find == null) {
                //this means every vertex has an outgoing edge
                System.out.println("No sink found - cycle exists!");

                //find the cycle and store as a list of vertices
                List<Integer> cycle = FindCycle.findCycle(graph);

                //outputting the cycle
                System.out.print("Cycle: ");
                for (int i = 0; i < cycle.size(); i++) {
                    if (i < cycle.size() - 1) {
                        System.out.print(cycle.get(i) + " > ");
                    } else {
                        System.out.print(cycle.get(i));
                    }
                }
                System.out.println();

                //not acyclic
                return false;
            }
            //if sink found remove from graph
            System.out.println("Removing sink - " + sink_find);
            graph.removeVertex(sink_find);
        }

        System.out.println("No cycle Found.");
        return true;
    }
}