package com.bezkoder.springgraphql.mysql.model;

import jakarta.persistence.*;

@Entity
public class Tutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_seq_gen")
	@SequenceGenerator(name = "tutorial_seq_gen", sequenceName = "tutorial_seq", allocationSize = 1)
	private Long id;

	private String title;
	private String description;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	public Tutorial() {
	}

	public Tutorial(String title, String description, Author author) {
		this.title = title;
		this.description = description;
		this.author = author;
	}

	public Long getId() {
		return id;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author + "]";
	}

}
