package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;


    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(30, 1.78, 39.93);
        visitor2 = new Visitor(1, 1.78, 38.19);
        visitor3 = new Visitor(30, 1.10, 38.19);
        visitor4 = new Visitor(40, 5.98, 63.00);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void acceptOldEnoughAndTallEnough() {
        assertTrue(rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void doesNotAcceptNotOldEnoughAndTallEnough() {
        assertFalse(rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void doesNotAcceptOldEnoughAndNotTallEnough() {
        assertFalse(rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void chargesNormalFeeIfNoSpecialConditions() {
        assertEquals(8.40, rollerCoaster.priceFor(visitor1), 0.00);
    }

    @Test
    public void chargesDoubleFeeIfTall() {
        assertEquals(16.80, rollerCoaster.priceFor(visitor4), 0.00);
    }
}
