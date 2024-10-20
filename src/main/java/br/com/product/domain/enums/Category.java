package br.com.product.domain.enums;

import br.com.product.domain.exception.ValidationException;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum Category {
    LANCHE(1),
    ACOMPANHAMENTO(2),
    BEBIDA(3),
    SOBREMESA(4),
    ELETRONICOS(5);

    private final Integer value;

    Category(Integer value) {
        this.value = value;
    }

    public static Category fromValue(Integer value) {
        for (Category category : Category.values()) {
            if (Objects.equals(category.getValue(), value)) {
                return category;
            }
        }
        throw new ValidationException("Categoria invalida.");
    }
}