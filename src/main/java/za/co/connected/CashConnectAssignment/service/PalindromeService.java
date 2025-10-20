package za.co.connected.CashConnectAssignment.service;

/**
 * Represents a service for checking if a given string is a palindrome.
 * A palindrome is a word, phrase, number, or other sequence of characters
 * that reads the same forward and backward, ignoring spaces, punctuation, and capitalization.
 */
public interface PalindromeService {

    /**
     * Checks if a given string is a palindrome. A palindrome is a sequence of (alphanumeric) characters
     * that reads the same backward as forward, ignoring spaces, punctuation, and capitalization.
     *
     * @param input the string to check if it is a palindrome
     * @return true if the input is a palindrome; false otherwise
     */
    boolean isPalindrome(String input);

}
