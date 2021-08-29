import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertEquals(offByOne.equalChars('x', 'y'), true);
        assertEquals(offByOne.equalChars('y', 'x'), true);
        assertEquals(offByOne.equalChars('x', 'x'), false);
        assertEquals(offByOne.equalChars('a', 'z'), false);
        assertEquals(offByOne.equalChars('&', '%'), true);
    }
}
