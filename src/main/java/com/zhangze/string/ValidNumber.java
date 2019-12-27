package com.zhangze.string;

/**
 * Created by zhangze on 2019/10/14
 * 65、Valid Number：有效数字
 *
 * 判断给定字符串是否可以转换成有效number
 * 、
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        // 第一步：将正负号去掉
        s = s.trim();
        if (s.length() <= 0) {
            return false;
        }
        int dian = 0;
        int e = 0;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == '.') {
                dian++;
            }
            if (s.charAt(i) == 'e') {
                e++;
            }
        }
        if (dian > 1 || e > 1) {
            return false;
        }
        String[] ss = s.split("e");
        if (ss.length > 2 || ss.length <= 0) {
            return false;
        }
        if (s.contains("e") && ss.length != 2) {
            return false;
        }
        if (ss[0].length() <= 0) {
            return false;
        }
        for (int i = 0;i < ss.length;i++) {

                if (ss[i].charAt(0) == '-' || ss[i].charAt(0) == '+') {
                    ss[i] = ss[i].substring(1);
                }


        }
        if (s.contains("e") && (ss.length != 2)) {
            return false;
        }
        if (ss[0].length() <= 0) {
            return false;
        }
        if (ss.length == 2) {
            if (ss[1].length() == 0) {
                return false;
            }
        }
        String[] sss = ss[0].split("\\.");
        if (sss.length > 2 || sss.length <= 0) {
            return false;
        }
        if (ss.length == 2) {
            if (sss.length == 2) {
                return number(sss[0]) && number(sss[1]) && number(ss[1]);
            } else {
                return number(sss[0]) && number(ss[1]);
            }
        } else if (ss.length == 1) {
            if (sss.length == 2) {
                return number(sss[0]) && number(sss[1]);
            } else {
                return number(sss[0]);
            }
        }
        return false;
    }

    private boolean number(String s) {
        char[] ss = s.toCharArray();
        if (ss.length == 0) {
            return true;
        }
        int i = 0;
        for (i = 0; i < ss.length;i++) {
            if (ss[i] < '0' || ss[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        boolean is = ValidNumber.class.newInstance().isNumber("64.e3");
        System.out.println(is);
    }
}
