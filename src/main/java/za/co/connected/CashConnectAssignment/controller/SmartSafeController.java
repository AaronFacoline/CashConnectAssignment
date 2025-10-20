package za.co.connected.CashConnectAssignment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.connected.CashConnectAssignment.request.SmartSafeTransactionRequest;
import za.co.connected.CashConnectAssignment.service.SmartSafeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/smart_safe")
@Tag(name = "Smart Safe", description = "API endpoints for smart safe operations")
public class SmartSafeController {

    private final SmartSafeService smartSafeService;

    @Operation(summary = "Process smart safe transaction", description = "Processes a new smart safe transaction")
    @ApiResponse(responseCode = "200", description = "Transaction processed successfully")
    @ApiResponse(responseCode = "400", description = "Invalid transaction request")
    @PostMapping("/process_transaction")
    public ResponseEntity<Void> processTransaction(
            @Parameter(description = "Transaction request details")
            @RequestBody SmartSafeTransactionRequest request) {
        smartSafeService.processTransaction(request);
        return ResponseEntity.ok().build();
    }

}
