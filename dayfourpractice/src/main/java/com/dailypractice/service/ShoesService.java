package com.dailypractice.service;

import java.util.List;

import com.dailypractice.dto.ShoesDto;

public interface ShoesService {
	public ShoesDto addShoes(ShoesDto shoesDto);

	public List<ShoesDto> getShoes();

	public List<ShoesDto> getById(long userId);

	public ShoesDto updateShoes(ShoesDto shoesDto);

	public ShoesDto deleteShoes(long shoesId);

}
