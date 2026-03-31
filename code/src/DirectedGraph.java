import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class DirectedGraph {

    //data structture = adjacencyList
    //key = integer
    //value = set of vertices
    private Map<Integer, Set<Integer>> adjacencyList;


    //constructor
    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    //adds a new vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>()); //putIfAbsent makes sure we don't overwrite existing edges
    }


    //adds a directed edge from one edge to another
    public void addEdge(int from, int to) {
        addVertex(from);
        addVertex(to);
        adjacencyList.get(from).add(to);
    }

    //finds and returns a sink
    public Integer findingSink() {
        for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return entry.getKey(); // when sink is found
            }
        }
        return null; // no sink found, which means there is a cycle

    }

    //removes a vertex from the graph + the edges pointing to it + removes vertex from neighbouring sets
    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex); //removing vertex

        for (Set<Integer> neighbours : adjacencyList.values()) {
            neighbours.remove(vertex);
        }
    }


    //checks if there are vertices remaining
    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }

    //returns all the vertices remaining
    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    //returns all the neighbours of a given vertex
    public Set<Integer> getNeighbours(int vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }
}

