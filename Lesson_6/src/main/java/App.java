public class App {
    public static void main(String[] args) {
        String path = "src/main/java/table.csv";
        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};
        AppData table = new AppData(header, data);
        table.save(path);
        AppData.readCSV(path);
    }
}
