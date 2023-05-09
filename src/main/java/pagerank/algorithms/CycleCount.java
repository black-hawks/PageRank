package pagerank.algorithms;

import pagerank.datastructure.graph.Graph;

import java.util.LinkedList;
import java.util.List;

/**
 * The CycleCount class contains methods to check if a given graph contains a cycle.
 */
public final class CycleCount {

  /**
   * Private constructor to prevent instantiation of the class.
   */
  private CycleCount() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * A utility function used by isCyclic() to check for cycles in a given graph.
   *
   * @param g              the graph to check for cycles
   * @param u              the starting vertex for the cycle check
   * @param visited        a list of visited vertices
   * @param recursionStack a list of vertices currently in recursion stack
   * @return true if a cycle is detected, false otherwise
   */
  public static boolean isCyclicUtil(Graph<Integer> g, Integer u, List<Integer> visited, List<Integer> recursionStack) {
    // If vertex is already in recursion stack, then there is a cycle
    if (recursionStack.contains(u)) {
      return true;
    }

    // If vertex is already visited, then it won't be part of cycle
    if (visited.contains(u)) {
      return false;
    }

    visited.add(u);
    recursionStack.add(u);

    // Recur for all the vertices adjacent to this vertex
    List<Integer> neighbours = g.getNeighbors(u);

    for (Integer v : neighbours) {
      if (isCyclicUtil(g, v, visited, recursionStack)) {
        return true;
      }
    }

    // Remove the vertex from recursion stack as it doesn't lead to a cycle
    recursionStack.remove(u);
    return false;
  }

  /**
   * Method to check if the given graph contains any cycles.
   *
   * @param graph the graph to check for cycles
   */
  public static void isCyclic(Graph<Integer> graph) {
    LinkedList<Integer> visited = new LinkedList<>();
    LinkedList<Integer> recursionStack = new LinkedList<>();
    int count = 0;

    List<Integer> vertices = graph.getVertices();
    for (Integer node : vertices) {
      // Check only non-isolated vertices
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
