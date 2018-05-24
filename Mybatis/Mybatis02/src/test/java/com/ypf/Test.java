package com.ypf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  /** ����ͬ�� ���ù�50�����н�120 */
  @org.junit.Test
  public void test01() {
    for (int i = 0; i < 50; i++) {
      int j = 50 - i;
      if (2 * j + 4 * i == 120) {
        System.out.println("��--" + j + "��--" + i);
      }
    }
  }
  /** ���ŵ�� ��1000����ˣ������1��7����2��8����3 */
  @org.junit.Test
  public void test02() {
    for (int i = 1000; i < 2000; i++) {
      if (i % 5 == 1 && i % 7 == 2 && i % 8 == 3) {
        System.out.println(i);
      }
    }
  }
  /** ������8Ԫ ��5Ԫ��2Ԫ��1Ԫ��5�� */
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
            System.out.println("���ܵ����㷽��:" + "5Ԫ" + a + "��,2Ԫ" + b + "��,1Ԫ" + c + "��,5��" + d + "��");
          }
        }
      }
    }
  }

  /** ����������ƽ����β��=������� */
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
   * ż�����׷�
   *
   * <p>�������������ABC
   */
  @org.junit.Test
  public void printABC() {
    for (int k = 1; k < 5; k++) {
      for (int i = 0; i < 9 - k; i++) {
        System.out.print(" ");
      }
      for (int i = 0; i < k; i++) {
        System.out.print((char) ('A' + i)); // ���ABCDE,ǿ��ת��ASCII��
      }
      for (int i = k - 2; i >= 0; i--) {
        System.out.print((char) ('A' + i));
      }
      System.out.println();
    }
  }

  /** ż�����׷� �����Ӧͼ�� */
  @org.junit.Test
  public void printXX() {
    int LINE = 13; // ����ͼ�εĶԳ��ԣ�����ż����ʱ��������ͼ��+1��
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

  /** �ַ���"ab cd,bc,de ac" */
  @org.junit.Test
  public void StringTest() {
    String s = "abc ttt,kmd,uuu xyz";
    String s2 = "";
    // һ���� ����ʽ: ���Ȳ��뷨��
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

  /** �ַ���abcde ���a,b,c,d,e */
  @org.junit.Test
  public void testStr2() {
    String s = "abcd";
    String s2 = "";
    for (int i = 0; i < s.length(); i++) {
      s2 += "," + s.charAt(i);
    }
    // һ���� ����ʽ: �º���������
    System.out.println(s2.substring(1));
  }

  /** �ַ���"sdfccdfewsf" �ж��Ƿ������ظ��ַ� */
  @org.junit.Test
  public void isHave() {

    String str = "asdfghjka";
    Pattern pattern = Pattern.compile("REG_PATTERN");
    Matcher matcher = pattern.matcher(str);
    if (matcher.matches()) {
      for (int i = 0; i < str.length() / 2; i++) {
        if (str.replaceAll(str.substring(0, i + 1), "").length() == 0) {
          System.out.println("���ظ�");
          break;
        }
      }
    }
  }
}
