package com.github.aakke.javaspringproject.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class AbstractBaseEntity {

	@Column(name="created_on")
	@CreationTimestamp
	private Instant createdOn;
	
	@Column(name="last_modified")
	@UpdateTimestamp
	private Instant lastModified;

	/**
	 * @return the createdOn
	 */
	public Instant getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the lastModified
	 */
	public Instant getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Instant lastModified) {
		this.lastModified = lastModified;
	}
	
	
}
