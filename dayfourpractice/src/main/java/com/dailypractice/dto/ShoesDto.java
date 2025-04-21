package com.dailypractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoesDto {
	private long shoesId;
	private long shoesCode;
	private String color;
	private String shoesType;
	private String price;

	private long userId;

}
