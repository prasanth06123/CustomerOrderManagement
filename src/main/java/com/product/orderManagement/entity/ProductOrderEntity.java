package com.product.orderManagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;

@lombok.Data
@Builder
@Entity
@Table(name = "product_order")
public class ProductOrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "reference_no")
	private String referenceNo;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "delivery_address")
	private String deliveryAddress;

	@Column(name = "order_status")
	private String orderStatus;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<ProductOrderItemEntity> orderItemsEntity;

	public ProductOrderEntity() {

	}

	public ProductOrderEntity(Long id, String referenceNo, String customerName, String mobileNumber,
			String deliveryAddress, String orderStatus, List<ProductOrderItemEntity> orderItemsEntity) {

		this.id = id;
		this.referenceNo = referenceNo;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.deliveryAddress = deliveryAddress;
		this.orderStatus = orderStatus;
		this.orderItemsEntity = orderItemsEntity;
	}

}
