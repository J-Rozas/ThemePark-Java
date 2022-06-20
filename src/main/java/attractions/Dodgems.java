package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    private double startingPrice;

    public Dodgems(String name, int rating) {
        super(name, rating);
        this.startingPrice = 4.50;
    }

    @Override
    public double defaultPrice() {
        return this.startingPrice;
    }

    @Override
    public double priceFor(Visitor visitor) {
        return visitor.getAge() < 12 ? defaultPrice() / 2 : defaultPrice();
    }
}
