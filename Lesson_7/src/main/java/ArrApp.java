import exception.MyArrayDataException;
import exception.MyArraySizeException;

public class ArrApp {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "П"}
        };
        try {
            int result = sumArr(arr);
            System.out.println("Сумма элементов массива " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }


    public static int sumArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int rows = arr.length;
        int columns = arr[0].length;
        int sum = 0;
        if (rows != 4 || columns != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4х4");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке с индексами: [" + i + "][" + j + "] ");
                }
            }
        }
        return sum;
    }
}
