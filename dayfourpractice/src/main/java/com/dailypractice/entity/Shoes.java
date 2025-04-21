

package com.dailypractice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shoes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shoesId;
	private long shoesCode;
	private String color;
	private String shoesType;
	private String price;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users;

}
