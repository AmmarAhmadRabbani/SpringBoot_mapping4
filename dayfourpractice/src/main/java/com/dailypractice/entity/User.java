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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String facebookId;
	private String googleId;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
	private List<Shoes> shoes;

}
