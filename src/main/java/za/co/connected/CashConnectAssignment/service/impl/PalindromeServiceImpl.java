package za.co.connected.CashConnectAssignment.service.impl;

import org.springframework.stereotype.Service;
import za.co.connected.CashConnectAssignment.util.Palindrome;

@Service
public class PalindromeServiceImpl implements za.co.connected.CashConnectAssignment.service.PalindromeService {

    public boolean isPalindrome(String input) {
        return Palindrome.isPalindrome(input);
    }

}
