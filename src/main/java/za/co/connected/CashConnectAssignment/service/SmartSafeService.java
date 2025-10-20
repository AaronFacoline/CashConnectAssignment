package za.co.connected.CashConnectAssignment.service;

import za.co.connected.CashConnectAssignment.request.SmartSafeTransactionRequest;

public interface SmartSafeService {

    /**
     * Processes a smart safe transaction request, which includes the merchant's unique identifier
     * and the transaction amount.
     *
     * @param request the request object containing details of the transaction, such as the merchant's unique identifier
     *                and the transaction amount
     */
    public void processTransaction(SmartSafeTransactionRequest request);
}
