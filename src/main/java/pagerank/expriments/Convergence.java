package pagerank.expriments;

import pagerank.algorithms.PageRankResult;
import pagerank.datastructure.graph.AdjacencyListGraph;
import pagerank.datastructure.graph.Graph;
import pagerank.util.DataGenerator;

import java.io.IOException;

/**
 * A class that provides a main method to demonstrate the convergence of the PageRank algorithm
 * on a generated graph.
 */
public class Convergence {
  /**
   * The main method that generates a graph from a file and calculates the PageRank values, and
   * then prints out the convergence timeline of the algorithm.
   *
   * @param args the command line arguments, no need to pass any arguments
   * @throws IOException if there is an error reading the input file
   */
  public static void main(String[] args) throws IOException {
    printConvergenceTimeline("web-Google-0.001.txt");
  }

  /**
   * A helper method that generates a graph from a file, calculates the PageRank values, and
   * then prints out the convergence timeline of the algorithm.
   *
   * @param filename the filename of the input graph
   * @throws IOException if there is an error reading the input file
   */
  private static void printConvergenceTimeline(String filename) throws IOException {
    DataGenerator dataGenerator = new DataGenerator(filename);
    Graph<Integer> graph = dataGenerator.generateGraph(new AdjacencyListGraph<>());
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
