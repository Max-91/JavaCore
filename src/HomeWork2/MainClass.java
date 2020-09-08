package HomeWork2;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        invertArray();
        System.out.println();
        fillArray();
        System.out.println();
        changeArray();
        System.out.println();
        fillDiagonal();
        System.out.println();
        FindMinMax();
        System.out.println();
        int[] w = {10,7,2,1};
        System.out.println(checkBalance(w));
        System.out.println();
        int[] arr2 = {1,2,3,4,5,6,7};
        shiftArr(arr2,9);
    }

    // Задание 1.Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void invertArray() {
        int[] arr = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " "); // Для проверки результата отобразить в консоле
        }
    }

    // Задание 2.   Задать пустой целочисленный массив размером 8. С помощью цикла
    // заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void fillArray() {
        int[] arr = new int[8];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 3;
            System.out.print(arr[i] + " "); // Для проверки результата отобразить в консоле
        }
    }

    // Задание 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void changeArray() {
        int[] w = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < w.length; i++) {
            if (w[i] < 6) {
                w[i] *= 2;
            }
            System.out.print(w[i] + " "); // Для проверки результата отобразить в консоле
        }
    }

    // Задание 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fillDiagonal() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || i + j == arr.length - 1) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " "); // Для проверки результата отобразить в консоле
            }
            System.out.println();
        }
    }

    // Задание 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void FindMinMax() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) { // Заполнение случайными числами
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " "); // Для проверки результата отобразить в консоле
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) { //Поиск минимального и максимального значения
            if (min < arr[i]) {
                min = arr[i];
            }
            if (max > arr[i]) {
                max = arr[i];
            }

        }
        System.out.printf(" макс= %d, мин= %d", min, max);
    }

    // Задание 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] arr) {
        int sum1;
        int sum2;
        for (int i = 0; i < arr.length; i++) {
            sum1=0;
            sum2=0;
            for (int j = 0; j < i; j++) {
                sum1+=arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                sum2+=arr[j];
            }
            if (sum1==sum2) return true;
        }
        return false;
    }
    // Задание 7. **** Написать метод, которому на вход подается одномерный массив
    // и число n (может быть положительным, или отрицательным), при этом метод
    // должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону
    // сдвиг можете выбирать сами.
    public static void shiftArr(int[] arr,int n) {
        System.out.print("Было ");
        for (int i = 0; i < arr.length; i++) { // Отобразить для проверки
            System.out.print(arr[i] + " "); // Для проверки результата отобразить в консоле
        }
        if (n==0) {
            return;
        }
        // Смещение вправо
        if (n>0) {
            for (int i = 0; i < n; i++) { // Кол-во смещений
                int last=arr[arr.length-1];// Сохранение в памяти последнего элемента
                for (int j = arr.length-1; j > 0 ; j--) { // Элементы массива
                    arr[j]=arr[j-1];
                }
                arr[0]=last;
            }
        }
        else
        // Смещение влево
        {
            n=n*(-1);
            for (int i = 0; i < n; i++) { // Кол-во смещений
                int first=arr[0]; // Сохранение в памяти первого элемента
                for (int j = 0; j < arr.length-1 ; j++) { // Элементы массива
                    arr[j]=arr[j+1];
                }
                arr[arr.length-1]=first;
            }
        }
        System.out.print(" стало ");
        for (int i = 0; i < arr.length; i++) { // Отобразить для проверки
            System.out.print(arr[i] + " "); // Для проверки результата отобразить в консоле
        }
    }


