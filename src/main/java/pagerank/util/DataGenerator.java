package pagerank.util;

import pagerank.datastructure.graph.Graph;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataGenerator {
  private final FileReader fileReader;

  public DataGenerator(String filepath) throws FileNotFoundException {
    this.fileReader = new FileReader(filepath, "\t");
  }

  public Graph<Integer> generateGraph(Graph<Integer> graph) throws IOException {
    String[] line;
    while ((line = this.fileReader.readLine()) != null) {
      graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
    }

    return graph;
  }
}
