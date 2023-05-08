package pagerank.util;

import pagerank.datastructure.Graph;
import pagerank.datastructure.GraphImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataGenerator {
  private final FileReader fileReader;

  public DataGenerator() throws FileNotFoundException {
    this.fileReader = new FileReader("web-Google.txt", "\t");
  }

  public Graph<Integer> generateGraph() throws IOException {
    Graph<Integer> graph = new GraphImpl<>();
    String[] line;
    while ((line = this.fileReader.readLine()) != null) {
      graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
    }
    return graph;
  }
}