import java.util.Scanner;

public class LES1 {
    public static void main(String[] args) {
        int[][] twoDimArray = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(sum(twoDimArray));
    }
/* Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
    Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
3. если вместо массива пришел null, метод вернет -3
4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок. */

    public static int findValueIndex(int[] array, int value) {
        if (array == null) {
            return -3;
        }
        if (array.length < 2) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -2;
    }
/* Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод запросит искомое число у
пользователя, вызовет первый, обработает возвращенное значение и покажет читаемый результат пользователю.
Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”. */

    public static int findIndex(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value: ");
        int value = scanner.nextInt();
        if (findValueIndex(array, value) == -3) {
            throw new RuntimeException("Array is null");
        } else if (findValueIndex(array, value) == -1) {
            throw new RuntimeException("Arrays length < 2");
        } else if (findValueIndex(array, value) == -2) {
            throw new RuntimeException("Value not found");
        } else return findValueIndex(array, value);
    }

/*Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
(кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.*/

    public static int sum(int[][] array) {
        if (array == null) {
            throw new RuntimeException("Array is null");
        }
        if (array.length != array[0].length) {
            throw new RuntimeException("Only square arrays are allowed");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] < 0 || array[i][j] > 1) {
                    throw new RuntimeException("Only 0 or 1 allowed in array");
                }
                sum = sum + array[i][j];
            }
        }
        return sum;
    }
}