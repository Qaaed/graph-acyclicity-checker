import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphParser {

    public static DirectedGraph parse(String filename) throws IOException {
        DirectedGraph graph = new DirectedGraph();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            graph.addEdge(from, to);
        }

        reader.close();
        return graph;
    }
}