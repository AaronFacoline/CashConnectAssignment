package za.co.connected.CashConnectAssignment.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response object containing merchant details")
public record MerchantResponse(
        @Schema(description = "Name of the merchant", example = "John's Store")
        String name,
        @Schema(description = "Unique identifier of the merchant", example = "550e8400-e29b-41d4-a716-446655440000")
        String uuid
) {
}
