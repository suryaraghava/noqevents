package com.noq.domain;

// Generated May 3, 2014 8:01:12 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Eventcategory generated by hbm2java
 */
@Entity
@Table(name = "eventcategory", catalog = "noqshows_test")
public class Eventcategory implements java.io.Serializable {

	private Integer id;
	private String category;

	public Eventcategory() {
	}

	public Eventcategory(String category) {
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "category", length = 45)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
