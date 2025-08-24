package com.bezkoder.springgraphql.postgres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq_gen")
	@SequenceGenerator(name = "author_seq_gen", sequenceName = "author_seq", allocationSize = 1)
	private Long id;

	private String name;
	private Integer age;

	public Author() {
	}

	public Author(Long id) {
		this.id = id;
	}

	public Author(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
