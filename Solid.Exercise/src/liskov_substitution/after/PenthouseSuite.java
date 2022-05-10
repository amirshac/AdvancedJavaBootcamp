package liskov_substitution.after;
public class PenthouseSuite extends BedroomApartment {
    public PenthouseSuite() {
        this.numberOfBedrooms = 4;
    }

    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }
}
