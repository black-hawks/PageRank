package pagerank.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A utility class to read data from a file.
 */
public class FileReader {
  /**
   * The path of the file to be read
   */
  public final String filepath;
  /**
   * The delimiter used to separate fields in the file
   */
  public final String delimiter;
  /**
   * The buffered reader to read from the file
   */
  protected BufferedReader br;

  /**
   * Constructs a new FileReader with default delimiter (",").
   *
   * @param filepath the path of the CSV file to read.
   * @throws FileNotFoundException if the file at the given filepath is not found.
   */
  public FileReader(String filepath) throws FileNotFoundException {
    this(filepath, ",");
  }

  /**
   * Constructs a new FileReader with a specified delimiter.
   *
   * @param filepath  the path of the CSV file to read.
   * @param delimiter the delimiter to use for splitting the lines of the CSV file.
   * @throws FileNotFoundException if the file at the given filepath is not found.
   */
  public FileReader(String filepath, String delimiter) throws FileNotFoundException {
    this.filepath = filepath;
    this.delimiter = delimiter;
    br = new BufferedReader(new java.io.FileReader(filepath));
  }

  /**
   * Reads a single line from the CSV file and returns the elements as an array of String.
   *
   * @return an array of String elements, where each element corresponds to a field in the CSV file.
   * @throws IOException if an I/O error occurs.
   */
  public String[] readLine() throws IOException {
    String line = br.readLine();
    if (line == null) {
      return null;
    }
    return line.split(delimiter);
  }

  /**
   * Closes the stream associated with this FileReader.
   *
   * @throws IOException if an I/O error occurs.
   */
  public void closeStream() throws IOException {
    br.close();
  }
}
