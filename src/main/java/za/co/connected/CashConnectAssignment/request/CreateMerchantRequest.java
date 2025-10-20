package za.co.connected.CashConnectAssignment.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request object for creating a new merchant")
public record CreateMerchantRequest(
        @Schema(description = "Name of the merchant", example = "Sample Shop")
        String name,
        @Schema(description = "Unique account key for the merchant", example = "ACC123")
        String accountKey
) {
}
