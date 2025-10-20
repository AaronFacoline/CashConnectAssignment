package za.co.connected.CashConnectAssignment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.connected.CashConnectAssignment.service.PalindromeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/palindrome")
@Tag(name = "Palindrome", description = "API endpoints for palindrome operations")
public class PalindromeController {

    private final PalindromeService palindromeService;

    @Operation(summary = "Check if string is palindrome", description = "Checks if the provided input string is a palindrome")
    @ApiResponse(responseCode = "200", description = "Successfully checked palindrome")
    @PostMapping(value = "/{input}")
    public boolean isPalindrome(@Parameter(description = "Input string to check", example = "radar") @PathVariable String input) {
        return palindromeService.isPalindrome(input);
    }
}
