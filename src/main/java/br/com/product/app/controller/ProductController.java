package br.com.product.app.controller;

import br.com.product.app.dto.response.ProductResponseDTO;
import br.com.product.app.service.IProductService;
import br.com.product.domain.enums.Category;
import br.com.product.infra.db.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}/category/{categoryId}")
    @Operation(summary = "Buscando produto pelo nome e id de categoria.")
    public ResponseEntity<ProductResponseDTO> getProductByIdAndCategory(@PathVariable Integer productId, @PathVariable Integer categoryId){
        log.info("ProductController - Buscando produto pelo id do produto: {} e id de categoria: {}", productId, categoryId);
        var product = productService.findByIdAndCategory(productId, categoryId);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product")
    public ResponseEntity<String> getProductByNameAndCategory(@RequestBody Product product){
        var produto = new Product();
        produto.setName(product.getName());
        var category = Category.fromValue(1);
        produto.setCategory(category);
        produto.setDescription(product.getDescription());
        produto.setPrice(product.getPrice());
        productService.save(produto);
        return ResponseEntity.ok("produto adicionado com sucesso");
    }
}
