package com.ajith.ecommerce.mapper;

import com.ajith.ecommerce.dto.OrderDto;
import com.ajith.ecommerce.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    Orders toEntity(OrderDto orderDto);

    OrderDto toDto(Orders orders);
}
