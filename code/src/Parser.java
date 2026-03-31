import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    public static DirectedGraph parse(String filename) throws IOException {
        DirectedGraph graph = new DirectedGraph();

        //opens the file
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        // Skips the first line based on the benchmark files(vertex count)
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            line = line.trim(); //removes extra lines
            if (line.isEmpty()) continue;

            //splitting the lines into 2 parts if there is a space
            String[] parts = line.split("\\s+");


            if (parts.length < 2) continue;

            //converting the numbers from text to integers
            int from = Integer.parseInt(parts[0]); //vertex 1
            int to = Integer.parseInt(parts[1]); //vertex 2

            //add the edge to the graph
            graph.addEdge(from, to);
        }

        //closes the file
        reader.close();
        return graph;
    }
}