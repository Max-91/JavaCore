package HomeWork6.animals;

public class Dog extends Animal{

    public static int count;

    public Dog(String name) {
        super(name);
        nameOfClass="Собака";
        lenRun=500;
        lenSwim=10;
        count++;
    }
}
