package pagerank.expriments;

import pagerank.algorithms.PageRankResult;
import pagerank.datastructure.graph.AdjacencyListGraph;
import pagerank.datastructure.graph.Graph;
import pagerank.util.DataGenerator;

import java.io.IOException;

public class Convergence {
  public static void main(String[] args) throws IOException {
    printConvergenceTimeline("web-Google-0.001.txt");
  }

  private static void printConvergenceTimeline(String filename) throws IOException {
    DataGenerator dataGenerator = new DataGenerator();
    Graph<Integer> graph = dataGenerator.generateGraph(new AdjacencyListGraph<>(), filename);
    pagerank.algorithms.PageRank<Integer> pageRank = new pagerank.algorithms.PageRank<>(graph, graph.getNumNodes());
    PageRankResult<Integer> pageRankResult = pageRank.calculatePageRank();
    System.out.println("Total iterations: " + pageRankResult.getConvergence().size());
    System.out.println();
    System.out.println("Epsilon Threshold: " + pageRankResult.getEpsilonThreshold());
    System.out.println();
    System.out.println("Convergence Timeline:");
    int index = 1;
    for (Double difference : pageRankResult.getConvergence()) {
      System.out.println("Iteration " + (index++) + ": " + difference);
    }
    System.out.println();
  }
}
