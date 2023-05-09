package pagerank.datastructure.graph;

import java.util.List;

public interface Graph<T> {
  // Add an edge between two nodes
  void addEdge(T node1, T node2);

  // Get the number of nodes in the graph
  int getNumNodes();

  List<T> getVertices();

  List<T> getEdges(T node);

}
