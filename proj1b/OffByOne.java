public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        if (x <= 32 || x >= 127 || y <= 32 || y >= 127) {
            return false;
        }
        return x - y == 1 || y - x == 1;
    }
}
