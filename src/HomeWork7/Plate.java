package HomeWork7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decFood(int amount) {
        if (amount < this.food) {
            this.food -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void incFood(int amount) {
        this.food += amount;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

}
