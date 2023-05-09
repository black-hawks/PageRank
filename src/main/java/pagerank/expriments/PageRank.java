package pagerank.expriments;

import pagerank.datastructure.graph.AdjacencyListGraph;
import pagerank.datastructure.graph.Graph;
import pagerank.util.DataGenerator;

import java.io.IOException;

public class PageRank {
  public static void main(String[] args) throws IOException {
    calcPageRank("web-Google-0.001.txt");
    calcPageRank("web-Google-0.005.txt");
    calcPageRank("web-Google-0.01.txt");
    calcPageRank("web-Google-0.05.txt");
    calcPageRank("web-Google-0.1.txt");
    calcPageRank("web-Google-0.5.txt");
    calcPageRank("web-Google.txt");
  }

  private static void calcPageRank(String filename) throws IOException {
    long start = System.currentTimeMillis();
    DataGenerator dataGenerator = new DataGenerator();
    Graph<Integer> graph = dataGenerator.generateGraph(new AdjacencyListGraph<>(), filename);
    pagerank.algorithms.PageRank<Integer> pageRank = new pagerank.algorithms.PageRank<>(graph, graph.getNumNodes());
    pageRank.calculatePageRank();
    System.out.println("Calculation of Page Rank for " + graph.getVertices().size() + " vertices took: " + (System.currentTimeMillis() - start) + "ms");
  }
}