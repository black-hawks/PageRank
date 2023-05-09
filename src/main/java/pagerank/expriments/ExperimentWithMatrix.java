package pagerank.expriments;

import pagerank.algorithms.PageRank;
import pagerank.algorithms.PageRankResult;
import pagerank.datastructure.graph.AdjacencyMatrix;
import pagerank.datastructure.graph.Graph;
import pagerank.util.DataGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class for running an experiment with the PageRank algorithm using an adjacency matrix representation of a graph.
 * It generates a graph using data from a CSV file, calculates the PageRank values for each node, and prints out the
 * top ten nodes with the highest PageRank values and the convergence timeline.
 */
public class ExperimentWithMatrix {
  /**
   * Main method for running the experiment.
   *
   * @param args command line arguments (not used in this implementation)
   * @throws IOException if there is an error reading the data file
   */
  public static void main(String[] args) throws IOException {
    DataGenerator dataGenerator = new DataGenerator();
    int numOfVertices = dataGenerator.numOfVertices("data/graph_data.csv");
    AdjacencyMatrix<Integer> matrix = new AdjacencyMatrix<>(numOfVertices);
    Graph<Integer> graph = dataGenerator.generateGraph(matrix, "data/graph_data.csv");
    Set<Integer> vertices = dataGenerator.getVertices();
    matrix.setVertices(vertices);
    PageRank<Integer> pageRank = new PageRank<>(graph, graph.getNumNodes());
    PageRankResult<Integer> pageRankResult = pageRank.calculatePageRank();
    System.out.println();
    printTopTenPages(pageRankResult.getPageRankList());
    printConvergenceTimeline(pageRankResult.getConvergence());
  }

  /**
   * Prints the top ten nodes with the highest PageRank values.
   *
   * @param pageRanks a map of each node's PageRank value
   */
  private static void printTopTenPages(Map<Integer, Double> pageRanks) {
    System.out.println("Top Ten Pages:");
    List<Map.Entry<Integer, Double>> pageRankList = new ArrayList<>(pageRanks.entrySet());

    // Sort pageRankList by descending value
    pageRankList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

    // Print top 10 nodes and their PageRank values
    int index = 1;
    for (Map.Entry<Integer, Double> entry : pageRankList) {
      System.out.println((index++) + ". " + entry.getKey() + " - " + entry.getValue());
      if (index > 10) {
        break;
      }
    }
    System.out.println();
  }

  /**
   * Prints the convergence timeline of the PageRank algorithm.
   *
   * @param convergence a list of the convergence values for each iteration
   */
  private static void printConvergenceTimeline(List<Double> convergence) {
    System.out.println("Convergence Timeline:");
    int index = 1;
    for (Double difference : convergence) {
      System.out.println("Iteration " + (index++) + ": " + difference);
    }
    System.out.println();
  }
}
