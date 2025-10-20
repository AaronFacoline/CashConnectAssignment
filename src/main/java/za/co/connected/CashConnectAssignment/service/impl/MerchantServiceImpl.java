package za.co.connected.CashConnectAssignment.service.impl;

import org.springframework.stereotype.Service;
import za.co.connected.CashConnectAssignment.dto.TransactionDto;
import za.co.connected.CashConnectAssignment.entity.MerchantAccountEntity;
import za.co.connected.CashConnectAssignment.entity.MerchantEntity;
import za.co.connected.CashConnectAssignment.entity.TransactionsEntity;
import za.co.connected.CashConnectAssignment.repository.MerchantRepository;
import za.co.connected.CashConnectAssignment.request.CreateMerchantRequest;
import za.co.connected.CashConnectAssignment.response.MerchantResponse;
import za.co.connected.CashConnectAssignment.response.MerchantTransactionsResponse;
import za.co.connected.CashConnectAssignment.service.MerchantService;

import java.util.List;
import java.util.UUID;

@Service
public class MerchantServiceImpl implements MerchantService {


    private final MerchantRepository merchantRepository;

    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public MerchantResponse createMerchant(CreateMerchantRequest request) {
        MerchantAccountEntity merchantAccountEntity = new MerchantAccountEntity();
        merchantAccountEntity.setMerchant_key(request.accountKey());

        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setName(request.name());
        merchantEntity.setAccount(merchantAccountEntity);

        MerchantEntity save = merchantRepository.save(merchantEntity);

        return new MerchantResponse(save.getName(), save.getUuid().toString());
    }

    @Override
    public List<MerchantResponse> getAllMerchants() {
        return merchantRepository.findAll().stream()
                .map(merchant -> new MerchantResponse(merchant.getName(), merchant.getUuid().toString()))
                .toList();
    }

    @Override
    public MerchantTransactionsResponse getMerchantTransactions(String uuid) {

        MerchantEntity first = merchantRepository.findByUuid(UUID.fromString(uuid)).getFirst();
        List<TransactionsEntity> transactions = first.getTransactions();

        return new MerchantTransactionsResponse(
                first.getName(),
                transactions.size(),
                first.getTransactions().stream()
                        .mapToDouble(TransactionsEntity::getFee)
                        .sum(),
                first.getTransactions().stream().map(TransactionDto::new).toList()
        );


    }

}
