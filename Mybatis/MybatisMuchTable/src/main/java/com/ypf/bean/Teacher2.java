package com.ypf.bean;

public class Teacher2 {
	private  Integer id;   //老师或者导师的编号
	private  String  name;//老师或者导师的姓名
	// 多个老师对应一个导师
	private  Teacher2 teacher;

	public Teacher2() {
	}

	public Teacher2(Integer id, String name, Teacher2 teacher) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Teacher2{" +
				"id=" + id +
				", name='" + name + '\'' +
				", teacher=" + teacher +
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

	public Teacher2 getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher2 teacher) {
		this.teacher = teacher;
	}
}
