package pagerank.util;

import pagerank.datastructure.graph.Graph;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DataGenerator {
  private FileReader fileReader;

  private Set<Integer> vertices;


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

  public Set<Integer> getVertices(){
    return vertices;
  }

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
