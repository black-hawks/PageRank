package pagerank.datastructure.graph;

public class Node {

    private double rank;

    private int id;

    public Node(int id, double rank) {
        this.rank = rank;
        this.id = id;
    }

    public Node(int id) {
        this(id, 0);
    }

    public int getId() {
        return id;
    }

    public double getRank() {
        return rank;
    }


    public void setRank(double rank) {
        this.rank = rank;
    }
}
