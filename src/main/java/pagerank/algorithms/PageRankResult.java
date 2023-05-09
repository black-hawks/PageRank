package pagerank.algorithms;

import java.util.List;
import java.util.Map;

public class PageRankResult<T> {
  Map<T, Double> pageRank;
  List<Double> convergence;
  double epsilonThreshold;

  public PageRankResult(Map<T, Double> pageRank, List<Double> convergence, double epsilonThreshold) {
    this.pageRank = pageRank;
    this.convergence = convergence;
    this.epsilonThreshold = epsilonThreshold;
  }

  public Map<T, Double> getPageRankList() {
    return pageRank;
  }

  public List<Double> getConvergence() {
    return convergence;
  }

  public double getEpsilonThreshold() {
    return epsilonThreshold;
  }
}
