package pagerank.algorithms;

import java.util.List;
import java.util.Map;

/**
 * A class that represents the result of the PageRank algorithm, including the PageRank scores, convergence history,
 * and epsilon threshold used in the calculation.
 *
 * @param <T> the type of node in the graph
 */
public class PageRankResult<T> {
  Map<T, Double> pageRank;
  List<Double> convergence;
  double epsilonThreshold;

  /**
   * Constructor for PageRankResult class.
   *
   * @param pageRank         the map of node to its corresponding PageRank score
   * @param convergence      a list of average differences in PageRank scores between iterations
   * @param epsilonThreshold the threshold of convergence for the PageRank algorithm
   */
  public PageRankResult(Map<T, Double> pageRank, List<Double> convergence, double epsilonThreshold) {
    this.pageRank = pageRank;
    this.convergence = convergence;
    this.epsilonThreshold = epsilonThreshold;
  }

  /**
   * Returns the map of nodes to their corresponding PageRank scores.
   *
   * @return the map of nodes to their PageRank scores
   */
  public Map<T, Double> getPageRankList() {
    return pageRank;
  }

  /**
   * Returns a list of average differences in PageRank scores between iterations.
   *
   * @return the list of average differences in PageRank scores between iterations
   */
  public List<Double> getConvergence() {
    return convergence;
  }

  /**
   * Returns the threshold of convergence for the PageRank algorithm.
   *
   * @return the threshold of convergence for the PageRank algorithm
   */
  public double getEpsilonThreshold() {
    return epsilonThreshold;
  }
}
