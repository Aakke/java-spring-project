package com.github.aakke.javaspringproject.persistence.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Reader extends AbstractBaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false, length=255)
	private String firstName;
	
	@Column(nullable=false, length=255)
	private String lastName;
	
	@Column(nullable=false)
	private int birthYear;
	
	@Column(nullable=false, length=255)
	private String address;
	
	@ElementCollection
	private Set<Long> readBooks = new LinkedHashSet<>();

}
