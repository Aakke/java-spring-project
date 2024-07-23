package com.github.aakke.javaspringproject.persistence.model;

import java.time.Instant;


import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class AbstractBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Version
	private Integer version;

	@Column(name="created_on")
	@CreationTimestamp
	private Instant createdOn;
	
	@Column(name="last_modified")
	@UpdateTimestamp
	private Instant lastModified;
	
}
