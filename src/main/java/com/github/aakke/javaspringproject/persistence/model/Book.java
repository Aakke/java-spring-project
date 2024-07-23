package com.github.aakke.javaspringproject.persistence.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Book extends AbstractBaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=255)
	private String name;
	
	@Column(nullable=false)
	private int published;

}
