package com.ypf.bean;

import java.util.Set;

public class Country {
  // 国家编号
  private Integer cId;
  // 国家名称
  private String cName;
  // 一个国家对应N个省会
  private Set<Provincial> procvincials;

  public Set<Provincial> getProcvincials() {
    return procvincials;
  }

  public void setProcvincials(Set<Provincial> procvincials) {
    this.procvincials = procvincials;
  }

  @Override
  public String toString() {
    return "Country{" + "cId=" + cId + ", cName='" + cName + '\'' + ", procvincials=";
  }

  public Integer getcId() {
    return cId;
  }

  public void setcId(Integer cId) {
    this.cId = cId;
  }

  public String getcName() {
    return cName;
  }

  public void setcName(String cName) {
    this.cName = cName;
  }
}
