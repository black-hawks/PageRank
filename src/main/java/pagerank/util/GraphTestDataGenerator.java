package pagerank.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GraphTestDataGenerator {

    private static final int NUM_ROWS = 3000;
    private static final int MAX_VALUE = 500;

    public static void main(String[] args) {
        String fileName = "graph_data.csv";
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