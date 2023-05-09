package pagerank.algorithms;

import pagerank.datastructure.Graph;
import pagerank.datastructure.adjacentList.AdjacencyListGraph;
import pagerank.datastructure.adjacentList.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CycleCount {
    public static int count = 0;

  public static boolean isCyclicUtil(Graph g, Node u, LinkedList<Node> visited, LinkedList<Node> recursionStack) {
    if (recursionStack.contains(u)) {
      return true;
    }

    if (visited.contains(u)) {
      return false;
    }

    visited.add(u);
    recursionStack.add(u);

    List<Node> neighbours = g.getNeighbors(u);

    for (Node v : neighbours) {
      if (isCyclicUtil(g, v, visited, recursionStack)) {
        return true;
      }
    }

    recursionStack.remove(u);
    return false;
  }

  public static int isCyclic(Graph<Node> graph) {
    LinkedList<Node> visited = new LinkedList();
    LinkedList<Node> recursionStack = new LinkedList();

    Set<Node> vertices  = ((AdjacencyListGraph)graph).getAllNodes();
    for(Node node : vertices){
      if (!visited.contains(node) && isCyclicUtil(graph, graph.getNeighbors(node).get(0), visited, recursionStack)) {
        count++;
      }
    }
//    for (int i = 0; i < graph.getNumNodes(); i++) {
//      if (!visited.contains(i) && isCyclicUtil(graph, graph.getNeighbors().get(0), visited, recursionStack)) {
//        count++;
//      }
//    }

    return count;
  }



    public static void main(String args[]) {
      Graph g = new AdjacencyListGraph();
      Node node1 = new Node(1);
      Node node2 = new Node(2);
      Node node3 = new Node(3);
      Node node4 = new Node(4);
      Node node5 = new Node(5);
      Node node6 = new Node(6);
      Node node7 = new Node(7);
      Node node8 = new Node(8);

      g.addEdge(node1, node2);
      g.addEdge(node2, node3);
      g.addEdge(node3, node1);
      g.addEdge(node4, node5);
      g.addEdge(node5, node6);
      g.addEdge(node6, node7);
      g.addEdge(node7, node4);

      if (isCyclic(g) > 0) {
        System.out.println("Cycle detected");
        System.out.println("Graph contains " + count + " cycles");
      } else {
        System.out.println("Graph doesn't contain cycle");
      }
    }
}


