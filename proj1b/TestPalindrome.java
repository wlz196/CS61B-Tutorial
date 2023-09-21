import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();


    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome() {

        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("aba"));
        assertFalse(palindrome.isPalindrome("ab"));
        assertTrue(palindrome.isPalindrome("ab",offByOne));
        assertTrue(palindrome.isPalindrome("ba",offByOne));
        assertTrue(palindrome.isPalindrome("a",offByOne));
        assertTrue(palindrome.isPalindrome("",offByOne));
        assertFalse(palindrome.isPalindrome("aa",offByOne));


    }
}
