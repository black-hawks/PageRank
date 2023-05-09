package pagerank.datastructure.adjacentList;

import pagerank.algorithms.PageRankResult;
import pagerank.datastructure.Graph;
import pagerank.util.DataGenerator;

import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    DataGenerator dataGenerator = new DataGenerator();
    Graph<Node> graph = dataGenerator.generateGraph(new AdjacencyListGraph<>());

//        for(Map.Entry<Node, List<Node>> list : ((AdjacencyListGraph<Node>) graph).getAdjacencyList().entrySet()){
//            System.out.println("Vertex : " + list.getKey());
//        }
//        Graph<Node> graph = new AdjacencyListGraph<>();
//
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(6);
//
//        graph.addEdge(node1, node2);
//        graph.addEdge(node1, node3);
//        graph.addEdge(node2, node1);
//        graph.addEdge(node2, node3);
//        graph.addEdge(node3, node1);
//        graph.addEdge(node3, node2);
//        graph.addEdge(node3, node4);
//        graph.addEdge(node4, node3);
//        graph.addEdge(node4, node3);

    System.out.println(graph.getNumNodes());

    // Calculate the PageRank for each node
    PageRank pageRank = new PageRank(graph, graph.getNumNodes());
    PageRankResult pageRankResult = pageRank.calculatePageRank();
    List<Node> pageRankValues = pageRankResult.getPageRankList();
    pageRankValues.sort((a, b) -> {
      return (int) (a.getCurrentRank() - b.getCurrentRank());
    });
    int i = 0;
//         Print the PageRank values for each node
    for (Node node : pageRankValues) {
      System.out.println(node.getId() + " : value " + node.getCurrentRank());
      i++;
      if (i > 10) {
        break;
      }
    }
    System.out.println(pageRankResult.getConvergence());
  }
}

