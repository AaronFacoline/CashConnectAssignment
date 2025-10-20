package za.co.connected.CashConnectAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.connected.CashConnectAssignment.entity.MerchantEntity;

public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {
}
