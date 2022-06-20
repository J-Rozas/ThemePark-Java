package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    private double startingPrice;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
        this.startingPrice = 8.40;
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getAge() >= 12 && visitor.getHeight() >= 1.45;
    }

    @Override
    public double defaultPrice() {
        return this.startingPrice;
    }

    @Override
    public double priceFor(Visitor visitor) {
        return visitor.getHeight() > 2.00 ? defaultPrice() * 2 : defaultPrice();
    }
}
