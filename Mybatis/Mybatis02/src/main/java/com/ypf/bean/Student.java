package com.ypf.bean;

public class Student {
  private int studentNo;
  private int studentId;
  private String phone;

  public Student(int studentNo, int studentId) {
    this.studentNo = studentNo;
    this.studentId = studentId;
  }

  public Student(int studentNo) {
    this.studentNo = studentNo;
  }

  public Student() {}

  public int getStudentNo() {
    return studentNo;
  }

  public void setStudentNo(int studentNo) {
    this.studentNo = studentNo;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "Student{"
        + "studentNo="
        + studentNo
        + ", studentId='"
        + studentId
        + '\''
        + ", phone='"
        + phone
        + '\''
        + '}';
  }
}
