package HomeWork1;

public class MainClass {
    public static void main(String[] args) {
        // Второе задание - Создать переменные всех пройденных типов данных, и инициализировать их значения;
        int var1 = 1;
        float var2 = 0.2335f;
        double var3 = 0.2335;
        boolean var4 = false;
        char var5 = 64;
        short var7 = 1032;
        byte var8 = 125;
        long var9 = 10213123;
        String var6 = "Hi";
        var1 = calculate(2, 3, 8, 2);
        System.out.println(var1);
        var4 = task10and20(5, 15);
        System.out.println(var4);
        isPositiveOrNegative(-5);
        var4 = isNegative(-10);
        System.out.println(var4);
        greetings("Максим");
        isYearBis(1981);
        isYearBis(2020);
        isYearBis(2000);
        isYearBis(2100);
        isYearBis(2200);
        isYearBis(2300);
    }

    // Третье задание - Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    public static int calculate(int a, int b, int c, int d) {
        return a * (b + c / d);
    }

    // Четвертое задание - Написать метод, принимающий на вход два числа, и проверяющий
    // что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public static boolean task10and20(int x1, int x2) {
        return (x1 + x2) >= 10 && (x1 + x2) <= 20;
    }

    // Пятое задание - Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
    // Замечание: ноль считаем положительным числом.
    public static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Число положительное или ноль");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // Шестое задание -  Написать метод, которому в качестве параметра передается целое число,
    // метод должен вернуть true, если число отрицательное;
    public static boolean isNegative(int x) {
        return x < 0;
    }

    // Седьмое задание - Написать метод, которому в качестве параметра передается строка,
    // обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void greetings(String name) {
        System.out.println("Привет," + name + "!");
    }

    // Восьмое задание -  Написать метод, который определяет является ли год високосным,
    // и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го,
    // при этом каждый 400-й – високосный.
    public static void isYearBis(int x) {
        String mes = x + " год ";
        if (x % 4 != 0 || (x % 100 == 0 && x % 400 != 0)) {
            System.out.println(mes + "- не высокосный");
        } else {
            System.out.println(mes + "- высокосный");
        }
    }
}