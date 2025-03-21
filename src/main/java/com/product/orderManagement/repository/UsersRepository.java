package com.product.orderManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.product.orderManagement.entity.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Long>, JpaSpecificationExecutor<UsersEntity> {

	UsersEntity findByMobileNumber(String mobileNumber);

}
