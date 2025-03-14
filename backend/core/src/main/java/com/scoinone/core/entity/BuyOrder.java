package com.scoinone.core.entity;

import com.scoinone.core.common.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "buy_orders")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
public class BuyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "virtual_asset_id")
    private VirtualAsset virtualAsset;

    private BigDecimal quantity;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime tradeTime;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
}