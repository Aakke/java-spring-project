package com.github.aakke.javaspringproject.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

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
@EqualsAndHashCode(callSuper = true)
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
	
	@OneToMany(mappedBy = "reader")
	private Set<Book> readBooks = new LinkedHashSet<>();


	/**
	 * Helper method for adding book for reader. 
	 * @param book book
	 */
	public void addBook(Book book) {
		this.readBooks.add(book);
		book.setReader(this);
	}

}
