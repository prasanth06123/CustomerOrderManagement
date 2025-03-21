package com.product.orderManagement.api;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.orderManagement.dto.ProductOrderDTO;
import com.product.orderManagement.entity.ProductOrderEntity;

import jakarta.validation.Valid;

public interface ProductOrderAPI {

	@PostMapping("/api/createProductOrder")
	ResponseEntity<ProductOrderEntity> createProductOrder(@RequestBody @Valid ProductOrderDTO productOrderDTO);

	@GetMapping("/api/getAllProductOrders/{pageNumber}/{pageSize}/{sortDirection}/{sortBy}")
	ResponseEntity<Page<ProductOrderEntity>> getAllProductOrders(@PathVariable int pageNumber,
			@PathVariable int pageSize, @PathVariable String sortDirection, @PathVariable String sortBy);

	@PostMapping("/api/getProductOrder")
	ResponseEntity<List<ProductOrderEntity>> getProductOrderByCustomer(
			@RequestBody @Valid Map<String, Object> filterData);

	@GetMapping("/api/getProductOrderByMobileNumber/{mobileNumber}")
	ResponseEntity<List<ProductOrderEntity>> getProductOrderByMobileNumber(@PathVariable String mobileNumber);

	@PutMapping("/api/updateProductOrder")
	ResponseEntity<ProductOrderEntity> updateProductOrder(@RequestBody ProductOrderEntity orderEntity);

}
