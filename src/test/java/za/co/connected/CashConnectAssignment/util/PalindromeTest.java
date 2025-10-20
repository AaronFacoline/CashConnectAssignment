package za.co.connected.CashConnectAssignment.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeTest {

    @Test
    public void testIsPalindrome() {
        String input = "A man, a plan, a canal: Panama";
        Assertions.assertTrue(Palindrome.isPalindrome(input));
    }

    @Test
    public void testIsPalindromeWithNumbers () {
        String input = "A1 man, a plan, a canal: Panam1a";
        Assertions.assertTrue(Palindrome.isPalindrome(input));
    }

    @Test
    public void testIsPalindromeFalse() {
        String input = "not a palindrome";
        Assertions.assertFalse(Palindrome.isPalindrome(input));
    }

}