package com.ypf.dao;

import com.ypf.bean.Teacher;
import com.ypf.bean.Teacher2;

import java.io.Serializable;
import java.util.List;

public interface TeacherDao {
	/**
	 * 根据导师的编号查询出所有老师的信息
	 */
	List<Teacher>selectTeacherByTid(Serializable id);

	/**
	 * 自联表查询，多对一
	 * 根据老师的编号，查询出自身的信息和所有导师的信息
	 */
	Teacher selectTeacherById(Serializable id);

	/**
	 * 自联表查询，一对多
	 * 根据老师的编号，查询出自身的信息和所有导师的信息
	 */

	Teacher2 selectTeacherByIdTwo(Serializable id);


	/**
	 * 2级缓存的使用：
	 * 1. 引入2个jar包，一个是ehcache，还有一个是mybatis-ehcache
	 * 2. 需要缓存的类，必须实现serializable接口。
	 * 3. 如果不设置其他参数，默认增删改查会清除2级缓存中的数据。
	 */
	Teacher selectStudentById(Serializable id );
	/**
	 * 验证增删改操作对数据的影响
	 */
	void  addstudent(Teacher tea);
	}
