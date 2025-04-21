package com.dailypractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailypractice.dto.ShoesDto;
import com.dailypractice.response.SuccessResponse;
import com.dailypractice.service.ShoesService;

@RestController
public class ShoesController {
	@Autowired
	private ShoesService service;

	@PostMapping("/addShoes")
	public ResponseEntity<SuccessResponse> addShoes(@RequestBody ShoesDto shoesDto) {
		ShoesDto addShoes = service.addShoes(shoesDto);
		if (addShoes != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "added", addShoes), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "not added", null), HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getShoes")
	public ResponseEntity<SuccessResponse> getShoes() {
		List<ShoesDto> shoes = service.getShoes();
		if (shoes != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "getting succesfully", shoes), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "getting failed", null), HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getShoes/{userId}")
	public ResponseEntity<SuccessResponse> getShoesById(@PathVariable long userId) {
		List<ShoesDto> byId = service.getById(userId);
		if (byId != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "get successfull", byId), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "getting failed", null), HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/updateshoes")
	public ResponseEntity<SuccessResponse> updateShoes(@RequestBody ShoesDto shoesDto) {
		ShoesDto updateShoes = service.updateShoes(shoesDto);
		if (updateShoes != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "updated", updateShoes), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "updation failed", null), HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteShoes/{shoesId}")
	public ResponseEntity<SuccessResponse> deleteShoes(@PathVariable long shoesId) {
		ShoesDto deleteShoes = service.deleteShoes(shoesId);
		if (deleteShoes != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "deletd", deleteShoes), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "not deleted", null), HttpStatus.BAD_REQUEST);
	}
}