//package com.ajith.ecommerce.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//import java.util.UUID;
//@Entity
//@Builder
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ShoppingCart {
//    private UUID id;
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private Users users;
//    @OneToMany(mappedBy = "cart")
//    private List<CartItems> cartItems;
//}
