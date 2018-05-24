package com.ypf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  /** 鸡兔同笼 鸡兔共50，公有脚120 */
  @org.junit.Test
  public void test01() {
    for (int i = 0; i < 50; i++) {
      int j = 50 - i;
      if (2 * j + 4 * i == 120) {
        System.out.println("鸡--" + j + "兔--" + i);
      }
    }
  }
  /** 韩信点兵 有1000多个人，五队余1，7队余2，8队余3 */
  @org.junit.Test
  public void test02() {
    for (int i = 1000; i < 2000; i++) {
      if (i % 5 == 1 && i % 7 == 2 && i % 8 == 3) {
        System.out.println(i);
      }
    }
  }
  /** 需找零8元 有5元、2元、1元、5角 */
  @org.junit.Test
  public void ling() {
    int sum = 80;
    int five = 50;
    int two = 20;
    int one = 10;
    int fivejiao = 5;
    for (int a = 0; a <= sum / five; a++) {
      for (int b = 0; b <= sum / two; b++) {
        // if((sum-a*five)<0) break;
        for (int c = 0; c <= sum / one; c++) {
          if ((sum - (a * five + b * two + c * one)) < 0) break;
          int d = (sum - (a * five + b * two + c * one)) / 5;
          if (a * five + b * two + c * one + d * fivejiao == sum) {
            System.out.println("可能的找零方案:" + "5元" + a + "张,2元" + b + "张,1元" + c + "张,5角" + d + "张");
          }
        }
      }
    }
  }

  /** 求数字自身平方的尾数=自身的数 */
  @org.junit.Test
  public void getAllSelfNum() {
    int num = 10000000;
    for (int i = 0; i <= num; i++) {
      int n = i * i;
      int m = i % 10;
      if (m != 0 && m != 1 && m != 5 && m != 6) {
        continue;
      }
      if (n % 10 == i
          || n % 100 == i
          || n % 1000 == i
          || n % 10000 == i
          || n % 100000 == i
          || n % 1000000 == i) {
        System.out.println(i);
      }
    }
  }

  /**
   * 偶数变易法
   *
   * <p>输出等腰三角形ABC
   */
  @org.junit.Test
  public void printABC() {
    for (int k = 1; k < 5; k++) {
      for (int i = 0; i < 9 - k; i++) {
        System.out.print(" ");
      }
      for (int i = 0; i < k; i++) {
        System.out.print((char) ('A' + i)); // 输出ABCDE,强制转换ASCII码
      }
      for (int i = k - 2; i >= 0; i--) {
        System.out.print((char) ('A' + i));
      }
      System.out.println();
    }
  }

  /** 偶数变易法 输出相应图形 */
  @org.junit.Test
  public void printXX() {
    int LINE = 13; // 由于图形的对称性，输入偶数行时，做出的图形+1行
    int n = LINE / 2;

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < k + 1; i++) System.out.print(" ");
      System.out.print("$$");
      for (int i = 0; i < LINE - 3 - 2 * k; i++) System.out.print(" ");
      System.out.print("$$");
      for (int i = 0; i < k + 1; i++) System.out.print(" ");
      System.out.println();
    }

    for (int i = 0; i < n + 1; i++) System.out.print(" ");
    System.out.print("$$");
    for (int i = 0; i < n + 1; i++) System.out.print(" ");
    System.out.println();

    for (int k = n - 1; k >= 0; k--) {
      for (int i = 0; i < k + 1; i++) System.out.print(" ");
      System.out.print("$$");
      for (int i = 0; i < LINE - 3 - 2 * k; i++) System.out.print(" ");
      System.out.print("$$");
      for (int i = 0; i < k + 1; i++) System.out.print(" ");
      System.out.println();
    }
  }

  /** 字符串"ab cd,bc,de ac" */
  @org.junit.Test
  public void StringTest() {
    String s = "abc ttt,kmd,uuu xyz";
    String s2 = "";
    // 一刀切 （上式: 事先补齐法）
    s = s + " ";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ' || c == ',') {
        System.out.println(s2);
        s2 = "";
      } else {
        s2 = s2 + c;
      }
    }
  }

  /** 字符串abcde 变成a,b,c,d,e */
  @org.junit.Test
  public void testStr2() {
    String s = "abcd";
    String s2 = "";
    for (int i = 0; i < s.length(); i++) {
      s2 += "," + s.charAt(i);
    }
    // 一刀切 （下式: 事后修正法）
    System.out.println(s2.substring(1));
  }

  /** 字符串"sdfccdfewsf" 判断是否有无重复字符 */
  @org.junit.Test
  public void isHave() {

    String str = "asdfghjka";
    Pattern pattern = Pattern.compile("REG_PATTERN");
    Matcher matcher = pattern.matcher(str);
    if (matcher.matches()) {
      for (int i = 0; i < str.length() / 2; i++) {
        if (str.replaceAll(str.substring(0, i + 1), "").length() == 0) {
          System.out.println("有重复");
          break;
        }
      }
    }
  }
}
