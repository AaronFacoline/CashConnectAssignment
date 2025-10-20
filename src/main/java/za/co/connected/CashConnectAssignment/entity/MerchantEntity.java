package za.co.connected.CashConnectAssignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchant", indexes = @Index(columnList = "uuid", unique = true))
public class MerchantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private UUID uuid = UUID.randomUUID();

    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MerchantAccountEntity account;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TransactionsEntity> transactions;

}
