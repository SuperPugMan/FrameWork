package com.ypf.bean;

public class Provincial {
  private Integer pId;
  private String pName;
  private Country country;

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "Provincial{" + "pId=" + pId + ", pName='" + pName + '\'' + '}';
  }

  public Integer getpId() {
    return pId;
  }

  public void setpId(Integer pId) {
    this.pId = pId;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }
}
