package com.returnorder.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terra.dto.ReturnOrderDTO;

public interface ReturnOrderRepository extends JpaRepository<ReturnOrderDTO, String> {

}
