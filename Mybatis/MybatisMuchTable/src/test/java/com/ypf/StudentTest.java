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
   * ʹ��Mapper��̬���� mapper.xml�е�namespace������dao�ӿڵ�ȫ���� xml�ļ��е���ɾ�Ĳ�ڵ��id������dao�ӿ��з�����ͬ
   * ������֮ǰ�����ȡdao�ӿڵ����з����� ������֮���ύ
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

  // һ�����Ҷ�Ӧ���ʡ
  //
  // һ�Զ�--�ӳټ���
  @Test
  public void getCountryById() {
    Country country = couDao.selectCountByCId(1);
    // ��ʼ�ӳټ��أ������1����ֻ��ѯ����
    System.out.println(country.getcName());
    // ����������ӳټ��أ���ʱ�Ż�ִ�ж�Ӧ��ʡ��
    System.out.println(country.getProcvincials());
  }

  // ���ʡ��Ӧһ������
  //
  // ���һ--�ӳټ���
  @Test
  public void getCountryByPrvincanId() {
    Provincial pro = couDao.selectByProvincalId(1);
    System.out.println(pro.getpName());
    System.out.println(pro.getCountry().getcName());
  }

  //���ݵ�ʦ�ı�Ų�ѯ��������ʦ����Ϣ���ݹ��ѯ
  @Test
  public void selectTeacherById(){
    List<Teacher> teachers = teaDao.selectTeacherByTid(2);
    System.out.println(teachers);
  }

  //���ݵ�ʦ�ı�Ų�ѯ��������ʦ����Ϣ���ݹ��ѯ��������һ�Զ�
  @Test
  public void selectTeacherByIt(){
    Teacher teacher =teaDao.selectTeacherById(6);
    System.out.println(teacher);
  }

  //���ݵ�ʦ�ı�Ų�ѯ��������ʦ����Ϣ���ݹ��ѯ�������Ӷ��һ
  @Test
  public void selectTeacherByIdTwo(){
    Teacher2 teacher=teaDao.selectTeacherByIdTwo(6);
    System.out.println(teacher);
  }

  /**
   * ��֤һ�������ѯ
   */
  @Test
  public void selectCountryById(){
    Country country = couDao.selectCountryById2(1);
    System.out.println(country);
    country=couDao.selectCountryById2(1);
    System.out.println(country);
  }

  /**
   * ��ɾ�Ķ�һ�������Ӱ��
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
 * ��֤��������
 */
@Test
public void selectStudentById(){
  Teacher teacher = teaDao.selectStudentById(2);
    System.out.println(teacher);
}

/**
 * ����false���Ժ���ɾ�ĶԶ��������Ӱ��
 */
@Test
public void addstudent(){
  Teacher tea=new Teacher();
  tea.setId(9);
  tea.setName("asd");
  teaDao.addstudent(tea);
}
}
