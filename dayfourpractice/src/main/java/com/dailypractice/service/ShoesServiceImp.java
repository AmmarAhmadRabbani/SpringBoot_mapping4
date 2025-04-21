package com.dailypractice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailypractice.dto.ShoesDto;
import com.dailypractice.entity.Shoes;
import com.dailypractice.entity.User;
import com.dailypractice.exceptiom.UserNotFoundException;
import com.dailypractice.repository.ShoesRepository;
import com.dailypractice.repository.UserRepository;

@Service
public class ShoesServiceImp implements ShoesService {
	@Autowired
	private ShoesRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ShoesDto addShoes(ShoesDto shoesDto) {
		User user = userRepository.findById(shoesDto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("user id not present"));
		Shoes shoes = new Shoes();
		BeanUtils.copyProperties(shoesDto, shoes);
		shoes.setUsers(List.of(user));
		Shoes save = repository.save(shoes);

		return shoesDto;
	}

	@Override
	public List<ShoesDto> getShoes() {
		List<Shoes> shoes = repository.findAll();
		List<ShoesDto> shoesDtoList = new ArrayList<>();
		if (shoes.isEmpty()) {
			throw new UserNotFoundException("shoes are not available");

		}
		shoes.forEach(i -> {
			ShoesDto shoesDto = new ShoesDto();
			BeanUtils.copyProperties(i, shoesDto);
			List<User> users = i.getUsers();

			BeanUtils.copyProperties(users, shoesDto);

			shoesDtoList.add(shoesDto);
		});
		return shoesDtoList;
	}

	@Override
	public List<ShoesDto> getById(long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("id not present"));
		List<Shoes> shoes = user.getShoes();
		List<ShoesDto> shoesDtosList = new ArrayList<>();
		shoes.forEach(i -> {
			ShoesDto shoesDto = new ShoesDto();
			BeanUtils.copyProperties(i, shoesDto);
			shoesDtosList.add(shoesDto);
		});

		return shoesDtosList;
	}

	@Override
	public ShoesDto updateShoes(ShoesDto shoesDto) {
		Shoes shoes = repository.findById(shoesDto.getShoesId())
				.orElseThrow(() -> new UserNotFoundException("invalid shoes id"));
		BeanUtils.copyProperties(shoesDto, shoes);
		Shoes save = repository.save(shoes);
		BeanUtils.copyProperties(save, shoesDto);

		return shoesDto;
	}

	@Override
	public ShoesDto deleteShoes(long shoesId) {
		Shoes shoes = repository.findById(shoesId).orElseThrow(() -> new UserNotFoundException("invalid id"));
		repository.deleteById(shoesId);

		return new ShoesDto();
	}

}
