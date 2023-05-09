package pagerank.algorithms;

import java.util.List;
import java.util.Map;

public class PageRankResult<T> {
  Map<T, Double> pageRank;
  List<Double> convergence;

  public PageRankResult(Map<T, Double> pageRank, List<Double> convergence) {
    this.pageRank = pageRank;
    this.convergence = convergence;
  }

  public Map<T, Double> getPageRankList() {
    return pageRank;
  }

  public List<Double> getConvergence() {
    return convergence;
  }
}
