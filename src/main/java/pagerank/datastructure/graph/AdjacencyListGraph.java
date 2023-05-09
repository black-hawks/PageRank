package pagerank.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An implementation of the {@link Graph} interface that uses an adjacency list to represent the graph.
 *
 * @param <V> the type of vertices in the graph.
 */
public class AdjacencyListGraph<V> implements Graph<V> {
  /**
   * The adjacency list of the graph, which stores the edges for each vertex in the form of a list of vertices.
   */
  private final Map<V, List<V>> adjacencyList;

  /**
   * Constructs an empty adjacency list graph.
   */
  public AdjacencyListGraph() {
    adjacencyList = new HashMap<>();
  }

  /**
   * Adds a vertex to the graph.
   *
   * @param node the vertex to be added.
   */
  public void addVertex(V node) {
    adjacencyList.putIfAbsent(node, new ArrayList<>());
  }

  /**
   * Adds an edge to the graph between two vertices.
   *
   * @param node1 one of the vertices to connect.
   * @param node2 the other vertex to connect.
   */
  @Override
  public void addEdge(V node1, V node2) {
    if (!adjacencyList.containsKey(node1)) {
      addVertex(node1);
    }
    if (!adjacencyList.containsKey(node2)) {
      addVertex(node2);
    }
    adjacencyList.get(node1).add(node2);
  }

  /**
   * Returns the number of vertices in the graph.
   *
   * @return the number of vertices in the graph.
   */
  @Override
  public int getNumNodes() {
    return adjacencyList.size();
  }

  /**
   * Returns a list of all vertices in the graph.
   *
   * @return a list of all vertices in the graph.
   */
  @Override
  public List<V> getVertices() {
    return adjacencyList.keySet().stream().toList();
  }

  /**
   * Returns the edges that are connected to a given vertex.
   *
   * @param node the vertex whose edges to retrieve.
   * @return a list of vertices that are connected to the given vertex.
   */
  @Override
  public List<V> getEdges(V node) {
    return adjacencyList.get(node);
  }
}
