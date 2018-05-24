package com.ypf;

import com.ypf.bean.Country;
import com.ypf.bean.Provincial;
import com.ypf.bean.Teacher;
import com.ypf.bean.Teacher2;
import com.ypf.dao.CountryDao;
import com.ypf.dao.TeacherDao;
import com.ypf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class StudentTest {
  Logger log = Logger.getLogger(StudentTest.class);
  SqlSession session = null;
  CountryDao couDao = null;
  TeacherDao teaDao=null;

  /**
   * 使用Mapper动态代理 mapper.xml中的namespace必须是dao接口的全类名 xml文件中的增删改查节点的id必须与dao接口中方法相同
   * 在运行之前代理获取dao接口的所有方法， 在运行之后提交
   */
  @Before
  public void before() {
    session = SessionFactoryUtil.getSession();
    couDao = session.getMapper(CountryDao.class);
    teaDao = session.getMapper(TeacherDao.class);
  }

  @After
  public void after() {
    if (session != null) {
      session.close();
    }
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

  //根据导师的编号查询出所有老师的信息。递归查询
  @Test
  public void selectTeacherById(){
    List<Teacher> teachers = teaDao.selectTeacherByTid(2);
    System.out.println(teachers);
  }

  //根据导师的编号查询出所有老师的信息，递归查询，自连接一对多
  @Test
  public void selectTeacherByIt(){
    Teacher teacher =teaDao.selectTeacherById(6);
    System.out.println(teacher);
  }

  //根据导师的编号查询出所有老师的信息，递归查询，自连接多对一
  @Test
  public void selectTeacherByIdTwo(){
    Teacher2 teacher=teaDao.selectTeacherByIdTwo(6);
    System.out.println(teacher);
  }

  /**
   * 验证一级缓存查询
   */
  @Test
  public void selectCountryById(){
    Country country = couDao.selectCountryById2(1);
    System.out.println(country);
    country=couDao.selectCountryById2(1);
    System.out.println(country);
  }

  /**
   * 增删改对一级缓存的影响
   */
  @Test
  public void selectCountryById2(){
    Country country = couDao.selectCountryById2(1);
    System.out.println(country);
    Country cou=new Country();
    cou.setcId(3);
    cou.setcName("American");
    couDao.executeCountry(cou);
    country=couDao.selectCountryById2(1);
    System.out.println(country);
  }



/**
 * 验证二级缓存
 */
@Test
public void selectStudentById(){
  Teacher teacher = teaDao.selectStudentById(2);
    System.out.println(teacher);
}

/**
 * 设置false属性后增删改对二级缓存的影响
 */
@Test
public void addstudent(){
  Teacher tea=new Teacher();
  tea.setId(9);
  tea.setName("asd");
  teaDao.addstudent(tea);
}
}
