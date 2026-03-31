public class Main {
    public static void main(String[] args) throws Exception {
        DirectedGraph graph = Parser.parse("benchmarks/cyclic/c_40_0.txt"); //change the parsing value depend on the text file
        boolean result = Acyclicity.isAcyclic(graph);
        

        if (result) {
            System.out.println("Result: YES - acyclic");
        } else {
            System.out.println("Result: NOT Acyclic since it has a cycle");
        }


    }
}

