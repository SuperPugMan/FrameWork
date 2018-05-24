package com.ypf;

import com.ypf.bean.Country;
import com.ypf.bean.Provincial;
import com.ypf.bean.Student;
import com.ypf.dao.CountryDao;
import com.ypf.dao.StudentDao;
import com.ypf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {
  Logger log = Logger.getLogger(StudentTest.class);
  SqlSession session = null;
  StudentDao dao = null;
  CountryDao couDao = null;

  /**
   * 使用Mapper动态代理 mapper.xml中的namespace必须是dao接口的全类名 xml文件中的增删改查节点的id必须与dao接口中方法相同
   * 在运行之前代理获取dao接口的所有方法， 在运行之后提交
   */
  @Before
  public void before() {
    session = SessionFactoryUtil.getSession();
    dao = session.getMapper(StudentDao.class);
    couDao = session.getMapper(CountryDao.class);
  }

  @After
  public void after() {
    if (session != null) {
      session.close();
    }
  }

  @Test
  public void testAddStudent() {
    Student stu = new Student();
    stu.setPhone("18510783381");
    log.debug("insert之前学生的编号" + stu.getStudentNo());
    dao.addStudent(stu);
    log.debug("insert之后学生的编号" + stu.getStudentNo());
    session.commit();
  }

  @Test
  public void testAddStudentByCached() {
    Student student = new Student();
    student.setPhone("18536259645");
    log.debug("增加查询方法后insert之前的编号" + student.getStudentId());
    dao.addStudentByCache(student);
    log.debug("增加查询方法后insert之后的编号" + student.getStudentId());
    session.commit();
  }

  @Test
  public void testSelectListStudent() {
    List<Student> students = null;
    students = dao.selectAllStudents();
    log.debug("查询所有学生" + students);
  }

  @Test
  public void updateStudent() {
    Student stu = new Student();
    stu.setPhone("18536264578");
    stu.setStudentNo(32);
    stu.setStudentNo(29);
    dao.updateStudent(stu);
    log.debug("更新学生--" + stu.getStudentNo());
    session.commit();
  }

  @Test
  public void deleteStudent() {
    dao.deleteStudent(29);
    log.debug("删除成功");
    session.commit();
  }

  @Test
  public void selectAllMap() {
    List<Map<String, Object>> maps = dao.selectAllMap();
    log.debug(maps);
  }

  @Test
  public void selectStudentBuId() {
    Student stu = null;
    stu = dao.selectStudentBuId(29);
    log.debug(stu);
  }

  @Test
  public void selectById() {
    List<Student> students = dao.selectById(2);
    log.debug(students);
  }

  /** 指定Map集合方式来模糊查询指定集合 */
  @Test
  public void testMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("telphone", 8);
    map.put("studentId", 26);
    List<Student> students = dao.selectByMap(map);
    log.debug(students);
  }

  /** 使用map查询指定集合,集合中存在对象的方式 */
  @Test
  public void testMap2() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("telphone", 8);
    Student student = dao.selectStudentBuId(26);
    map.put("stu", student);
    List<Student> students = dao.selectByMap(map);
    log.debug(students);
  }

  /** 传入参数形式模糊查询 */
  @Test
  public void testCondition() {
    List<Student> students = dao.selectStudentByCondition(26, 3);
    log.debug(students);
  }

  /** 传入参数形式模糊查询 */
  @Test
  public void testConditiontwo() {
    List<Student> students = dao.selectStudentByConditionTwo(26, 3);
    log.debug(students);
  }

  /** if标签语句的使用 */
  @Test
  public void testif() {
    Student stu = new Student();
    stu.setStudentNo(29);
    List<Student> students = dao.selectAllUserByIf(stu);
    log.debug(students);
  }

  /*where标签的使用*/
  @Test
  public void testWhere() {
    Student stu = new Student();
    stu.setStudentNo(29);
    List<Student> students = dao.selectAllUserBuWhere(stu);
    log.debug(students);
  }

  /*choose标签的使用*/
  @Test
  public void testChoose() {
    Student stu = new Student();
    stu.setStudentNo(29);
    List<Student> students = dao.selectAllUserByChoose(stu);
    log.debug(students);
  }

  // 遍历数组使用
  @Test
  public void selectAllUserByArrayTest() {
    int[] phone = {1, 8, 3};
    List<Student> students = dao.selectAllUserByArray(phone);
    System.out.println(students);
  }

  // 遍历List使用
  @Test
  public void testselectAllUserByList() {
    List<Integer> list = new ArrayList<>();
    list.add(26);
    list.add(85);
    list.add(81);
    List<Student> students = dao.selectAllUserByList(list);
    System.out.println(students);
  }

  // 遍历student对象集合使用
  @Test
  public void testselectAllUserByUserList() {
    List<Student> list = new ArrayList<>();
    list.add(new Student(32, 56));
    list.add(new Student(23, 96));
    List<Student> students = dao.selectAllUserByUserList(list);
    System.out.println(students);
  }

  // 遍历student对象Map集合使用
  @Test
  public void testselectAllUserByMap() {
    Map<String, Object> maps = new HashMap<String, Object>();
    maps.put("23", "59");
    maps.put("10", "95");
    List<Student> list = dao.selectAllUserByMap(maps);
    System.out.println(list);
  }

  // 一个国家对应多个省
  //
  // 一对多--延迟加载
  @Test
  public void getCountryById() {
    Country country = couDao.selectCountByCId(1);
    // 开始延迟加载，会产生1条，只查询国家
    System.out.println(country.getcName());
    // 如果开启了延迟加载，这时才会执行对应的省会
    System.out.println(country.getProcvincials());
  }

  // 多个省对应一个国家
  //
  // 多对一--延迟加载
  @Test
  public void getCountryByPrvincanId() {
    Provincial pro = couDao.selectByProvincalId(1);
    System.out.println(pro.getpName());
    System.out.println(pro.getCountry().getcName());
  }

  /**
   * 自连接多对一
   *
   * <p>一个导师对应多个老师
   */
}
