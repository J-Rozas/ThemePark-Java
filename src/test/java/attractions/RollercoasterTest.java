package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1 = new Visitor(30, 1.78, 39.93);
    Visitor visitor2 = new Visitor(1, 1.78, 38.19);
    Visitor visitor3 = new Visitor(30, 1.10, 38.19);


    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
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
    public void doesNotAccepOldEnoughAndNotTallEnough() {
        assertFalse(rollerCoaster.isAllowedTo(visitor3));
    }
}
