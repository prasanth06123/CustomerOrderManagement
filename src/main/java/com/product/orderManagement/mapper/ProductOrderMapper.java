package com.product.orderManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.product.orderManagement.dto.ProductOrderDTO;
import com.product.orderManagement.entity.ProductOrderEntity;

@Mapper
public interface ProductOrderMapper {

	ProductOrderMapper INSTANCE = Mappers.getMapper(ProductOrderMapper.class);

	@Mapping(source = "orderItemsDTO", target = "orderItemsEntity")
	ProductOrderEntity ProductOrderDTOToProductOrderEntity(ProductOrderDTO productOrderDTO);

}
