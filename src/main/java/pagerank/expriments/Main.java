package pagerank.expriments;

import pagerank.algorithms.CycleCount;
import pagerank.algorithms.PageRank;
import pagerank.algorithms.PageRankResult;
import pagerank.datastructure.graph.AdjacencyListGraph;
import pagerank.datastructure.graph.Graph;
import pagerank.util.DataGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    DataGenerator dataGenerator = new DataGenerator("web-Google-0.001.txt");
    Graph<Integer> graph = dataGenerator.generateGraph(new AdjacencyListGraph<>());
    System.out.println("Number of Vertices: " + graph.getVertices().size());
    PageRank<Integer> pageRank = new PageRank<>(graph, graph.getNumNodes());
    PageRankResult<Integer> pageRankResult = pageRank.calculatePageRank();
    System.out.println();
    CycleCount.isCyclic(graph);
    System.out.println();
    System.out.println("Total iterations: " + pageRankResult.getConvergence().size());
    System.out.println();
    printTopTenPages(pageRankResult.getPageRankList());
  }

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
}
