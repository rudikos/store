package com.example.store.service.impl;

import com.example.store.domain.Category;
import com.example.store.domain.Product;
import com.example.store.dto.PageDataDto;
import com.example.store.dto.ProductDto;
import com.example.store.exception.ResourceNotFoundException;
import com.example.store.filter.ProductSpecificationBuilder;
import com.example.store.repository.ProductRepository;
import com.example.store.service.CategoryService;
import com.example.store.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final CategoryService categoryService;

	public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
		this.productRepository = productRepository;
		this.categoryService = categoryService;
	}

	public PageDataDto<ProductDto> getProducts(Integer page, Integer pageSize, String sortField, String sortOrder, String search) {
		ProductSpecificationBuilder builder = new ProductSpecificationBuilder();
		Pattern pattern = Pattern.compile("(\\w+?)([:<>])(\\w+?),");//this pattern may be adjusted
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Product> spec = builder.build();
		Pageable pageable = getPageable(page, pageSize, sortField, sortOrder);
		Page<Product> productPage = productRepository.findAll(spec, pageable);
		return new PageDataDto<>(toDtos(productPage.getContent()), productPage.getTotalElements());
	}

	@Override
	public Product getProduct(Long id) throws ResourceNotFoundException {
		return loadProduct(id);
	}

	@Override
	public Collection<ProductDto> getCategoryProducts(Integer categoryId) throws ResourceNotFoundException {
		Category category = categoryService.loadCategory(categoryId);
		return toDtos(category.getProducts());
	}

	@Override
	public void createProducts(Collection<ProductDto> productDtos, Integer categoryId) throws ResourceNotFoundException {
		Category category = categoryService.loadCategory(categoryId);
		productRepository.saveAll(toModels(productDtos, category));
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, Long productId) throws ResourceNotFoundException {

		Product product = loadProduct(productId);
		product.setName(productDto.name);
		product.setDescription(productDto.description);
		product.setPrice(productDto.price);
		Product savedProduct = productRepository.save(product);
		return toDto(savedProduct);
	}

	@Override
	public void deleteProduct(Long productId) throws ResourceNotFoundException {
		loadProduct(productId);
		productRepository.deleteById(productId);
	}

	private Product loadProduct(Long productId) throws ResourceNotFoundException {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException((String.format("product with %s id not found", productId))));
	}

	private ProductDto toDto(Product product) {
		return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

	private List<ProductDto> toDtos(List<Product> products) {
		return products.stream().map(this::toDto).collect(Collectors.toList());
	}

	private Product toModel(ProductDto productDto, Category category) {
		return new Product(productDto.id, category, productDto.name, productDto.description, productDto.price);
	}

	private Collection<Product> toModels(Collection<ProductDto> productDtos, Category category) {
		return productDtos.stream().map(p -> toModel(p, category)).collect(Collectors.toList());
	}

	private Pageable getPageable(Integer page, Integer pageSize, String sortField, String sortOrder) {
		int p = page != null ? page : 0;
		int size = pageSize != null ? pageSize : 10;

		String field = sortField != null ? sortField : "name";
		Sort sort = Sort.by(field).ascending();
		if (sortOrder != null && sortOrder.equalsIgnoreCase("DESC")) {
			sort.descending();
		}
		return PageRequest.of(p, size, sort);
	}

}
