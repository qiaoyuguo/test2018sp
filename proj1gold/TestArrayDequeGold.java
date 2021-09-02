import org.junit.Test;

public class TestArrayDequeGold {
    public void printAllOperations(String[] op, int[] param, int n) {
        for (int i = 0; i < n; i += 1) {

        }
    }

    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        int N = 10000;
        String ops = "";
        for (int i = 0; i < N; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25) {
                sad.addLast(i);
                ads.addLast(i);
                ops += "addLast(" + i + ")\n";
            } else if (numberBetweenZeroAndOne < 0.5) {
                sad.addFirst(i);
                ads.addFirst(i);
                ops += "addFirst(" + i + ")\n";
            } else if (numberBetweenZeroAndOne < 0.75 && !ads.isEmpty() && !sad.isEmpty()) {
                int x = ads.removeFirst();
                int y = sad.removeFirst();
                if (x != y) {
                    ops += "removeFirst(), student was " + y + ", correct was " + x + "\n";
                }
                org.junit.Assert.assertEquals(ops, x, y);
            } else if (!ads.isEmpty() && !sad.isEmpty()) {
                int x = ads.removeLast();
                int y = sad.removeLast();
                if (x != y) {
                    ops += "removeLast(), student was " + y + ", correct was " + x + "\n";
                }
                org.junit.Assert.assertEquals(ops, x, y);
            }
        }
    }
}
