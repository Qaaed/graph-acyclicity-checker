// Student ID: 20240279 / w2153368
// Name: Qaaed Usaim
// Module: 5SENG003W Algorithms Coursework 2025/26
public class Main {
    public static void main(String[] args) throws Exception {
        DirectedGraph graph = GraphParser.parse("test.txt");
        boolean result = AcyclicityChecker.isAcyclic(graph);

        if (result) {
            System.out.println("Result: YES - graph is acyclic");
        } else {
            System.out.println("Result: NO - graph has a cycle");
        }
    }
}