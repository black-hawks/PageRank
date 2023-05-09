package pagerank.datastructure.graph;

import pagerank.algorithms.PageRank;
import pagerank.algorithms.PageRankResult;
import pagerank.util.DataGenerator;

import java.util.Map;

public class Main {

  public static void main(String[] args) throws Exception {

    DataGenerator dataGenerator = new DataGenerator();
    long start = System.nanoTime();
    Graph<Integer> graph = dataGenerator.generateGraph(new AdjacencyListGraph<>());

    long end = System.nanoTime();

//    Graph<Integer> graph = new AdjacencyListGraph<>();

//    graph.addEdge(1, 2);
//    graph.addEdge(1, 3);
//    graph.addEdge(2, 1);
//    graph.addEdge(2, 3);
//    graph.addEdge(3, 1);
//    graph.addEdge(3, 2);
//    graph.addEdge(3, 4);
//    graph.addEdge(4, 3);
//    graph.addEdge(4, 3);

    System.out.println("Number of Nodes present in the Graph : " + graph.getNumNodes());

    System.out.println("Time taken to generate the Graph " + (end - start) / 1_000_000_000.0);


    // Calculate the PageRank for each node
    PageRank<Integer> pageRank = new PageRank<>(graph, graph.getNumNodes());

    start = System.nanoTime();
    PageRankResult<Integer> pageRankResult = pageRank.calculatePageRank();
    Map<Integer, Double> pageRankValues = pageRankResult.getPageRankList();

    end = System.nanoTime();

    System.out.println("Time taken to calculate  Page Rank " + (end - start) / 1_000_000_000.0);

//    CsvFileHandler.csvWriter("Output.csv", pageRankValues);

//    CsvFileHandler.csvReader("Output.csv");

//        CycleCount.isCyclic(graph);
    int i = 0;
//         Print the PageRank values for each node
    for (Map.Entry<Integer, Double> entry : pageRankValues.entrySet()) {
      System.out.println(entry.getKey() + " : value " + entry.getValue());
      i++;
      if (i > 10) {
        break;
      }
    }
    System.out.println(pageRankResult.getConvergence());
  }
}

