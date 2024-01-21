package com.swagger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PersonPayloadOutput {
	private boolean isRegister;
}
