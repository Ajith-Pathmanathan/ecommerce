package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.model.Card;
import com.ajith.ecommerce.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    @Query("""
SELECT  c from Card c WHERE c.users.id =: id
""")
    List<Card> getCardsById(UUID id);
}
