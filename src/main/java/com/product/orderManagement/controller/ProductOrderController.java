package com.product.orderManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.product.orderManagement.api.ProductOrderAPI;
import com.product.orderManagement.dto.ProductOrderDTO;
import com.product.orderManagement.entity.ProductOrderEntity;
import com.product.orderManagement.service.ProductOrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductOrderController implements ProductOrderAPI {

	private final ProductOrderService productOrderService;

	@Override
	public ResponseEntity<ProductOrderEntity> createProductOrder(@Valid ProductOrderDTO productOrderDTO) {

		ProductOrderEntity productOrderEntityData = productOrderService.createProductOrder(productOrderDTO);
		return new ResponseEntity<>(productOrderEntityData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Page<ProductOrderEntity>> getAllProductOrders(int pageNumber, int pageSize,
			String sortDirection, String sortBy) {

		Page<ProductOrderEntity> productOrderEntityList = productOrderService.getAllProductOrders(pageNumber, pageSize,
				sortDirection, sortBy);
		return new ResponseEntity<>(productOrderEntityList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ProductOrderEntity>> getProductOrderByCustomer(
			@Valid Map<String, Object> filterDataList) {

		List<ProductOrderEntity> productOrderEntityData = productOrderService.getProductOrderByCustomer(filterDataList);
		return new ResponseEntity<>(productOrderEntityData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ProductOrderEntity> updateProductOrder(ProductOrderEntity productOrderEntity) {

		ProductOrderEntity ProductOrderEntityData = productOrderService.updateProductCatalogue(productOrderEntity);
		return new ResponseEntity<>(ProductOrderEntityData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ProductOrderEntity>> getProductOrderByMobileNumber(String mobileNumber) {

		List<ProductOrderEntity> productOrderEntityData = productOrderService
				.getProductOrderByMobileNumber(mobileNumber);
		return new ResponseEntity<>(productOrderEntityData, HttpStatus.OK);
	}

}
