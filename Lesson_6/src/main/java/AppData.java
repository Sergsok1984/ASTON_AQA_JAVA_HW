import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AppData {
    private final String[] header;
    private final int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public static void readCSV(String path) {
        String str;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((str = reader.readLine()) != null) {
                String[] row = str.split(";");
                System.out.println(Arrays.toString(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String path) {
        try (FileOutputStream file = new FileOutputStream(path)) {
            for (int row = 0; row < this.getData().length + 1; row++) {
                for (int column = 0; column < this.getHeader().length; column++) {
                    String[][] table = this.toCSVTable();
                    file.write(table[row][column].getBytes());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[][] toCSVTable() {
        String[][] table = new String[data.length + 1][header.length];
        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[0].length; column++) {
                String delimiter = column == table[0].length - 1 ? "\n" : ";";
                if (row == 0) {
                    table[row][column] = header[column] + delimiter;
                } else {
                    table[row][column] = data[row - 1][column] + delimiter;
                }
            }
        }
        return table;
    }
}
