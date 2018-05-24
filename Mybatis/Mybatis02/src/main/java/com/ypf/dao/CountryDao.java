package com.ypf.dao;

import com.ypf.bean.Country;
import com.ypf.bean.Provincial;

public interface CountryDao {
  // 根据国家ID查询省会
  Country selectCountByCId(Integer id);
  // 根据省会ID查询国家
  Provincial selectByProvincalId(Integer id);
}
