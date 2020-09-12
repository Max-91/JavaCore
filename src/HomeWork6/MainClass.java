package HomeWork6;

import HomeWork6.animals.*;

import java.util.Scanner;

public class MainClass {
    /* 1. Создать классы Собака и Кот с наследованием от класса Животное.
    2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
    3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
    4.* Добавить подсчет созданных котов, собак и животных.
    */
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Barsik1"),
                new Dog("Vulkan1"),
                new Cat("Barsik2"),
                new Dog("Vulkan2"),
                new Cat("Barsik3"),
                new Dog("Vulkan3"),
                new Dog("Vulkan4"),
                new Dog("Vulkan5"),
        };
        // Отображение всех животных (через StingOf)
        for (Animal animal: animals){
            System.out.println(animal);
        }

        // Отображение кол-ва классов
        System.out.printf("Кол-во animals = %d, cat = %d, dog = %d\n",Animal.count, Cat.count, Dog.count);
        // Запрос дистанции
        System.out.print("Введите дистанцию для бега и плавания: ");
        int distRun = scanner.nextInt();
        int distSwim = scanner.nextInt();
        for (Animal animal: animals){
            animal.run(distRun);
            animal.swim(distSwim);
        }

    }

}
