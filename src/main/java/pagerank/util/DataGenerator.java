package pagerank.util;

import pagerank.datastructure.graph.Graph;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * A utility class for generating data and graph for PageRank algorithm.
 */
public class DataGenerator {
  private FileReader fileReader;

  private Set<Integer> vertices;

  /**
   * Calculates the number of vertices in the given file.
   *
   * @param filename The filename of the file to be read.
   * @return The number of vertices in the given file.
   * @throws IOException if the file cannot be read.
   */
  public int numOfVertices(String filename) throws IOException {
    String[] line;
    vertices = new HashSet<>();
    this.fileReader = new FileReader(filename, "\t");
    while ((line = this.fileReader.readLine()) != null) {
      vertices.add(Integer.parseInt(line[0]) - 1);
      vertices.add(Integer.parseInt(line[1]) - 1);
    }
    this.fileReader.closeStream();
    return vertices.size();
  }

  /**
   * Returns the set of vertices generated from the given file.
   *
   * @return The set of vertices.
   */
  public Set<Integer> getVertices() {
    return vertices;
  }

  /**
   * Generates a graph from the given file using the specified graph implementation.
   *
   * @param graph    The graph implementation to use.
   * @param filename The filename of the file to be read.
   * @return The generated graph.
   * @throws IOException if the file cannot be read.
   */
  public Graph<Integer> generateGraph(Graph<Integer> graph, String filename) throws IOException {
    String[] line;
    this.fileReader = new FileReader(filename, "\t");
    while ((line = this.fileReader.readLine()) != null) {
      graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
    }
    this.fileReader.closeStream();
    return graph;
  }
}
