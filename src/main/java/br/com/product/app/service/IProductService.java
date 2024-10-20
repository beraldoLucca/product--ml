package br.com.product.app.service;

import br.com.product.app.dto.response.ProductResponseDTO;
import br.com.product.domain.enums.Category;
import br.com.product.infra.db.model.Product;

public interface IProductService {

    ProductResponseDTO findByIdAndCategory(Integer product, Integer categoriaId);

    void save(Product product);
}
