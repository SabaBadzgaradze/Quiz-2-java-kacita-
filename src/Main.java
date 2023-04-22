import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int[] array = new int[10];

    private Main() {
    }

    public static int[] readFile(String path) throws InvalidNumberException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String intLine;
            int index = 0;
            while ((intLine = bufferedReader.readLine()) != null && index < 10) {
                int number = Integer.parseInt(intLine);
                if (number < 0) {
                    throw new InvalidNumberException("Invalid Number " + number);
                }
                array[index++] = number;
            }
            bufferedReader.close();
        } catch (NumberFormatException | IOException e) {
            System.out.println(e);
        }
        return array;
    }

    public static int sumNumbers(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        if (sum == 0) {
            throw new ArithmeticException("Sum is zero");
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(readFile("src/numbers")));
            System.out.println(sumNumbers(array));
        } catch (ArithmeticException | InvalidNumberException e) {
            System.out.println(e);
        }
    }
}