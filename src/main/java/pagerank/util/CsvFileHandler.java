package pagerank.util;

import pagerank.datastructure.adjacentList.Node;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvFileHandler {

    public static void csvWriter(String filename, List<Node> pageRankValues){

        try {
            FileWriter writer = new FileWriter(filename);
            for(Node node : pageRankValues){
                String data = node.getId() + ","+ node.getCurrentRank();
                writer.write(String.join(",", data));
                writer.write("\n");
            }

            writer.close();
            System.out.println("Data written to the file.");

//            ExternalMergeSort externalMergeSort = new ExternalMergeSort();
//            externalMergeSort.sort(filename, "InputFile.csv");
//            System.out.println("CSV file created successfully.");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static  void csvReader(String filename){
//        String csvFile = "DataFile.csv";
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
