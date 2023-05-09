package pagerank.algorithms;

import pagerank.datastructure.adjacentList.Node;

import java.util.List;

public class PageRankResult {
  List<Node> pageRankList;
  List<Double> convergence;

  public PageRankResult(List<Node> pageRankList, List<Double> convergence) {
    this.pageRankList = pageRankList;
    this.convergence = convergence;
  }

  public List<Node> getPageRankList() {
    return pageRankList;
  }

  public List<Double> getConvergence() {
    return convergence;
  }
}
