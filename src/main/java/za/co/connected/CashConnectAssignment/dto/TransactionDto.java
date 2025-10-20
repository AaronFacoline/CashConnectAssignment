package za.co.connected.CashConnectAssignment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import za.co.connected.CashConnectAssignment.entity.TransactionsEntity;

import java.time.LocalDate;

@Schema(description = "Transaction data transfer object for financial operations")
@Data
public class TransactionDto {

    public TransactionDto(TransactionsEntity transactionsEntity) {
        this.transactionId = transactionsEntity.getId();
        this.date = transactionsEntity.getDate();
        this.amount = transactionsEntity.getAmount();
        this.fee = transactionsEntity.getFee();
    }

    @Schema(description = "Unique identifier for the transaction", example = "123456789")
    private long transactionId;

    @Schema(description = "Date when the transaction occurred", example = "2025-10-20")
    private LocalDate date;

    @Schema(description = "Transaction amount in Rands", example = "100000")
    private long amount;

    @Schema(description = "Transaction fee", example = "R0.55")
    private double fee;

}
