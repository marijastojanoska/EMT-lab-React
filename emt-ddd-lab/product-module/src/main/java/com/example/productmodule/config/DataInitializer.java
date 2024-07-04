package com.example.productmodule.config;

import com.example.productmodule.domain.models.Product;
import com.example.productmodule.domain.repository.ProductRepository;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        Product product1 = Product.build("Lipstick", Money.valueOf(Currency.MKD, 500));
        Product product2 = Product.build("Mascara", Money.valueOf(Currency.MKD, 750));
        if (productRepository.findAll().isEmpty()) {
            productRepository.saveAll(Arrays.asList(product1, product2));
        }
    }
}
