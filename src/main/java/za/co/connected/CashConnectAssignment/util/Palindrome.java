package za.co.connected.CashConnectAssignment.util;

public class Palindrome {

    public static boolean isPalindrome(String input) {

        String evaluatedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int length = evaluatedInput.length();

        for (int i = 0; i < length / 2; i++) {
            if (evaluatedInput.charAt(i) != evaluatedInput.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;

    }

}
