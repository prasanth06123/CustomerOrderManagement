package com.product.orderManagement.dto;

import lombok.Builder;

@lombok.Data
@Builder
public class ProductOrderItemDTO {

	private Long id;
	private String orderRefNo;
	private int quantity;
	private double totalPrice;
	private String catalogueCode;
	private String productCode;
	private String productName;
	private double productUnitPrice;

}
