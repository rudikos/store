package com.example.store.endpoint;

import com.example.store.dto.PageDataDto;
import com.example.store.dto.ProductDto;
import com.example.store.exception.ResourceNotFoundException;
import com.example.store.service.CurrentUserProvider;
import com.example.store.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@RestController
public class ProductController extends BaseController {

	private final ProductService productService;

	public ProductController(ProductService productService, CurrentUserProvider currentUserProvider) {
		super(currentUserProvider);
		this.productService = productService;
	}

	@GetMapping(value = "/products/search")
	public PageDataDto<ProductDto> search(@RequestParam(value = "sortField", required = false) String sortField,
										  @RequestParam(value = "sortOrder", required = false) String sortOrder,
										  @RequestParam(value = "page", required = false) Integer page,
										  @RequestParam(value = "pageSize", required = false) Integer pageSize,
										  @RequestParam(value = "filter", required = false) String search) {
		return productService.getProducts(page, pageSize, sortField, sortOrder, search);
	}

	@GetMapping(value = "/categories/{categoryId}/products")
	public Collection<ProductDto> getCategoryProducts(@PathVariable("categoryId") Integer categoryId) throws ResourceNotFoundException {
		checkAccess();
		return productService.getCategoryProducts(categoryId);
	}

	@PostMapping(value = "/categories/{categoryId}/products")
	public void createCategoryProducts(@PathVariable("categoryId") Integer categoryId,
									   @RequestBody Collection<ProductDto> productDtos) throws ResourceNotFoundException {
		checkAccess();
		productService.createProducts(productDtos, categoryId);
	}

	@PutMapping(value = "/products/{productId}")
	public ProductDto updateProduct(@PathVariable("productId") Long productId,
									@RequestBody ProductDto productDto) throws ResourceNotFoundException {
		checkAccess();
		return productService.updateProduct(productDto, productId);
	}

	@DeleteMapping(value = "/products/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("productId") Long productId) throws ResourceNotFoundException {
		checkAccess();
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
