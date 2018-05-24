package com.ypf.bean;

import java.util.Set;

public class Teacher {
	//老师或导师编号
	private Integer id;
	//老师或导师的姓名
	private String name;
	//一个导师可以有多个老师
	private Set<Teacher> teachers;

	@Override
	public String toString() {
		return "Teacher{" +
				"id=" + id +
				", name='" + name + '\'' +
				", teachers=" + teachers +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
}
