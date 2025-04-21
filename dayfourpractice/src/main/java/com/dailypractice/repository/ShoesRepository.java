package com.dailypractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailypractice.entity.Shoes;

public interface ShoesRepository extends JpaRepository<Shoes, Long> {

}
