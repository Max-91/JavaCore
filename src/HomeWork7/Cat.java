package HomeWork7;

public class Cat {
    private String name;
    private int appetite;
    private boolean full;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        full = false;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void eat(Plate plate) {
        if (plate.getFood() < appetite) {
            System.out.println("Кошка " + name + " (аппетит = " + appetite + ") решила не есть, так как еды слишком мало (" + plate.getFood() + ")");
            return;
        }
        if (plate.decFood(appetite)) {
            System.out.println("Кошка " + name + " съела " + appetite + " кусков (осталось " + plate.getFood() + ")");
            this.full = true;
        } else {
            System.out.println("Еды не хватило для " + name);

        }
    }

    public void info() {
        if (full) {
            System.out.println("Кошка " + name + " сытая");
        } else {
            System.out.println("Кошка " + name + " голодная (она хочет съесть "+appetite+" кусков)");
        }
    }
}
