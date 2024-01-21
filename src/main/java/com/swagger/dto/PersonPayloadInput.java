package com.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonPayloadInput {
	
	@ApiModelProperty(value = "First Name", example = "FirstName", dataType = "string")
	private String firstName;

	@ApiModelProperty(value = "Last Name", example = "LastName", dataType = "string")
	private String lastName;

	@ApiModelProperty(value = "Last Name", example = "19", dataType = "integer")
	private int age;

	@ApiModelProperty(value = "Adress", example = "123 Somewhere St", dataType = "string")
	private String address;

	@ApiModelProperty(value = "City", example = "Chicago", dataType = "string")
	private String city;

	@ApiModelProperty(value = "State", example = "IL", dataType = "string")
	private String state;

	@ApiModelProperty(value = "Country", example = "USA", dataType = "string")
	private String country;

	@ApiModelProperty(value = "Date", example = "2023-12-01", dataType = "string")
	private String date;
}
