package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.dto.CardItemDto;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.mapper.CartItemMapper;
import com.ajith.ecommerce.model.CartItems;
import com.ajith.ecommerce.model.Products;
import com.ajith.ecommerce.model.Users;
import com.ajith.ecommerce.repository.CartItemRepository;
import com.ajith.ecommerce.repository.ProductRepository;
import com.ajith.ecommerce.repository.UserRepository;
import com.ajith.ecommerce.service.CardItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardItemServiceImpl implements CardItemService {
    private final CartItemMapper cartItemMapper;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public CardItemDto createCardItem(CardItemDto cardItemDto) {
        CartItems cartItems = cartItemMapper.toEntity(cardItemDto);
        Users users = userRepository.findById(cardItemDto.getId()).orElseThrow(() -> new ResourceNotFoundException("user not found with id: %s".formatted(cardItemDto.getUserId()), List.of("enter valid user id")));
        cartItems.setUsers(users);
        Products products = productRepository.findById(cardItemDto.getProductId()).orElseThrow(() -> new ResourceNotFoundException("user not found with id: %s".formatted(cardItemDto.getUserId()), List.of("enter valid user id")));
        cartItems.setProducts(products);
        cartItems = cartItemRepository.save(cartItems);
        return cartItemMapper.toDto(cartItems);
    }

    @Override
    public List<CardItemDto> getCardItemByUserId(UUID id) {
        List<CartItems> cartItems = cartItemRepository.findByUsers_id(id);
        return cartItemMapper.toListDto(cartItems);
    }
}
