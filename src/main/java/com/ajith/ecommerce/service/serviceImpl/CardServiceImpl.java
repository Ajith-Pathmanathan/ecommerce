package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.dto.CardDto;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.mapper.CardMapper;
import com.ajith.ecommerce.model.Card;
import com.ajith.ecommerce.repository.CardRepository;
import com.ajith.ecommerce.repository.UserRepository;
import com.ajith.ecommerce.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final UserRepository userRepository;

    @Override
    public CardDto saveCard(CardDto cardDto) {
        Card card = cardRepository.save(cardMapper.toEntity(cardDto));
        return cardMapper.toDto(card);
    }

    @Override
    public String removeCard(UUID id) {
        if (!cardRepository.existsById(id)) {
            throw new ResourceNotFoundException(String.format("card not found with id: %s", id.toString()), List.of("enter valid card id"));
        }
        cardRepository.deleteById(id);
        return "card removed Success";
    }

    @Override
    public List<CardDto> getCardsByUserId(UUID id) {
        List<Card> cards = userRepository.getCardsById(id);
        return cardMapper.toDtoList(cards);
    }

    @Override
    public CardDto getCardById(UUID id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("card not found with id: %s", id.toString()), List.of("enter valid card id")));
        return cardMapper.toDto(card);
    }
}
