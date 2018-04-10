package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Indexed;

@Entity
@Indexed
@Table(name = "tv_series t")
public class TVSeries {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "title", nullable = false, length = 128)
	private String title;
	@Column(name = "description", nullable = false, length = 256)
	private String description;
	@Column(name = "creator", nullable = false, length = 64)
	private String creator;

	public TVSeries() {
	}

	public TVSeries(int id, String title, String description, String creator) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.creator = creator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
}
