package za.co.connected.CashConnectAssignment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.connected.CashConnectAssignment.request.CreateMerchantRequest;
import za.co.connected.CashConnectAssignment.response.MerchantResponse;
import za.co.connected.CashConnectAssignment.service.MerchantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchant")
@Tag(name = "Merchant", description = "API endpoints for merchant operations")
public class MerchantController {

    private final MerchantService merchantService;

    @Operation(summary = "Create new merchant", description = "Creates a new merchant with the provided details")
    @ApiResponse(responseCode = "200", description = "Merchant successfully created")
    @PostMapping
    public ResponseEntity<MerchantResponse> createMerchant(@RequestBody CreateMerchantRequest request) {
        return ResponseEntity.ok(merchantService.createMerchant(request));
    }
    

    @Operation(summary = "Get all merchants", description = "Retrieves a list of all merchants")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of merchants")
    @GetMapping
    public ResponseEntity<List<MerchantResponse>> getAllMerchants() {
        return ResponseEntity.ok(merchantService.getAllMerchants());
    }

}
