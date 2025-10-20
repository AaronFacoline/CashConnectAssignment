package za.co.connected.CashConnectAssignment.response;

import io.swagger.v3.oas.annotations.media.Schema;
import za.co.connected.CashConnectAssignment.dto.TransactionDto;

import java.util.List;

@Schema(description = "Response object containing merchant transaction details")
public record MerchantTransactionsResponse(
        @Schema(description = "Name of the merchant", example = "John's Store")
        String name,
        @Schema(description = "Total number of deposits made", example = "42")
        long totalNumberOfDeposits,
        @Schema(description = "Total fees charged for all transactions", example = "156.75")
        double totalFees,
        @Schema(description = "List of all transactions for the merchant")
        List<TransactionDto> transactions
) {
}
