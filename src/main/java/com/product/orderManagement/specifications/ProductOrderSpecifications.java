package com.product.orderManagement.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.product.orderManagement.entity.ProductOrderEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class ProductOrderSpecifications {

	public static <T> Specification<T> getSpecifications(List<Map<String, Object>> filterDataList) {

		return (root, criteriaQuery, criteriaBuilder) -> {

			List<Predicate> predicates = new ArrayList<>();
			filterDataList.forEach(item -> {
				predicates.add(criteriaBuilder.equal(root.get(String.valueOf(item.get("fieldKey"))),
						String.valueOf(item.get("fieldValue"))));
			});
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<ProductOrderEntity> hasName(@NonNull String customerName) {
		return (Root<ProductOrderEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> cb
				.equal(root.get("customerName"), customerName);
	}

	public static Specification<ProductOrderEntity> hasMobileNumber(String mobileNumber) {
		return (Root<ProductOrderEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> cb
				.equal(root.get("mobileNumber"), mobileNumber);
	}
}
