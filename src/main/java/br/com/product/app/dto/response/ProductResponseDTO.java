package br.com.product.app.dto.response;

import br.com.product.domain.enums.Category;
import br.com.product.infra.db.model.Product;

import java.math.BigDecimal;

public record ProductResponseDTO(String name, Category category, BigDecimal price, String description) {

    public static ProductResponseDTO from(Product product) {
        return new ProductResponseDTO(product.getName(), product.getCategory(), product.getPrice(), product.getDescription());
    }
}
