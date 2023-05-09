package pagerank.datastructure.adjacencyMatrix;

import pagerank.datastructure.adjacentList.Node;
import pagerank.datastructure.adjacentList.PageRank;
import pagerank.util.DataGenerator;

import java.io.FileNotFoundException;
import java.util.List;

public class MatrixMain {

    public static void main(String[] args) throws Exception {
        DataGenerator dataGenerator = new DataGenerator();

        int numOfVertices = dataGenerator.numOfVertices();

        AdjacencyMatrix matrix = new AdjacencyMatrix(numOfVertices);

        dataGenerator.generateAdjacencyMatrixGraph(matrix);

        PageRank pageRank = new PageRank(graph, graph.getNumNodes());
        List<Node> pageRankValues = pageRank.calculatePageRank();

    }
}
