package HomeWork5;

public class Person {
    /* * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 * Создать массив из 5 сотрудников

 Пример:
 Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 persArray[1] = new Person(...);
 ...
 persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */
    private String name;
    private String position;
    private String email;
    private String phone;
    private int earn;
    private int age;

    public Person(String name, String position, String email, String phone, int earn, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.earn = earn;
        this.age = age;
    }

    public void info(){
        System.out.printf("ФИО: %s, Должность: %s, Почта: %s, Телефон: %s, Зарплата: %d, Возвраст: %d\n", name, position, email, phone, earn, age);
    }

    public int getAge() {
        return age;
    }
}
