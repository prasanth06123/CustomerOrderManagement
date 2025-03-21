package com.product.orderManagement.dto;

import java.util.List;

import lombok.Builder;

@lombok.Data
@Builder
public class ProductOrderDTO {

	private Long id;
	private String referenceNo;
	private String customerName;
	private String mobileNumber;
	private String deliveryAddress;
	private String orderStatus;

	private List<ProductOrderItemDTO> orderItemsDTO;

}
