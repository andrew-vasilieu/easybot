package org.easybot.easybottesttask.controller;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.easybot.easybottesttask.entity.Product;
import org.easybot.easybottesttask.entity.ProductType;
import org.easybot.easybottesttask.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    private static final String PRODUCT_EXAMPLE = """
                                              {
                                                "type": "DESKTOP",
                                                "serialNo": "4kjtqb4b4",
                                                "manufacturer": "Lenovo",
                                                "price": "12",
                                                "quantity": "56",
                                                "desktopType": "DESKTOP"
                                              }
                                            """;

    @Operation(summary = "Add new Product")
    @PostMapping
    public Product createProduct(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Add new Product. Possible values for type: DESKTOP, HARD_DRIVE, LAPTOP, MONITOR",
                    content = @Content(
                            schema = @Schema(implementation = Json.class),
                            examples = {
                                    @ExampleObject(PRODUCT_EXAMPLE)
                            }
                    )
            )
            @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @Operation(summary = "Update an existing Product")
    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable("id") Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = """
                            Update an existing product.
                            """,
                    content = @Content(
                            schema = @Schema(implementation = Json.class),
                            examples = {
                                    @ExampleObject(PRODUCT_EXAMPLE)
                            }
                    )
            )
            @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @Operation(summary = "Get product by id")
    @GetMapping("/{id}")
    public Product getProductById(
            @Parameter(description = "Id of the Product")
            @PathVariable Long id) {
        return productService.getById(id);
    }

    @Operation(summary = "Get all products by type.")
    @GetMapping()
    public List<Product> getAllProductsByType(
            @Parameter(description = "Get Products by type. Possible values for type: DESKTOP, HARD_DRIVE, LAPTOP, MONITOR")
            @RequestParam ProductType type) {
        return productService.getByProductType(type);
    }
}
