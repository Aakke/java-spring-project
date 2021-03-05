package com.github.aakke.javaspringproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends AbstractBaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable=false, length=255)
	private String name;
	
	@Column(nullable=false)
	private int published;
	
	@ManyToOne
	@JoinColumn(name="author_id", nullable=false)
	private Author author;
	
	@ManyToOne
	@JoinColumn(name="reader_id")
	private Reader reader;

}
