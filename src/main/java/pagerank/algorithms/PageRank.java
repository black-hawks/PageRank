package pagerank.algorithms;

import pagerank.datastructure.graph.Graph;

import java.util.*;

/**
 * This class implements the PageRank algorithm on a graph.
 *
 * @param <T> the type of the nodes in the graph
 */
public class PageRank<T> {
  // damping Factor of PageRank Algorithm
  private static final double DAMPING_FACTOR = 0.85;

  // represents the convergence threshold for the PageRank algorithm
  private static final double EPSILON = 0.001;

  private final Graph<T> graph;
  private final int numNodes;

  /**
   * Constructor for PageRank class.
   *
   * @param graph    the graph on which the PageRank algorithm is to be implemented
   * @param numNodes the total number of nodes in the graph
   */
  public PageRank(Graph<T> graph, int numNodes) {
    this.graph = graph;
    this.numNodes = numNodes;
  }

  /**
   * This method calculates the PageRank of the nodes in the graph.
   *
   * @return an instance of the PageRankResult class, which contains the PageRank values,
   * the convergence values, and the epsilon threshold used for the convergence
   */
  public PageRankResult<T> calculatePageRank() {
    List<Double> convergenceList = new ArrayList<>();

    // calculate epsilon threshold based on graph size
    double epsilonThreshold = EPSILON / graph.getVertices().size();

    Map<T, Double> pageRank = new HashMap<>();
    Set<T> danglingNodes = new HashSet<>();

    // initialize page rank values and dangling nodes
    for (T node : graph.getVertices()) {
      double initialRank = 1.0 / numNodes;
      pageRank.put(node, initialRank);
      if (graph.getEdges(node).isEmpty()) {
        danglingNodes.add(node);
      }
    }

    boolean hasConverged = false;

    int i = 1;

    // perform PageRank iterations until convergence or maximum iterations reached
    while (i < 100 && !hasConverged) {

      double sum = 0.0;
      Map<T, Double> newPageRank = new HashMap<>();

      // calculate new page rank values for each node
      for (T node : graph.getVertices()) {
        double rank = (1 - DAMPING_FACTOR) / numNodes;

        // calculate contribution of neighbors to node's rank
        for (T neighbor : graph.getEdges(node)) {
          int numLinks = graph.getEdges(neighbor).size();
          if (numLinks > 0) {
            rank += DAMPING_FACTOR * pageRank.get(neighbor) / numLinks;
          }
        }

        newPageRank.put(node, rank);
        sum += rank;
      }

      // calculate contribution of dangling nodes to sum
      double danglingRank = 0.0;
      for (T node : danglingNodes) {
        danglingRank += pageRank.get(node);
      }
      danglingRank *= DAMPING_FACTOR / numNodes;
      sum += danglingRank;

      // normalize page rank values and calculate difference from previous iteration
      double difference = 0.0;
      for (T node : graph.getVertices()) {
        double rank = newPageRank.get(node) + danglingRank;
        rank /= sum;
        difference += Math.abs(rank - pageRank.get(node));
        pageRank.put(node, rank);
      }

      // Store the average difference and set hasConverged true if convergence is achieved
      double averageDifference = difference / graph.getVertices().size();
      convergenceList.add(averageDifference);
      if (averageDifference < epsilonThreshold) {
        hasConverged = true;
      }

      i++;
    }
    return new PageRankResult<>(pageRank, convergenceList, epsilonThreshold);
  }
}
