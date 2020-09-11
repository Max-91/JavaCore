package HomeWork3;

<<<<<<< HEAD
public class MainClass {
    public static void main(String[] args) {
=======
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //guessNumGame(); // Первая задача
        guessWordGame(); // Вторая задача
    }

    static void guessNumGame() {
        // 1. Написать программу, которая загадывает случайное число от 0 до 9, и
        // пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен
        // сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз?
        // 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        int userRepeat; // Ответ пользователя на вопрос повторить ли игру
        do {
            int maxGuessNum = 10; // Макс.кол-во попыток
            int guessNum = random.nextInt(maxGuessNum); // Загаданное число
            int userNum; // Ответ пользователя
            int maxTry = 3; // Кол-во попыток
            int currTry = 1; // Текущая попытка
            System.out.printf("Отгадайте число от 0 до %d\n", maxGuessNum);
            do {
                System.out.printf("Попытка №%d из %d, Введите ваш вариант:\n", currTry, maxTry);
                userNum = sc.nextInt();
                sc.nextLine();
                if (userNum == guessNum) {
                    System.out.println("Поздравляю Вы отгадали!!!");
                    break;
                }
                if (userNum > guessNum) {
                    System.out.println("Нет, загаданное число меньше");
                }
                if (userNum < guessNum) {
                    System.out.println("Нет, загаданное число больше");
                }
                currTry++;
            } while (currTry <= maxTry);
            if (currTry > maxTry) {
                System.out.println("Вы проиграли, загаданное число было " + guessNum);
            }
            do {
                System.out.println("Хотите сыграть еще раз? 1 - да, 0 - нет");
                userRepeat = sc.nextInt();
                sc.nextLine();
            } while (userRepeat != 0 && userRepeat != 1); // На всякий случай проверка ввел ли пользователь 0 или 1

        } while (userRepeat == 1);
    }

    static void guessWordGame() {
        //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        // сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
        // Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String guessStr =words[random.nextInt(words.length)]; // Загаданное слово
        char[] guessStrArr= guessStr.toCharArray(); // Загаданное слово в виде массива символом
        String userStr; // Вариант пользователя
        int currTry = 1; // Текущая попытка
        char[] resultStrArr= new char[15];

        do{
            System.out.printf("Попытка №%d, Введите ваш вариант:\n", currTry);
            userStr = sc.nextLine();
            userStr = userStr.toLowerCase();
            // Перевод String в массив char
            char[] userStrArr= userStr.toCharArray();
            if (guessStr.equals(userStr)) {
                System.out.println("Поздравляю Вы отгадали c "+ currTry + " попытки !!!");
                break;
            } else
                for (int i = 0; i < 15; i++) {
                    if (guessStrArr.length>i && userStrArr.length>i)
                    {
                        if (guessStrArr[i]==userStrArr[i]) {
                            resultStrArr[i]=guessStrArr[i];
                        } else {
                            resultStrArr[i] = 'x';
                        }
                    } else {
                        resultStrArr[i]='x';
                    }

                }
            System.out.println("Не угадали. Совпадения: ");
            System.out.println(resultStrArr);
            currTry++;
        } while (true);
>>>>>>> develop

    }
}
