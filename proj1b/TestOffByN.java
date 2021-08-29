import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offBy5 = new OffByN(5);

    // Your tests go here.
    @Test
    public void TestOffByN() {
        assertEquals(offBy5.equalChars('a', 'b'), false);
        assertEquals(offBy5.equalChars('a', 'c'), false);
        assertEquals(offBy5.equalChars('a', 'd'), false);
        assertEquals(offBy5.equalChars('a', 'e'), false);
        assertEquals(offBy5.equalChars('a', 'f'), true);
    }
}
