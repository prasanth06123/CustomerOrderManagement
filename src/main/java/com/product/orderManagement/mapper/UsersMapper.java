package com.product.orderManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.product.orderManagement.dto.UsersDTO;
import com.product.orderManagement.entity.UsersEntity;

@Mapper
public interface UsersMapper {

	UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

	UsersEntity usersDTOTousersEntity(UsersDTO usersDTO);

}
