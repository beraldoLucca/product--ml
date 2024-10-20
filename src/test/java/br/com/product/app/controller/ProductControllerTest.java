package br.com.product.app.controller;

import br.com.product.app.dto.response.ProductResponseDTO;
import br.com.product.app.service.IProductService;
import br.com.product.domain.enums.Category;
import br.com.product.infra.db.model.Product;
import br.com.product.infra.repository.IProductRepository;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ProductControllerTest {

    private final String BASE_URL = "/api/v1";
    private final String GET_BY_ID_CATEGORY_URL = BASE_URL.concat("/product/1/category/5");
    private final String GET_PRODUCT_NOT_FOUND_URL = BASE_URL.concat("/product/100/category/5");
    private final String GET_CATEGORY_NOT_FOUND_URL = BASE_URL.concat("/product/1/category/500");


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IProductRepository productRepository;

    @BeforeEach
    public void setup() {

        Product product = new Product();
        product.setName("Notebook");
        product.setPrice(BigDecimal.valueOf(3099.00));
        product.setDescription("Notebook novinho");
        product.setCategory(Category.ELETRONICOS);

        productRepository.save(product);
    }

    @Test
    public void testSuccessfullyGetByIdAndCategory() throws Exception {

        mockMvc.perform(get(GET_BY_ID_CATEGORY_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Notebook"))
                .andExpect(jsonPath("$.price").value(3099.00))
                .andExpect(jsonPath("$.description").value("Notebook novinho"))
                .andExpect(jsonPath("$.category").value("ELETRONICOS"));
    }

    @Test
    public void testFailedProductNotFoundException() throws Exception {

        mockMvc.perform(get(GET_PRODUCT_NOT_FOUND_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testFailedCategoryNotFoundException() throws Exception {

        mockMvc.perform(get(GET_CATEGORY_NOT_FOUND_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
