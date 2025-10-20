package za.co.connected.CashConnectAssignment.service;

import za.co.connected.CashConnectAssignment.request.CreateMerchantRequest;
import za.co.connected.CashConnectAssignment.response.MerchantResponse;
import za.co.connected.CashConnectAssignment.response.MerchantTransactionsResponse;

import java.util.List;


public interface MerchantService {
    /**
     * Creates a new merchant based on the provided request data and returns the corresponding response.
     *
     * @param request the data required to create a new merchant, including the merchant's name and account key
     * @return a MerchantResponse object containing the details of the created merchant, such as the name and UUID
     */
    public MerchantResponse createMerchant(CreateMerchantRequest request);

    /**
     * Retrieves a list of all merchants.
     *
     * @return a list of MerchantResponse objects, each containing details of a merchant such as the name and unique identifier
     */
    public List<MerchantResponse> getAllMerchants();

    /**
     * Retrieves the transaction details for a specified merchant by their unique identifier.
     *
     * @param uuid the unique identifier of the merchant whose transactions are to be retrieved
     * @return a MerchantTransactionsResponse containing the merchant's name, total deposits made,
     *         total transaction fees, and the list of all their transactions
     */
    public MerchantTransactionsResponse getMerchantTransactions(String uuid);

}
