package HomeWork7;

import java.util.Scanner;

public class MainClass {
    /*  1. Расширить задачу про котов и тарелки с едой
    2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
    3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
    4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
    5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
    6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countFood;
        Cat[] cats = {
                new Cat("Barsik1", 9),
                new Cat("Barsik2", 15),
                new Cat("Barsik3", 17),
                new Cat("Barsik4", 7),
                new Cat("Barsik5", 8),
                new Cat("Barsik6", 15),
        };
        do {
            System.out.println("Введите кол-во еды:");
            countFood=scanner.nextInt();
        }
        while (!(countFood > 0));

        Plate plate = new Plate(countFood);
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        System.out.println("Информация о сытости кошек:");
        for (Cat cat : cats) {
            cat.info();
        }
    }

}
