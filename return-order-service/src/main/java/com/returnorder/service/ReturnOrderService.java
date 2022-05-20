package com.returnorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnorder.repo.ReturnOrderRepository;
import com.terra.dto.ReturnOrderDTO;
import com.terra.result.Result;
import com.terra.util.ErrorMessages;

@Service
public class ReturnOrderService {
	@Autowired
	ReturnOrderRepository repo;

	public Result saveReturnOrder(ReturnOrderDTO dto) {
		repo.save(dto);
		return new Result(200, ErrorMessages.SAVE_SUCCESSFUL);
	}

}
