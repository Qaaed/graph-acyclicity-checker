# Graph Acyclicity Checker

A Java implementation of a **sink elimination algorithm** to determine whether a directed graph is acyclic. If a cycle is detected, the program traces and outputs the exact cycle. Developed as coursework for the **5SENG003C.2 Algorithms: Theory, Design and Implementation** module.

---

## How It Works

The algorithm is based on **sink elimination**:

1. Repeatedly find a **sink** — a vertex with no outgoing edges.
2. Remove it from the graph.
3. If all vertices are eventually removed, the graph is **acyclic**.
4. If no sink can be found while vertices remain, a **cycle exists** — every remaining vertex has at least one outgoing edge.

When a cycle is detected, a separate cycle-tracing routine walks the graph from any remaining vertex until it revisits a node, then extracts and prints the cycle.

---

## Project Structure

```
graph-acyclicity-checker/
├── code/
│   └── src/
│       ├── Main.java           # Entry point — load graph and print result
│       ├── Parser.java         # Reads benchmark files into a DirectedGraph
│       ├── DirectedGraph.java  # Adjacency-list graph with add/remove/query ops
│       ├── Acyclicity.java     # Sink elimination algorithm
│       └── FindCycle.java      # Cycle tracing when a cycle is detected
└── benchmarks/
    ├── cyclic/                 # Test graphs that contain cycles
    └── acyclic/                # Test graphs with no cycles
```

---

## Benchmark File Format

Each `.txt` file in the `benchmarks/` folder follows this format:

```
<number of vertices>
<from> <to>
<from> <to>
...
```

The first line (vertex count) is skipped by the parser; each subsequent line defines a directed edge.

---

## Getting Started

### Prerequisites

- Java 17 or later (project was developed with OpenJDK 23)
- Any Java IDE (IntelliJ IDEA recommended) or `javac`/`java` on the command line

### Running in IntelliJ IDEA

1. Open the `code/` directory as a project.
2. In `Main.java`, update the path passed to `Parser.parse(...)` to point to your chosen benchmark file:
   ```java
   DirectedGraph graph = Parser.parse("benchmarks/cyclic/c_40_0.txt");
   ```
3. Run `Main`.

### Running from the command line

```bash
cd code/src
javac *.java
java Main
```

> Make sure the working directory is set correctly so the relative path to the benchmark file resolves.

---

## Example Output

**Cyclic graph:**
```
Running sink elimination algorithm...
Removing sink - 5
Removing sink - 3
No sink found - cycle exists!
Cycle: 1 > 4 > 2 > 1
Result: NOT Acyclic since it has a cycle
```

**Acyclic graph:**
```
Running sink elimination algorithm...
Removing sink - 6
Removing sink - 4
Removing sink - 5
Removing sink - 2
Removing sink - 3
Removing sink - 1
No cycle Found.
Result: YES - acyclic
```

---

## Algorithm Complexity

| Phase | Time Complexity |
|---|---|
| Sink elimination (main loop) | O(V · (V + E)) |
| Cycle tracing (`FindCycle`) | O(V) |

Where **V** = number of vertices and **E** = number of edges.

---

## Module

> **5SENG003C.2 — Algorithms: Theory, Design and Implementation**  
> University of Westminster
