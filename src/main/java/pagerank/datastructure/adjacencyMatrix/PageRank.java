package pagerank.datastructure.adjacencyMatrix;

import pagerank.algorithms.PageRankResult;
import pagerank.datastructure.Graph;
import pagerank.datastructure.adjacentList.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageRank {

    //damping Factor of PageRank Algorithm
    private static final double DAMPING_FACTOR = 0.85;

    //represents the convergence threshold for the PageRank algorithm
    private static final double EPSILON = 0.0001;

    private long[][] matrix;
    private int numOfVertices;

    ArrayList<Double> currentRanks;
    ArrayList<Double> previousRanks;

    public PageRank(AdjacencyMatrix matrix) {
        this.matrix = matrix.getMatrix();
        this.numOfVertices =this.matrix[0].length;
        currentRanks = matrix.getCurrentRanks();
        previousRanks = matrix.getPreviousRanks();
        Collections.fill(previousRanks,(1.0 / numOfVertices));
        Collections.fill(currentRanks,(1.0 / numOfVertices));
    }

    public List<Double> calculatePageRank() {
        List<Double> convergenceList = new ArrayList<>();
        double epsilonThreshold = EPSILON / numOfVertices;
        System.out.println(epsilonThreshold);
        System.out.println(numOfVertices);


        boolean hasConverged = false, hasNeighbour = false;

        int i = 1;

        while (i < 100 && !hasConverged) {

            System.out.println("Iteration " + i);
            double danglingRank = 0.0;

            for(int row=0;row<matrix.length;row++){
                if(!hasNeighbours(row)){
                    danglingRank += currentRanks.get(row);
                }else{
                    double neighborRankSum = 0.0;
                    for(int col=0;col<matrix[row].length;col++){
                        if(matrix[row][col]!=0){
                            int getNeighbourCount= getOutDegree(col);
                            if(getNeighbourCount ==0){
                                continue;
                            }
                            neighborRankSum += currentRanks.get(col) / getNeighbourCount;
                        }
                    }
                    currentRanks.set(row,((1 - DAMPING_FACTOR) / numOfVertices) + (DAMPING_FACTOR * neighborRankSum));

                }

            }
            // Handle nodes with no outgoing links (dangling nodes)
            danglingRank *= DAMPING_FACTOR / numOfVertices;
            for (int row=0;row<matrix.length;row++) {
                if (getOutDegree(row) == 0) {
                    currentRanks.set(row,(1 - DAMPING_FACTOR) / numOfVertices + danglingRank);
                }
            }


            // Check for convergence
            //      hasConverged = true;
            double totalDifference = 0.0;

            for (int j=0;j<numOfVertices;j++) {
                double difference = Math.abs(currentRanks.get(j)- previousRanks.get(j));
                totalDifference += difference;
            }

            double averageDifference = totalDifference / numOfVertices;
            convergenceList.add(averageDifference);
            System.out.println(averageDifference);
            if (averageDifference < epsilonThreshold) {
                hasConverged = true;
            }
            for (int j=0;j<numOfVertices;j++) {
                previousRanks.set(j, currentRanks.get(j));
            }

            i++;
        }

        return convergenceList;
    }


    public int getOutDegree(int vertex) {
        int degree = 0;
        for (int i = 0; i < matrix[vertex].length; i++) {
            if(matrix[vertex][i]==1){
                degree += 1;
            }

        }
        return degree;
    }

    public boolean hasNeighbours(int vertex) {
        return getOutDegree(vertex) == 0? false:true;
    }
}
