public class EHW1 {
    // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

    // Получим NumberFormatException, если в метод передадим строку, содержащую недопустимые символы
    public static int[] stringToIntArray(String str) {
        String[] strArray = str.split(" ");
        int[] array = new int[strArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        return array;
    }

    // При делении на 0 получим ArithmeticException
    public static int divide(int a, int b) {
        return a / b;
    }

    // Выход за пределы массива ArrayIndexOutOfBoundsException
    public static void printArray(int[] array) {
        for (int i = 0; i <= array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
    каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
    Если длины массивов не равны, необходимо как-то оповестить пользователя. */
    public static int[] difOfArrays(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            throw new RuntimeException("Arrays can't be null");
        }
        if (firstArray.length != secondArray.length) {
            throw new RuntimeException("Arrays lengths must be equal");
        }
        int[] result = new int[firstArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = firstArray[i] - secondArray[i];
        }
        return result;
    }

    /* * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
    каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
    Если длины массивов не равны, необходимо как-то оповестить пользователя.
    Важно:
    При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
     */
    public static int[] divArrays(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            throw new RuntimeException("Arrays can't be null");
        }
        if (firstArray.length != secondArray.length) {
            throw new RuntimeException("Arrays lengths must be equal");
        }
        int[] result = new int[firstArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            if (secondArray[i] == 0) {
                throw new RuntimeException("Divide by 0 isn't allowed");
            }
            result[i] = firstArray[i] / secondArray[i];
        }
        return result;
    }
}