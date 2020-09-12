package HomeWork6.animals;

public class Animal {
    //private package-private protected public
    protected String name;
    protected String nameOfClass; // Собака, Кошка
    protected int lenRun;
    protected int lenSwim;
    static public int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", lenRun=" + lenRun +
                ", lenSwim=" + lenSwim +
                '}';
    }

    public void run(int distance){
        if (lenRun==0) {
            System.out.printf("%s\bи не умеют бегать\n",nameOfClass);
            return;
        }
        if (distance<=lenRun) {
            System.out.printf("%s %s пробежала %d метров\n", nameOfClass, name, distance);
            return;
        }
        if (distance>lenRun) {
            System.out.printf("%s %s пробежала %d метров (и не смогла пробежать еще %d метров)\n", nameOfClass, name, lenRun, (distance-lenRun));
            return;
        }
    }

    public void swim (int distance){
        if (lenSwim==0) {
            System.out.printf("%s\bи не умеют плавать\n",nameOfClass);
            return;
        }
        if (distance<=lenSwim) {
            System.out.printf("%s %s проплыла %d метров\n", nameOfClass, name, distance);
            return;
        }
        if (distance>lenSwim) {
            System.out.printf("%s %s проплыла %d метров (и не смогла проплыть еще %d метров)\n", nameOfClass, name, lenSwim, (distance-lenSwim));
            return;
        }
    }
}
