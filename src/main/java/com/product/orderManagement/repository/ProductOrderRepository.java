package com.product.orderManagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.product.orderManagement.entity.ProductOrderEntity;

public interface ProductOrderRepository
		extends JpaRepository<ProductOrderEntity, Long>, JpaSpecificationExecutor<ProductOrderEntity> {

	List<ProductOrderEntity> findAll(Specification<ProductOrderEntity> specProductOrderEntity);

	Page<ProductOrderEntity> findAll(Pageable pageable);

	Page<ProductOrderEntity> findAll(Specification<ProductOrderEntity> specProductOrderEntity, Pageable pageable);

	ProductOrderEntity findByReferenceNo(String referenceNo);

}
