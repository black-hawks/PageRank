package pagerank.datastructure.adjacentList;

import pagerank.algorithms.PageRankResult;
import pagerank.datastructure.Graph;

import java.util.*;

public class PageRank<T> {
  //damping Factor of PageRank Algorithm
  private static final double DAMPING_FACTOR = 0.85;

  //represents the convergence threshold for the PageRank algorithm
  private static final double EPSILON = 0.0001;

  private final Graph<T> graph;
  private final int numNodes;

  public PageRank(Graph<T> graph, int numNodes) {
    this.graph = graph;
    this.numNodes = numNodes;
  }

  public PageRankResult<T> calculatePageRank() {
    List<Double> convergenceList = new ArrayList<>();
    double epsilonThreshold = EPSILON / graph.getVertices().size();

    System.out.println("Epsilon Threshold: " + epsilonThreshold);

    Map<T, Double> pageRank = new HashMap<>();
    Set<T> danglingNodes = new HashSet<>();

    for (T node : graph.getVertices()) {
      double initialRank = 1.0 / numNodes;
      pageRank.put(node, initialRank);
      if (graph.getEdges(node).isEmpty()) {
        danglingNodes.add(node);
      }
    }

    boolean hasConverged = false;

    int i = 1;

    while (i < 100 && !hasConverged) {

      System.out.println("Iteration " + i);
      double sum = 0.0;
      Map<T, Double> newPageRank = new HashMap<>();

      for (T node : graph.getVertices()) {
        double rank = (1 - DAMPING_FACTOR) / numNodes;

        for (T neighbor : graph.getNeighbors(node)) {
          int numLinks = graph.getNeighbors(neighbor).size();
          if (numLinks > 0) {
            rank += DAMPING_FACTOR * pageRank.get(neighbor) / numLinks;
          }
        }

        newPageRank.put(node, rank);
        sum += rank;
      }

      double danglingRank = 0.0;
      for (T node : danglingNodes) {
        danglingRank += pageRank.get(node);
      }
      danglingRank *= DAMPING_FACTOR / numNodes;
      sum += danglingRank;


      // Normalize PageRank values
      double difference = 0.0;
      for (T node : graph.getVertices()) {
        double rank = newPageRank.get(node) + danglingRank;
        rank /= sum;
        difference += Math.abs(rank - pageRank.get(node));
        pageRank.put(node, rank);
      }

      double averageDifference = difference / graph.getVertices().size();
      convergenceList.add(averageDifference);
      System.out.println(averageDifference);
      if (averageDifference < epsilonThreshold) {
        hasConverged = true;
      }

      i++;
    }

    return new PageRankResult<>(pageRank, convergenceList);
  }

}
