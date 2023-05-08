package pagerank.datastructure.adjacentList;

public class Node {

    private double currentRank;

    private double previousRank;
    private int id;

    public Node(double rank, int id) {
        this.currentRank = rank;
        this.previousRank = rank;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getCurrentRank() {
        return currentRank;
    }

    public double getPreviousRank() {
        return previousRank;
    }

    public void setCurrentRank(double currentRank) {
        this.currentRank = currentRank;
    }

    public void setPreviousRank(double previousRank) {
        this.previousRank = previousRank;
    }
}
