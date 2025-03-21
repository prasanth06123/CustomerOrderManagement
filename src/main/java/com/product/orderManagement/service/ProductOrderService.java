package com.product.orderManagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.product.orderManagement.dto.ProductOrderDTO;
import com.product.orderManagement.entity.ProductOrderEntity;
import com.product.orderManagement.mapper.ProductOrderMapper;
import com.product.orderManagement.repository.ProductOrderRepository;
import com.product.orderManagement.specifications.ProductOrderSpecifications;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductOrderService {

	private final ProductOrderRepository productOrderRepository;

	public ProductOrderEntity createProductOrder(ProductOrderDTO productOrderDTO) {

		ProductOrderEntity productOrderEntity = ProductOrderMapper.INSTANCE
				.ProductOrderDTOToProductOrderEntity(productOrderDTO);
		return productOrderRepository.save(productOrderEntity);
	}

	@SuppressWarnings("unchecked")
	public List<ProductOrderEntity> getProductOrderByCustomer(@Valid Map<String, Object> filterData) {

		if (filterData.isEmpty()) {

			List<Map<String, Object>> filterDataList = (List<Map<String, Object>>) filterData.get("filterData");
			Specification<ProductOrderEntity> finalSpec = ProductOrderSpecifications.getSpecifications(filterDataList);
			return productOrderRepository.findAll(finalSpec);
		}
		return null;
	}

	public Page<ProductOrderEntity> getAllProductOrders(int pageNumber, int pageSize, String sortDirection,
			String sortBy) {

		Sort sort = sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Specification<ProductOrderEntity> spec = Specification
				.where(ProductOrderSpecifications.hasName("customerName"));
		return productOrderRepository.findAll(spec, pageable);
	}

	public ProductOrderEntity updateProductCatalogue(ProductOrderEntity productOrderEntity) {

		ProductOrderEntity existingProductOrderData = productOrderRepository
				.findByReferenceNo(productOrderEntity.getReferenceNo());
		if (existingProductOrderData != null && existingProductOrderData.getId() > 0) {
			existingProductOrderData = productOrderRepository.save(productOrderEntity);
		}
		return existingProductOrderData;
	}

	public List<ProductOrderEntity> getProductOrderByMobileNumber(String mobileNumber) {

		if (!mobileNumber.isEmpty()) {
			Specification<ProductOrderEntity> spec = Specification
					.where(ProductOrderSpecifications.hasMobileNumber(mobileNumber));
			return productOrderRepository.findAll(spec);
		}
		return null;
	}

}
