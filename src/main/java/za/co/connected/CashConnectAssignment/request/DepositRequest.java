package za.co.connected.CashConnectAssignment.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request object for making a deposit transaction")
public record DepositRequest(
        @Schema(description = "Amount to deposit", example = "135 000")
        int amount,

        @Schema(description = "Unique identifier of the merchant", example = "550e8400-e29b-41d4-a716-446655440000")
        String merchantUuid) {
}
