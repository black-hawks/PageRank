package pagerank.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * AdjacencyMatrix implementation of the Graph interface.
 * This implementation represents the graph as an adjacency matrix.
 *
 * @param <T> the type of the vertices in the graph
 */
public class AdjacencyMatrix<T> implements Graph<T> {
  /**
   * The adjacency matrix.
   */
  int[][] matrix;

  /**
   * The number of vertices in the graph.
   */
  int numOfVertices;

  /**
   * The list of vertices in the graph.
   */
  List<T> vertices;

  /**
   * Creates a new AdjacencyMatrix with the given number of vertices.
   *
   * @param numOfVertices the number of vertices in the graph
   */
  public AdjacencyMatrix(int numOfVertices) {
    this.numOfVertices = numOfVertices;
    matrix = new int[numOfVertices][numOfVertices];
    for (int[] row : matrix) {
      Arrays.fill(row, 0);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addEdge(T node1, T node2) {
    if (node1 instanceof Integer && node2 instanceof Integer) {
      matrix[((int) node1) - 1][((int) node2) - 1] = 1;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getNumNodes() {
    return numOfVertices;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<T> getVertices() {

    return this.vertices;
  }

  /**
   * Sets the list of vertices in the graph.
   *
   * @param vertices the list of vertices in the graph
   */
  public void setVertices(Set<Integer> vertices) {
    this.vertices = new ArrayList<>();
    for (Integer x : vertices) {
      this.vertices.add((T) x);
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<T> getEdges(T node) {
    if (node instanceof Integer) {
      return getOutDegree((int) node);
    }
    return null;
  }

  /**
   * Returns the out-degree (i.e., the neighbors) of the specified vertex.
   *
   * @param vertex the index of the vertex
   * @return a list of vertices representing the neighbors of the specified vertex
   */
  public List<T> getOutDegree(int vertex) {
    List<T> neighbours = new ArrayList<>();
    for (int i = 0; i <= matrix[vertex].length - 1; i++) {
      if (matrix[vertex][i] == 1) {
        neighbours.add((T) Integer.valueOf(i));
      }
    }
    return neighbours;
  }
}
