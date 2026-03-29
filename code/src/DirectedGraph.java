import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class DirectedGraph {
    private Map<Integer, Set<Integer>> adjacencyList;


    //constructor
    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(int from, int to) {
        addVertex(from);
        addVertex(to);
        adjacencyList.get(from).add(to);
    }

    public Integer findSink() {
        for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return entry.getKey(); // found a sink
            }
        }
        return null; // no sink found — cycle exists

    }

    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex);
        for (Set<Integer> neighbours : adjacencyList.values()) {
            neighbours.remove(vertex);
        }
    }

    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }

    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    public Set<Integer> getNeighbours(int vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }
}

