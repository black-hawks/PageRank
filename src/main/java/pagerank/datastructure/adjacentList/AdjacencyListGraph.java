package pagerank.datastructure.adjacentList;

import pagerank.datastructure.Graph;

import java.util.*;

/**
 * A class that implements the Graph interface using an adjacency list to represent the graph.
 *
 * @param <V> the type of vertices in the graph
 */
public class AdjacencyListGraph<V> implements Graph<V> {



    /**
     * The adjacency list of the graph, which stores the edges for each vertex in the form of a list of Node objects.
     */
    private Map<V, List<V>> adjacencyList ;


    public AdjacencyListGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(V node){
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    @Override
    public void addEdge(V node1, V node2) {
        if(! adjacencyList.containsKey(node1)){
            addVertex(node1);
        }
        if(! adjacencyList.containsKey(node2)){
            addVertex(node2);
        }
        adjacencyList.get(node1).add(node2);
    }

    @Override
    public int getNumNodes() {
        return adjacencyList.size();
    }

    @Override
    public List<V> getNeighbors(V node) {
        return adjacencyList.get(node);
    }

    public Set<V> getAllNodes() {
        return adjacencyList.keySet();
    }

    public void removeEdge(int node1, int node2) {
        adjacencyList.get(node1).remove(Integer.valueOf(node2));
    }

    public void removeNode(V node) {
        adjacencyList.remove(node);
        for (V neighbor : adjacencyList.keySet()) {
            adjacencyList.get(neighbor).remove(node);
        }
    }

    public Map<V, List<V>> getAdjacencyList() {
        return adjacencyList;
    }
}
