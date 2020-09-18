package HomeWork8;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    static int SIZE = 3; // Размер поля - записывается в SettingWindow
    static int DOT_TO_WIN = 3; // Кол-во фишек для выиграша

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static boolean isFinished;

    private static void go() {
        isFinished = true;
        if (checkWin(DOT_X)) {
            System.out.println("Вы победили! Поздравляем!");
            return;
        }
        if (isFull()) {
            System.out.println("Ничья");
            return;
        }

        aiTurn();
        if (checkWin(DOT_O)) {
            System.out.println("Компьютер победил.");
            return;
        }
        if (isFull()) {
            System.out.println("Ничья");
            return;
        }
        isFinished = false;

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

    public static void humanTurn(int x, int y) { // Запрос у пользователя куда поставвить крестик
        if (!isCellValid(y, x)) {
            return;
        }
        map[y][x] = DOT_X;
        go();
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

    public static boolean checkWin(char c) { // Проверка есть ли победа
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
                    if (checkWin(DOT_X)) {
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