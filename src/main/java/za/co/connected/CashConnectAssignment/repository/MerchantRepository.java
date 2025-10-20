package za.co.connected.CashConnectAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.connected.CashConnectAssignment.entity.MerchantEntity;

import java.util.List;
import java.util.UUID;

public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {
    List<MerchantEntity> findByUuid(UUID uuid);
}
