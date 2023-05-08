package pagerank.datastructure;

import java.util.List;
import java.util.Map;

public interface Graph<T> {
  // Add an edge between two nodes
  void addEdge(T node1, T node2);

  // Get the number of nodes in the graph
  int getNumNodes();

  // Get the neighbors of a node
  List<T> getNeighbors(T node);

}
