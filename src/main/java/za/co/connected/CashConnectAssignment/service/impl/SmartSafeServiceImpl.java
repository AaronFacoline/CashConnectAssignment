package za.co.connected.CashConnectAssignment.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import za.co.connected.CashConnectAssignment.entity.MerchantEntity;
import za.co.connected.CashConnectAssignment.entity.TransactionsEntity;
import za.co.connected.CashConnectAssignment.repository.MerchantRepository;
import za.co.connected.CashConnectAssignment.request.SmartSafeTransactionRequest;
import za.co.connected.CashConnectAssignment.service.SmartSafeService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SmartSafeServiceImpl implements SmartSafeService {

    @Value("${transaction.success}")
    private boolean transactionSuccess;
    private final MerchantRepository merchantRepository;
    private static final Logger logger = LoggerFactory.getLogger(SmartSafeServiceImpl.class);

    @Override
    @Transactional
    public void processTransaction(SmartSafeTransactionRequest request) {

        MerchantEntity byUuid = merchantRepository.findByUuid(UUID.fromString(request.merchantUuid())).getFirst();
        TransactionsEntity transactionsEntity = new TransactionsEntity();
        transactionsEntity.setAmount(request.amount());
        transactionsEntity.setMerchant(byUuid);
        transactionsEntity.setFee(transactionsEntity.getAmount() * 0.0011);
        
        //Attempt to send the transaction to bank
        try {
            if (transactionSuccess) {
                logger.info("Transaction successfully sent to bank for merchant: {}", request.merchantUuid());
                byUuid.getTransactions().add(transactionsEntity);
                merchantRepository.save(byUuid);
            } else {
                logger.error("Failed to process bank transaction for merchant: {}", request.merchantUuid());
                throw new RuntimeException("Bank transaction failed");
            }
        } catch (Exception e) {
            logger.error("Error processing bank transaction: {}", e.getMessage());
            throw new RuntimeException("Error processing transaction", e);
        }
    }
}
