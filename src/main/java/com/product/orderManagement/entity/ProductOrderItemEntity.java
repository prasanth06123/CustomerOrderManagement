package com.product.orderManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@lombok.Data
@Builder
@Entity
@Table(name = "product_order_item")
public class ProductOrderItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "order_ref_no")
	private String orderRefNo;

	private int quantity;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "catalogue_code")
	private String catalogueCode;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_unit_price")
	private double productUnitPrice;

	public ProductOrderItemEntity() {

	}

	public ProductOrderItemEntity(Long id, String orderRefNo, int quantity, double totalPrice, String catalogueCode,
			String productCode, String productName, double productUnitPrice) {

		this.id = id;
		this.orderRefNo = orderRefNo;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.catalogueCode = catalogueCode;
		this.productCode = productCode;
		this.productName = productName;
		this.productUnitPrice = productUnitPrice;

	}

}
