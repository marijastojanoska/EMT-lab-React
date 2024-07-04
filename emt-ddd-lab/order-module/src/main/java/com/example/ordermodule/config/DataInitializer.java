package com.example.ordermodule.config;

import com.example.ordermodule.domain.valueobject.Product;
import com.example.ordermodule.domain.valueobject.ProductId;
import com.example.ordermodule.service.dto.OrderDto;
import com.example.ordermodule.service.dto.OrderItemDto;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {
    public static List<OrderItemDto> orderItemDtos = new ArrayList<>();
    public static OrderDto orderDto = new OrderDto();

    @PostConstruct
    public void init() {

        OrderItemDto oid1 = new OrderItemDto(new Product(new ProductId("1"),"Lipstick", new Money(Currency.MKD, 500)), 5);
        OrderItemDto oid2 = new OrderItemDto(new Product(new ProductId("2"),"Mascara", new Money(Currency.MKD, 750)), 2);
        orderItemDtos.add(oid1);
        orderItemDtos.add(oid2);

        orderDto.setCurrency(Currency.MKD);
        orderDto.setItems(orderItemDtos);
    }
}
