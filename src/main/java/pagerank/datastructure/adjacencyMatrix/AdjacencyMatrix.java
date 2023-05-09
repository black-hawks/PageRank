package pagerank.datastructure.adjacencyMatrix;

import java.util.*;

public class AdjacencyMatrix {
//    Node[][] matrix;
//    int numVertices;

    long[][] matrix;
    ArrayList<Double> currentRanks;
    ArrayList<Double> previousRanks;
    int numOfVertices;

    public AdjacencyMatrix(int numOfVertices){
        this.numOfVertices = numOfVertices;
        matrix = new long[numOfVertices][numOfVertices];
        for (long[] row: matrix) {
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

    public long[][] getMatrix(){
        return matrix;
    }

    public ArrayList<Double> getCurrentRanks(){
        return currentRanks;
    }

    public ArrayList<Double> getPreviousRanks(){
        return previousRanks;
    }

}
