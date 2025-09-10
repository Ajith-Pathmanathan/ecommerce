package com.ajith.ecommerce.mapper;

import com.ajith.ecommerce.dto.CardDto;
import com.ajith.ecommerce.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper {
    Card toEntity(CardDto cardDto);

    CardDto toDto(Card card);

    List<Card> toDtoList(List<Card> cardList);
}
