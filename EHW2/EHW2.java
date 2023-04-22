package EHW2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EHW2 {

    /* Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение.
    Ввод текста вместо числа не должно приводить к падению приложения,
    вместо этого, необходимо повторно запросить у пользователя ввод данных. */
    public static float scanFloat() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter float number: ");
            float inputFloat = scanner.nextFloat();
            scanner.close();
            return inputFloat;
        } catch (InputMismatchException e) {
            System.out.println("Only float numbers allowed!");
            return scanFloat();
        }
    }

    // Задание 2
    public static void divMethod(int[] intArray, int d) {
        try {
            int catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (NullPointerException | ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e.getClass().getSimpleName());
        }
    }

    // Задание 3
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static String inputString() {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.println("Enter your string:");
                String input = scanner.nextLine();
                if (input.equals("")) {
                    throw new NullPointerException();
                } else return input;
            } catch (NullPointerException e) {
                System.out.println("Empty strings aren't allowed!");
                return inputString();
            }
        }
    }
}