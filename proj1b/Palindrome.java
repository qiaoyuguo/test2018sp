public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }


    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        if (deque.size() == 0 || deque.size() == 1)
            return true;
        while (!deque.isEmpty() && deque.size() > 1) {
            Character first = deque.removeFirst();
            Character last = deque.removeLast();
            if (!first.equals(last)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        if (deque.size() == 0 || deque.size() == 1)
            return true;
        while (!deque.isEmpty() && deque.size() > 1) {
            Character first = deque.removeFirst();
            Character last = deque.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }
}
