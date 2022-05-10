package interface_segregation.after;
public class Eagle implements Flyable, Moltable {
    public String currentLocation;
    public int numberOfFeathers;

    public Eagle(int initialFeatherCount) {
        this.numberOfFeathers = initialFeatherCount;
    }

    public void fly() {
        this.currentLocation = "in the air";
    }

    public void molt() {
        this.numberOfFeathers -= 1;
    }
}
