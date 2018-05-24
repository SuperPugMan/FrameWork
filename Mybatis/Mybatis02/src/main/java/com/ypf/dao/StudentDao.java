package com.ypf.dao;

import com.ypf.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface StudentDao {

  /** 新增 */
  void addStudent(Student stu);

  /** 新增返回ID值 */
  void addStudentByCache(Student student);
  /** 删除 */
  void deleteStudent(Serializable id);

  /** 修改 */
  void updateStudent(Student stu);

  /** 查询所有 */
  List<Student> selectAllStudents();

  /** 查询返回所有的map集合 */
  List<Map<String, Object>> selectAllMap();

  /** 查询指定id的学生 */
  Student selectStudentBuId(Serializable id);

  /** 根据姓名模糊查询 */
  List<Student> selectById(Serializable id);

  /**
   * 如果前台表单给出的查询条件不能封装成一个对象的时候 我们可以使用两种方式来解决这个问题
   *
   * <p>第一种方式： 把查询条件封装成Map 使用map封装查询
   */
  List<Student> selectByMap(Map<String, Object> map);

  /** 第二种方式：直接跟多个参数 */
  List<Student> selectStudentByCondition(int phone, int studentId);

  /**
   * 通过注解传入参数
   *
   * @param phone
   * @param studentId
   * @return
   */
  List<Student> selectStudentByConditionTwo(
      @Param("phone") int phone, @Param("studentId") int studentId);

  /** 根据用户传递的参数，来确定执行的sql语句，用户传递一个对象 ,if语句的使用 */
  List<Student> selectAllUserByIf(Student student);

  /** 根据用户传递的参数，来确定执行的sql语句，用户传递一个对象，where 语句替代where 1=1 */
  List<Student> selectAllUserBuWhere(Student student);

  /**
   * 根据用户传递的参数，来确定执行的SQL语句，用户传递一个对象，选择choose来判断。
   *
   * <p>if只能判断一个条件，choose可以在when中判断多种条件
   */
  List<Student> selectAllUserByChoose(Student student);

  /**
   * foreach遍历数组
   *
   * <p>判断长度时只能使用array.length
   */
  List<Student> selectAllUserByArray(int[] array);

  /**
   * foreach遍历list
   *
   * <p>判断长度只能使用list.size
   */
  List<Student> selectAllUserByList(List<Integer> students);

  /**
   * foreach遍历对象List
   *
   * <p>判断list只能用list
   */
  List<Student> selectAllUserByUserList(List<Student> students);

  /**
   * foreach遍历Map
   *
   * <p>Map参数需要注解自己定义，遍历key，然后根据可以获取value即可
   */
  List<Student> selectAllUserByMap(@Param("map") Map<String, Object> students);
}
