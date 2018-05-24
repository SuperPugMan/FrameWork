package com.ypf.dao;

import com.ypf.bean.Country;
import com.ypf.bean.Provincial;

import java.io.Serializable;

public interface CountryDao {
  // 根据国家ID查询省会
  Country selectCountByCId(Integer id);
  // 根据省会ID查询国家
  Provincial selectByProvincalId(Integer id);

  /**
   * 验证一级缓存查询
   *
   */
  Country selectCountryById2(Serializable id);

  /**
   * 增删改对一级缓存的影响
   */
  int executeCountry(Country cou);
}
