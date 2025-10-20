package za.co.connected.CashConnectAssignment.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request object for smart safe transaction")
public record SmartSafeTransactionRequest(
        @Schema(description = "Unique identifier of the merchant", example = "550e8400-e29b-41d4-a716-446655440000")
        String merchantUuid,

        @Schema(description = "Transaction amount", example = "150000")
        long amount) {
}
