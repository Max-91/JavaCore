package HomeWork6.animals;

public class Cat extends Animal{

    public static int count;

    public Cat(String name) {
        super(name);
        nameOfClass="Кошка";
        lenRun=200;
        lenSwim=0;
        count++;
    }
}
