package pagerank.datastructure.adjacencyMatrix;

import java.util.*;

public class AdjacencyMatrix {
//    Node[][] matrix;
//    int numVertices;

    int[][] matrix;
    ArrayList<Double> currentRanks;
    ArrayList<Double> previousRanks;
    int numOfVertices;

    public AdjacencyMatrix(int numOfVertices){
        this.numOfVertices = numOfVertices;
        matrix = new int[numOfVertices][numOfVertices];
        for (int[] row: matrix) {
            Arrays.fill(row, 0);
        }
        currentRanks = new ArrayList<Double>(numOfVertices);
        previousRanks = new ArrayList<Double>(numOfVertices);
        Collections.fill(previousRanks,(1.0 / numOfVertices));
        Collections.fill(currentRanks,(1.0 / numOfVertices));
    }


    public void addEdge(int sourceVertex, int destVertex) {
        matrix[sourceVertex][destVertex]=1;
    }

}
