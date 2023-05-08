package pagerank.util;

import pagerank.datastructure.Graph;
import pagerank.datastructure.adjacentList.Node;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataGenerator {
  private final FileReader fileReader;

  public DataGenerator() throws FileNotFoundException {
    this.fileReader = new FileReader("web-Google.txt", "\t");
  }

  public Graph<Node> generateGraph(Graph<Node> graph) throws IOException {
    String[] line;
    while ((line = this.fileReader.readLine()) != null) {
      Node node1 = new Node(Integer.parseInt(line[0]));
      Node node2 = new Node(Integer.parseInt(line[1]));
      graph.addEdge(node1, node2);
    }

    return graph;
  }
}
