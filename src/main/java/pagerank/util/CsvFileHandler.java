package pagerank.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileHandler {

  public static void csvWriter(String filename, Map<Integer, Double> pageRankValues) {

    try {
      FileWriter writer = new FileWriter(filename);
      for (Map.Entry<Integer, Double> entry : pageRankValues.entrySet()) {
        String data = entry.getKey() + "\t" + entry.getValue();
        writer.write(data);
        writer.write("\n");
      }

      writer.close();
      System.out.println("Data written to the file.");


    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void csvReader(String filename) {
    String line = "";
    String csvDelimiter = ",";
    int rowCount = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

      // Read the first 10 rows of the CSV file
      while ((line = br.readLine()) != null && rowCount < 10) {

        // Split the CSV row into columns
        String[] row = line.split(csvDelimiter);

        // Print each column in the row
        for (String column : row) {
          System.out.print(column + "\t");
        }
        System.out.println();

        rowCount++;
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
