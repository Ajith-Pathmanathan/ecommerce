package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.dto.PaymentHistoryDto;
import com.ajith.ecommerce.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payments, UUID> {
    @Query("""
                SELECT new PaymentHistoryDto(
                u.email,
                u.mobileNum,
                p.amount,
                s.name'
                PR.id,
                PR.name,
                PR.price
                PR.description
                PR.imageUrl,
            ) FROM Payments p
                JOIN p.Status s
                JOIN P.orders o
                JOIN o.Products PR
                JOIN o.users u
                WHERE u.id=:id
            """)
    List<PaymentHistoryDto> getPaymentHistoryByUserId(UUID id);
}
