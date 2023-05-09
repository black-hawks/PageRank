package pagerank.expriments;

import pagerank.algorithms.PageRank;
import pagerank.datastructure.graph.AdjacencyListGraph;
import pagerank.datastructure.graph.AdjacencyMatrix;
import pagerank.datastructure.graph.Graph;
import pagerank.util.DataGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/**
 * A class for comparing the performance of PageRank algorithm using
 * adjacency matrix and adjacency list implementations.
 */
public class MatrixComparission {

  /**
   * Main method to run the performance comparison experiment for PageRank algorithm.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    String fileName = "data/time_measurement.csv";
    try {
      FileWriter writer = new FileWriter(fileName);

      // Write CSV headers
      writer.write("Data Size,Adj. Matrix Time (ms) , Adj. List Time (ms)\n");

      long totalTime1 = 0;
      long totalTime2 = 0;

      // 100 nodes with 1000 edges between.
      totalTime1 = executePageRankWithAdjacentMatrix("data/graph_data_1.csv");
      totalTime2 = executePageRankWithAdjacencyList("data/graph_data_1.csv");

      writer.write("1" + "\t" + totalTime1 + "\t" + totalTime2 + "\n");

      // 500 nodes with 3000 edges between.
      totalTime1 = executePageRankWithAdjacentMatrix("data/graph_data_2.csv");
      totalTime2 = executePageRankWithAdjacencyList("data/graph_data_2.csv");

      writer.write("2" + "\t" + totalTime1 + "\t" + totalTime2 + "\n");


      // 1000 nodes with 5000 edges between.
      totalTime1 = executePageRankWithAdjacentMatrix("data/graph_data_3.csv");
      totalTime2 = executePageRankWithAdjacencyList("data/graph_data_3.csv");

      writer.write("3" + "\t" + totalTime1 + "\t" + totalTime2 + "\n");


      // 1500 nodes with 10000 edges between.
      totalTime1 = executePageRankWithAdjacentMatrix("data/graph_data_6.csv");
      totalTime2 = executePageRankWithAdjacencyList("data/graph_data_6.csv");

      writer.write("4" + "\t" + totalTime1 + "\t" + totalTime2 + "\n");

      // 1750 nodes with 10000 edges between.
      totalTime1 = executePageRankWithAdjacentMatrix("data/graph_data_7.csv");
      totalTime2 = executePageRankWithAdjacencyList("data/graph_data_7.csv");

      writer.write("5" + "\t" + totalTime1 + "\t" + totalTime2 + "\n");


      // 1800 nodes with 20000 edges between.
      totalTime1 = executePageRankWithAdjacentMatrix("data/graph_data_8.csv");
      totalTime2 = executePageRankWithAdjacencyList("data/graph_data_8.csv");

      writer.write("6" + "\t" + totalTime1 + "\t" + totalTime2 + "\n");

      // 1800 nodes with 25000 edges between.
      totalTime1 = executePageRankWithAdjacentMatrix("data/graph_data_9.csv");
      totalTime2 = executePageRankWithAdjacencyList("data/graph_data_9.csv");

      writer.write("7" + "\t" + totalTime1 + "\t" + totalTime2 + "\n");

      // 1800 nodes with 50000 edges between.
      totalTime1 = executePageRankWithAdjacentMatrix("data/graph_data_10.csv");
      totalTime2 = executePageRankWithAdjacencyList("data/graph_data_10.csv");

      writer.write("8" + "\t" + totalTime1 + "\t" + totalTime2 + "\n");

      writer.close();
      System.out.println("Data written to " + fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  /**
   * Executes the PageRank algorithm using an adjacency matrix representation of the graph.
   *
   * @param filename The name of the file containing the graph data.
   * @return The time taken to execute the algorithm in milliseconds.
   * @throws IOException if there is an error reading the file.
   */
  private static long executePageRankWithAdjacentMatrix(String filename) throws IOException {
    long startTime = System.currentTimeMillis();
    DataGenerator dataGenerator = new DataGenerator();
    int numOfVertices = dataGenerator.numOfVertices(filename);
    AdjacencyMatrix<Integer> matrix = new AdjacencyMatrix<>(numOfVertices);
    Graph<Integer> graph = dataGenerator.generateGraph(matrix, filename);
    Set<Integer> vertices = dataGenerator.getVertices();
    matrix.setVertices(vertices);
    pagerank.algorithms.PageRank<Integer> pageRank = new PageRank<>(graph, graph.getNumNodes());
    pageRank.calculatePageRank();
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  /**
   * Executes the PageRank algorithm using an adjacency list representation of the graph.
   *
   * @param filename The name of the file containing the graph data.
   * @return The time taken to execute the algorithm in milliseconds.
   * @throws IOException if there is an error reading the file.
   */
  private static long executePageRankWithAdjacencyList(String filename) throws IOException {
    long startTime = System.currentTimeMillis();
    DataGenerator dataGenerator = new DataGenerator();
    Graph<Integer> graph = dataGenerator.generateGraph(new AdjacencyListGraph<>(), filename);
    System.out.println("Number of Vertices: " + graph.getVertices().size());
    PageRank<Integer> pageRank = new PageRank<>(graph, graph.getNumNodes());
    pageRank.calculatePageRank();
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }
}
