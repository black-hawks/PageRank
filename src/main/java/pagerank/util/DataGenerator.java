package pagerank.util;

import pagerank.datastructure.Graph;
import pagerank.datastructure.adjacencyMatrix.AdjacencyMatrix;
import pagerank.datastructure.adjacentList.Node;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DataGenerator {
  private final FileReader fileReader;
  private Set<Integer> vertices;
  public DataGenerator() throws FileNotFoundException {
    this.fileReader = new FileReader("web-Google.txt", "\t");
  }

  public int numOfVertices() throws IOException {
    String[] line;
    vertices= new HashSet<>();
    while ((line = this.fileReader.readLine()) != null) {
      vertices.add(Integer.parseInt(line[0]));
      vertices.add(Integer.parseInt(line[1]));
    }
    return vertices.size();
  }

  public Graph<Node> generateGraph(Graph<Node> graph) throws IOException {
    String[] line;
    while ((line = this.fileReader.readLine()) != null) {
      graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
    }

    return graph;
  }

  public void generateAdjacencyMatrixGraph(AdjacencyMatrix matrix) throws IOException {
    String[] line;
    while ((line = this.fileReader.readLine()) != null) {
      matrix.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
    }

  }
}
