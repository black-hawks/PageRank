package pagerank.algorithms;


import pagerank.datastructure.graph.Graph;

import java.util.LinkedList;
import java.util.List;

public class CycleCount {
  private CycleCount() {
    throw new IllegalStateException("Utility class");
  }

  public static boolean isCyclicUtil(Graph<Integer> g, Integer u, List<Integer> visited, List<Integer> recursionStack) {
    if (recursionStack.contains(u)) {
      return true;
    }

    if (visited.contains(u)) {
      return false;
    }

    visited.add(u);
    recursionStack.add(u);

    List<Integer> neighbours = g.getNeighbors(u);

    for (Integer v : neighbours) {
      if (isCyclicUtil(g, v, visited, recursionStack)) {
        return true;
      }
    }

    recursionStack.remove(u);
    return false;
  }

  public static void isCyclic(Graph<Integer> graph) {
    LinkedList<Integer> visited = new LinkedList<>();
    LinkedList<Integer> recursionStack = new LinkedList<>();
    int count = 0;

    List<Integer> vertices = graph.getVertices();
    for (Integer node : vertices) {
      if (!graph.getNeighbors(node).isEmpty() && (!visited.contains(node) && isCyclicUtil(graph, graph.getNeighbors(node).get(0), visited, recursionStack))) {
        count++;
      }

    }
    if (count > 0) {
      System.out.println("Cycle detected: Graph contains " + count + " cycles");
    } else {
      System.out.println("Graph doesn't contain cycle");
    }
  }
}


