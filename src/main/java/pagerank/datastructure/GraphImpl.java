package pagerank.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl<T> implements Graph<T> {
  private final Map<T, List<T>> adjacencyList;

  public GraphImpl() {
    this.adjacencyList = new HashMap<>();
  }

  public void addEdge(T node1, T node2) {
    adjacencyList.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
    adjacencyList.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
  }

  public int getNumNodes() {
    return adjacencyList.size();
  }

  public List<T> getNeighbors(T node) {
    return adjacencyList.getOrDefault(node, new ArrayList<>());
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<T, List<T>> entry : adjacencyList.entrySet()) {
      T node = entry.getKey();
      sb.append(node).append(": ");
      List<T> neighbors = adjacencyList.get(node);
      for (T neighbor : neighbors) {
        sb.append(neighbor).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

}
