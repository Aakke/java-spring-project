package com.github.aakke.javaspringproject.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Reader extends AbstractBaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false, length=255)
	private String firstName;
	
	@Column(nullable=false, length=255)
	private String lastName;
	
	@Column(nullable=false)
	private int birthYear;
	
	@Column(nullable=false, length=255)
	private String address;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Book> readBooks = new LinkedHashSet<>();

}
