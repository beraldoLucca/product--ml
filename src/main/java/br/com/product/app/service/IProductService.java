package br.com.product.app.service;

import br.com.product.app.dto.response.ProductResponseDTO;

public interface IProductService {

    ProductResponseDTO findByIdAndCategory(Integer product, Integer categoriaId);
}
