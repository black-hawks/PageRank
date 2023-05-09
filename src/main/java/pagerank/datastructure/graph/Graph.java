package pagerank.datastructure.graph;

import java.util.List;

/**
 * An interface that represents a graph data structure.
 *
 * @param <T> the type of vertices in the graph
 */
public interface Graph<T> {
  /**
   * Adds an edge between two nodes.
   *
   * @param node1 the first node to connect
   * @param node2 the second node to connect
   */
  void addEdge(T node1, T node2);

  /**
   * Returns the number of nodes in the graph.
   *
   * @return the number of nodes in the graph
   */
  int getNumNodes();

  /**
   * Returns a list of all vertices in the graph.
   *
   * @return a list of all vertices in the graph
   */
  List<T> getVertices();

  /**
   * Returns a list of all edges that are adjacent to a given node in the graph.
   *
   * @param node the node whose adjacent edges are to be returned
   * @return a list of all edges that are adjacent to the given node
   */
  List<T> getEdges(T node);

}
