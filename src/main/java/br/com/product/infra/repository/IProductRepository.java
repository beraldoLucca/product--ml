package br.com.product.infra.repository;

import br.com.product.domain.enums.Category;
import br.com.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

    Product findByProductIdAndCategory(Integer productId, Category category);
}
