package com.terra.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.terra.pojos.ReturnOrderInput;

@Entity
@Table(name = "returnOrder")
public class ReturnOrderDTO extends ReturnOrderInput {

}
