package HomeWork4;

import java.util.Random;
import java.util.Scanner;

public class MainClass {
    // Задание
    // 1. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
    //2. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
    //3. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
    static final int SIZE = 6; // Размер поля
    static final int DOT_TO_WIN = 4; // Кол-во фишек для выиграша

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (newCheckWin(DOT_X)) {
                System.out.println("Вы победили! Поздравляем!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (newCheckWin(DOT_O)) {
                System.out.println("Компьютер победил.");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }

    }

    public static void initMap() { // Создания поля
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() { // Отображение поля
        System.out.print("  ");
        for (int i = 1; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() { // Запрос у пользователя куда поставвить крестик
        int x;
        int y;

        do {
            System.out.println("input X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) { // Проверка пустое ли поле по координатам
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
//        if (map[y][x] == DOT_EMPTY) {
//            return true;
//        } else {
//            return false;
//        }
    }

    public static void aiTurn() { // Ход ПК
        int x;
        int y;
        // Выполнение блокировки
        if (blockUser()) {
            return;
        }
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }

    public static boolean isFull() { // Проверка все ли поля заняты
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char c) { // Проверка есть ли победа (старая версия)
        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) {
            return true;
        }
        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) {
            return true;
        }
        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) {
            return true;
        }

        if (map[0][0] == c && map[1][0] == c && map[2][0] == c) {
            return true;
        }
        if (map[0][1] == c && map[1][1] == c && map[2][1] == c) {
            return true;
        }
        if (map[0][2] == c && map[1][2] == c && map[2][2] == c) {
            return true;
        }

        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {
            return true;
        }

        return false;
    }

    public static boolean newCheckWin(char c) { // Проверка есть ли победа
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (checkCell(y, x, c)) { // Проверка ячейка
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cellExist(int y, int x) { // Проверка существует ли ячейка с таким номером (или координаты вне поля)
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return true;
    }

    public static boolean checkCell(int y, int x, char c) { // Проверка есть ли в данной клетке выиграшная комбинация
        boolean winH = true;
        boolean winV = true;
        boolean winD1 = true;
        boolean winD2 = true;

        for (int i = 0; i < DOT_TO_WIN; i++) {
            // Проверка по горизонтали
            if (cellExist(y, x + i)) {
                if (map[y][x + i] != c) {
                    winH = false;
                }
            } else {
                winH = false;
            }
            // Проверка по вертикали
            if (cellExist(y + i, x)) {
                if (map[y + i][x] != c) {
                    winV = false;
                }
            } else {
                winV = false;
            }
            // Проверка по диагонали вверх
            if (cellExist(y - i, x + i)) {
                if (map[y - i][x + i] != c) {
                    winD1 = false;
                }
            } else {
                winD1 = false;
            }
            // Проверка по диагонали вниз
            if (cellExist(y + i, x + i)) {
                if (map[y + i][x + i] != c) {
                    winD2 = false;
                }
            } else {
                winD2 = false;
            }
        }
        return winH || winV || winD1 || winD2;
    }

    public static boolean blockUser() { // Установка 0 для блокировки победы пользователя
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (isCellValid(y, x)) { // Проверка ячейки
                    map[y][x] = DOT_X; // Временно устанавливаем Х (как будто пользователь походил)
                    if (newCheckWin(DOT_X)) {
                        map[y][x] = DOT_O; // Устанавливаем О
                        return true;
                    } else {
                        map[y][x] = DOT_EMPTY; // Убираем временный Х
                    }
                }

            }
        }
        return false;
    }
}
