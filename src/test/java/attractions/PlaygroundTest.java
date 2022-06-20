package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        visitor1 = new Visitor(16, 1.60, 100.93);
        visitor2 = new Visitor(9, 1.40, 1092848302938923.12);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void overAgeVisitorCannotEnter() {
        assertFalse(playground.isAllowedTo(visitor1));
    }

    @Test
    public void underAgeVisitorCanEnter() {
        assertTrue(playground.isAllowedTo(visitor2));
    }

}
