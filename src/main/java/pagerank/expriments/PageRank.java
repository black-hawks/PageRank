package pagerank.expriments;

import pagerank.datastructure.graph.AdjacencyListGraph;
import pagerank.datastructure.graph.Graph;
import pagerank.util.DataGenerator;

import java.io.IOException;

/**
 * The PageRank class provides a main method to calculate the PageRank for multiple datasets. It uses the
 * DataGenerator class to generate the graph from the given dataset file and the PageRank class to calculate
 * the PageRank for each graph. The results of the PageRank calculation are printed to the console.
 */
public class PageRank {
  /**
   * The main method of the PageRank class.
   * Calculates the PageRank for multiple datasets.
   * Prints the time it took to calculate the PageRank for each dataset.
   *
   * @param args The command line arguments. No arguments need to be passed.
   * @throws IOException if there is an I/O error.
   */
  public static void main(String[] args) throws IOException {
    calcPageRank("web-Google-0.001.txt");
    calcPageRank("web-Google-0.005.txt");
    calcPageRank("web-Google-0.01.txt");
    calcPageRank("web-Google-0.05.txt");
    calcPageRank("web-Google-0.1.txt");
    calcPageRank("web-Google-0.5.txt");
    calcPageRank("web-Google.txt");
  }

  /**
   * Calculates the PageRank for a given dataset file and prints the time it took to calculate the PageRank.
   *
   * @param filename The name of the file containing the dataset.
   * @throws IOException if there is an I/O error.
   */
  private static void calcPageRank(String filename) throws IOException {
    long start = System.currentTimeMillis();
    DataGenerator dataGenerator = new DataGenerator();
    Graph<Integer> graph = dataGenerator.generateGraph(new AdjacencyListGraph<>(), filename);
    pagerank.algorithms.PageRank<Integer> pageRank = new pagerank.algorithms.PageRank<>(graph, graph.getNumNodes());
    pageRank.calculatePageRank();
    System.out.println("Calculation of Page Rank for " + graph.getVertices().size() + " vertices took: " + (System.currentTimeMillis() - start) + "ms");
  }
}