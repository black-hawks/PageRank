package pagerank.expriments;

import pagerank.algorithms.PageRank;
import pagerank.algorithms.PageRankResult;
import pagerank.datastructure.adjacencyMatrix.AdjacencyMatrix;
import pagerank.datastructure.graph.Graph;
import pagerank.util.DataGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExperimentWithMatrix {

    public static void main(String[] args) throws IOException {
        DataGenerator dataGenerator = new DataGenerator();
        int numOfVertices = dataGenerator.numOfVertices("graph_data.csv");
        AdjacencyMatrix matrix = new AdjacencyMatrix(numOfVertices);
        Graph<Integer> graph = dataGenerator.generateGraph(matrix, "graph_data.csv");
        Set<Integer> vertices = dataGenerator.getVertices();
        matrix.setVertices(vertices);
        PageRank<Integer> pageRank = new PageRank<>(graph, graph.getNumNodes());
        PageRankResult<Integer> pageRankResult = pageRank.calculatePageRank();
        System.out.println();
        printTopTenPages(pageRankResult.getPageRankList());
        printConvergenceTimeline(pageRankResult.getConvergence());
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

    private static void printConvergenceTimeline(List<Double> convergence) {
        System.out.println("Convergence Timeline:");
        int index = 1;
        for (Double difference : convergence) {
            System.out.println("Iteration " + (index++) + ": " + difference);
        }
        System.out.println();
    }
}