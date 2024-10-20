package br.com.product.app.service.impl;

import br.com.product.app.dto.response.ProductResponseDTO;
import br.com.product.app.service.IProductService;
import br.com.product.domain.enums.Category;
import br.com.product.domain.exception.ValidationException;
import br.com.product.infra.db.model.Product;
import br.com.product.infra.repository.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO findByIdAndCategory(Integer productId, Integer categoryId) {
        log.info("ProductServiceImpl :: findByIdAndCategory()");
        var category = Category.fromValue(categoryId);
        if (productRepository.findByProductIdAndCategory(productId, category) == null){
            throw new ValidationException("Produto não encontrado");
        }
        else{
            return ProductResponseDTO.from(productRepository.findByProductIdAndCategory(productId, category));
        }
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
