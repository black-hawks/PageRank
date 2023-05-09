package pagerank.datastructure.adjacencyMatrix;

import pagerank.datastructure.graph.Graph;

import java.util.*;

public class AdjacencyMatrix<T> implements Graph<T> {
//    Node[][] matrix;
//    int numVertices;

    int[][] matrix;

    int numOfVertices;

    List<T> vertices;

    public AdjacencyMatrix(int numOfVertices){
        this.numOfVertices = numOfVertices;
        matrix = new int[numOfVertices][numOfVertices];
        for (int[] row: matrix) {
            Arrays.fill(row, 0);
        }
    }




    public int[][] getMatrix(){
        return matrix;
    }


    @Override
    public void addEdge(T node1, T node2) {
        if(node1 instanceof Integer && node2 instanceof Integer){
            matrix[((int) node1)-1][((int) node2)-1]=1;
        }


    }

    @Override
    public int getNumNodes() {
        return numOfVertices;
    }

    @Override
    public List<T> getNeighbors(T node) {
        if(node instanceof Integer) {
          return  getOutDegree((int) node);
        }
        return null;
    }

    @Override
    public List<T> getVertices() {

        return this.vertices;
    }

    public void setVertices(Set<Integer> vertices){
        this.vertices = new ArrayList<>();
        for(Integer x : vertices){
            this.vertices.add((T)x);
        }

    }

    @Override
    public List<T> getEdges(T node) {
        if(node instanceof Integer) {
            return getOutDegree((int) node);
        }
        return null;
    }

    public List<T> getOutDegree(int vertex) {
        List<T> neighbours = new ArrayList<>();
        for (int i = 0; i <= matrix[vertex].length-1; i++) {
            if(matrix[vertex][i]==1){
                neighbours.add((T)Integer.valueOf(i));
            }
        }
        return neighbours;
    }

    public boolean hasNeighbours(int vertex) {
        return getOutDegree(vertex).size() == 0? false:true;
    }
}
