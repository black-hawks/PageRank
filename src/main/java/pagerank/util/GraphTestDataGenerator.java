package pagerank.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * A utility class for generating random test data for graph algorithms.
 */
public class GraphTestDataGenerator {
  /**
   * The number of rows to generate for the test data.
   */
  private static final int NUM_ROWS = 50000;

  /**
   * The maximum value for each edge in the test data.
   */
  private static final int MAX_VALUE = 1800;

  /**
   * Generates a CSV file containing random source-destination pairs for a graph.
   *
   * @param args The command line arguments. Not used.
   */
  public static void main(String[] args) {
    String fileName = "graph_data_10.csv";
    try {
      FileWriter writer = new FileWriter(fileName);

      Random rand = new Random();
      for (int i = 0; i < NUM_ROWS; i++) {
        int src = rand.nextInt(MAX_VALUE) + 1;
        int dest = rand.nextInt(MAX_VALUE) + 1;
        writer.write(src + "\t" + dest + "\n");
      }

      writer.close();
      System.out.println("Data written to " + fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
