package com.github.aakke.javaspringproject.model;

import java.time.Instant;


import jakarta.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class AbstractBaseEntity {

	@Column(name="created_on")
	@CreationTimestamp
	private Instant createdOn;
	
	@Column(name="last_modified")
	@UpdateTimestamp
	private Instant lastModified;
	
}
