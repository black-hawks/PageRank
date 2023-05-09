package pagerank.datastructure.adjacentList;

import pagerank.algorithms.CycleCount;
import pagerank.datastructure.Graph;
import pagerank.util.CsvFileHandler;
import pagerank.util.DataGenerator;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {

        DataGenerator dataGenerator = new DataGenerator();

        long start = System.nanoTime();
        Graph<Node> graph = dataGenerator.generateGraph(new AdjacencyListGraph<>());

        long end = System.nanoTime();

//        for(Map.Entry<Node, List<Node>> list : ((AdjacencyListGraph<Node>) graph).getAdjacencyList().entrySet()){
//            System.out.println("Vertex : " + list.getKey());
//        }
//        Graph<Node> graph = new AdjacencyListGraph<>();
//
//        Node node1 = new Node(0.0,1);
//        Node node2 = new Node(0.0,3);
//        Node node3 = new Node(0.0,4);
//        Node node4 = new Node(0.0,5);
//        Node node5 = new Node(0.0,6);
//
//        graph.addEdge(node1, node2);
//        graph.addEdge(node1, node3);
//        graph.addEdge(node2, node1);
//        graph.addEdge(node2, node3);
//        graph.addEdge(node3, node1);
//        graph.addEdge(node3, node2);
//        graph.addEdge(node3, node4);
//        graph.addEdge(node4, node3);
//        graph.addEdge(node4, node3);

        System.out.println("Number of Nodes present in the Graph : " + graph.getNumNodes());

        System.out.println("Time taken to generate the Graph " + (double)(end - start)/ 1_000_000_000.0);


        // Calculate the PageRank for each node
        PageRank pageRank = new PageRank(graph, graph.getNumNodes());

        start = System.nanoTime();
        List<Node> pageRankValues = pageRank.calculatePageRank();

        end = System.nanoTime();

        System.out.println("Time taken to calculate  Page Rank " + (double)(end - start)/ 1_000_000_000.0);

        CsvFileHandler.csvWriter("Output.csv", pageRankValues);

        CsvFileHandler.csvReader("Output.csv");

//        CycleCount.isCyclic(graph);
    }
}

