package HomeWork5;

public class MainClass {
    /* * Создать массив из 5 сотрудников
    Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
     persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
     persArray[1] = new Person(...);
     ...
     persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
     */
    public static void main(String[] args) {
        Person[] persArr = new Person[5];
        persArr[0] = new Person("Ivanov Ivan", "Engineer", "ivi@mailbox.com", "892312312", 30000, 30);
        persArr[1] = new Person("Sidorov Petr", "CEO", "ss@mailbox.com", "892312312", 130000, 54);
        persArr[2] = new Person("Ivanov Serg", "Engineer", "van@mailbox.com", "892312312", 30000, 41);
        persArr[3] = new Person("Petrov Andrey", "Programmer", "in@mailbox.com", "892312312", 60000, 40);
        persArr[4] = new Person("Putin Alex", "Project manager", "ttt@mailbox.com", "892312312", 90000, 60);
        for (Person person : persArr) {
        if (person.getAge()>40) {
            person.info();
        }
        }
    }
}
