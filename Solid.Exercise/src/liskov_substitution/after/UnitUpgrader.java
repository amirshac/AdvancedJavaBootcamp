package liskov_substitution.after;
public class UnitUpgrader {
    public void upgrade(Apartment apartment) {
        apartment.squareFootage += 40;
    }
    
    public void upgrade(BedroomApartment bedApartment) {
        bedApartment.numberOfBedrooms += 1;
        upgrade((Apartment)bedApartment);
    }
}
