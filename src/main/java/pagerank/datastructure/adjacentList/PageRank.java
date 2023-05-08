package pagerank.datastructure.adjacentList;

import java.util.*;

public class PageRank {
    //damping Factor of PageRank Algorithm
    private static final double DAMPING_FACTOR = 0.85;

    //represents the convergence threshold for the PageRank algorithm
    private static final double EPSILON = 0.0001;

    private Map<Node, List<Node>> graph;
    private int numNodes;

    public PageRank(Map<Node, List<Node>> graph, int numNodes) {
        this.graph = graph;
        this.numNodes = numNodes;
    }

    public Set<Node> calculatePageRank() {

        //Initializing the Keyset
        for(Node key : graph.keySet()){
            key.setCurrentRank(1.0 / numNodes);
            key.setPreviousRank(1.0 / numNodes);
        }

        boolean hasConverged = false;

        int i = 1;

        while (i< 5 && !hasConverged) {

            double danglingRank = 0.0;

            // Calculate the PageRank for each node in the graph
            for(Node node : graph.keySet()) {

                List<Node> neighbors = graph.get(node);
                if (neighbors == null || neighbors.isEmpty()) {
                    danglingRank += node.getCurrentRank();
                } else {
                    double neighborRankSum = 0.0;
                    for (Node neighbor : neighbors) {
                        if(neighbor != null){
                            if( graph.get(neighbor).size() == 0 ) {
                                continue;
                            }
                            neighborRankSum += neighbor.getCurrentRank() / graph.get(neighbor).size();
                        }
                    }
                    node.setCurrentRank(((1 - DAMPING_FACTOR) / numNodes) + (DAMPING_FACTOR * neighborRankSum));
                }
            }

            // Handle nodes with no outgoing links (dangling nodes)
            danglingRank *= DAMPING_FACTOR / numNodes;
            for (Node key: graph.keySet()) {
                if(graph.get(key).size() == 0){
                    key.setCurrentRank((1 - DAMPING_FACTOR) / numNodes + danglingRank);
                }
            }

            // Check for convergence
            hasConverged = true;
            for (Node node: graph.keySet()) {
                if (Math.abs(node.getCurrentRank() - node.getPreviousRank()) > EPSILON) {
                    hasConverged = false;
                    break;
                }
            }


            for (Node node: graph.keySet()) {
                node.setPreviousRank(node.getCurrentRank());
            }

            i++;
        }

        return graph.keySet();
    }

}


// Perform iterative PageRank calculations until convergence
//        boolean hasConverged = false;
//        int i = 0;
//        while (i < 5) {
//            Set<Node> oldPageRank = graph.keySet();
//            double danglingRank = 0.0;
//
//            // Calculate the PageRank for each node in the graph
//            for(Node node : graph.keySet()) {
//
//                List<Node> neighbors = graph.get(node);
//                if (neighbors == null || neighbors.isEmpty()) {
//                        danglingRank += node.getRank();
//                } else {
//                    double neighborRankSum = 0.0;
//                    for (Node neighbor : neighbors) {
//                            neighborRankSum += neighbor.getRank() / graph.get(neighbor).size();
//                    }
//                    node.setRank((1 - DAMPING_FACTOR) / numNodes + DAMPING_FACTOR * neighborRankSum);
//                }
//            }
//
//            // Handle nodes with no outgoing links (dangling nodes)
//            danglingRank *= DAMPING_FACTOR / numNodes;
////            for (int i = 1; i <= numNodes; i++) {
////                if (!newPageRank.containsKey(i)) {
////                    newPageRank.put(i, (1 - DAMPING_FACTOR) / numNodes + danglingRank);
////                }
////            }
//
//            for (Node key: graph.keySet()) {
//                if(graph.get(key).size() == 0){
//                    key.setRank((1 - DAMPING_FACTOR) / numNodes + danglingRank);
//                }
//            }
//
//            // Check for convergence
////            hasConverged = true;
////            for (Node node: oldPageRank) {
////                if (Math.abs(graph.get( - node.getRank() > EPSILON) {
////                    hasConverged = false;
////                    break;
////                }
////            }
////
////            pageRank = newPageRank;
//
//            i++;
//        }

