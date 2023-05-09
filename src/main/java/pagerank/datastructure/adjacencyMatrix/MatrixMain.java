package pagerank.datastructure.adjacencyMatrix;

import pagerank.algorithms.PageRankResult;
import pagerank.datastructure.adjacentList.Node;

import pagerank.util.CsvFileHandler;
import pagerank.util.DataGenerator;

import java.io.FileNotFoundException;
import java.util.List;

public class MatrixMain {

    public static void main(String[] args) throws Exception {
        DataGenerator dataGenerator = new DataGenerator();

        int numOfVertices = dataGenerator.numOfVertices();

        AdjacencyMatrix matrix = new AdjacencyMatrix(numOfVertices);
        long start = System.nanoTime();
        dataGenerator.generateAdjacencyMatrixGraph(matrix);
        long end = System.nanoTime();

        // Calculate the PageRank for each node
        PageRank pageRank = new PageRank(matrix);

        start = System.nanoTime();
        List<Double> convergance = pageRank.calculatePageRank();


        end = System.nanoTime();

        System.out.println("Time taken to calculate  Page Rank " + (end - start)/ 1_000_000_000.0);

//        CsvFileHandler.csvWriter("Output.csv", pageRankValues);
//
//        CsvFileHandler.csvReader("Output.csv");

//        CycleCount.isCyclic(graph);

//         Print the PageRank values for each node
        for (int i=0;i<10;i++) {
            System.out.println(i+ " : value " + matrix.getCurrentRanks().get(i));
        }


//        System.out.println(pageRankResult.getConvergence());
    }


}
