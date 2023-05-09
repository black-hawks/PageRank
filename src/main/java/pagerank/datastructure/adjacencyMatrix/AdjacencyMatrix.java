package pagerank.datastructure.adjacencyMatrix;

import java.util.*;

public class AdjacencyMatrix {
//    Node[][] matrix;
//    int numVertices;

    long[][] matrix;
    double[] currentRanks;
    double[] previousRanks;
    int numOfVertices;

    public AdjacencyMatrix(int numOfVertices){
        this.numOfVertices = numOfVertices;
        matrix = new long[numOfVertices][numOfVertices];
        for (long[] row: matrix) {
            Arrays.fill(row, 0);
        }
        currentRanks = new double[numOfVertices];
        previousRanks = new double[numOfVertices];
        Arrays.fill(previousRanks,(1.0 / numOfVertices));
        Arrays.fill(currentRanks,(1.0 / numOfVertices));
    }


    public void addEdge(int sourceVertex, int destVertex) {
        matrix[sourceVertex][destVertex]=1;
    }

    public long[][] getMatrix(){
        return matrix;
    }

    public double[] getCurrentRanks(){
        return currentRanks;
    }

    public double[] getPreviousRanks(){
        return previousRanks;
    }

}
