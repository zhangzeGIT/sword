package com.zhangze.string;

/**
 * Created by zhangze on 2019/8/15
 * 28、Implement strStr()
 *
 * 给定两个字符串，返回后一个字符串在第一个字符串中第一次出现的指针
 * 如果没有返回-1
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * 备注：Sunday算法
 * 从前往后匹配：
 *      匹配失败时：关注haystack字符串的最末尾字符串的下一位字符
 *             如果该字符串没有在needle字符串中出现则直接跳过，位移数：needle长度+！
 *             否则，位移数：needle字符串最右端的该字符串到末尾的距离+1
 *
 *  1. 刚开始时，把模式串与文本串左边对齐：
 * substring searching algorithm
 * search
 * ^
 *  2、发现i不在search中，search位移：search长度+1
 *  substri|ng searching algorithm(|代表此刻的对齐位置)
 *         |search
 *         |^
 *
 * 3、发现第一个字符串就不匹配，r出现在search中的倒数第三位
 *      所以位移search中r到末尾的距离 + 1 ：也就是3
 *
 *    substring searching algorithm
 * 　　　　     search
 * 　　　　　　　    ^
 *
 * 备注二：KMP算法
 * https://www.cnblogs.com/ZuoAndFutureGirl/p/9028287.html
 */
public class ImplementStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() <= 0) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        boolean haveStr = false;
        char[] hyastacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        for (int i = 0;i < hyastacks.length;i++) {
            if (hyastacks[i] == needles[0]) {
                for (int j = 0;j < needles.length;j++) {
                    if ((i + j) < hyastacks.length && hyastacks[i + j] == needles[j]) {
                        haveStr = true;
                    } else {
                        haveStr = false;
                        break;
                    }
                }
                if (haveStr) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int sunday(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        boolean have = false;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        for (int i = 0;i < h.length;i++) {
            for (int j = 0;j < n.length;j++){
                if ((i + j) < h.length && h[i + j] == n[j]) {
                    have = true;
                } else {
                    have = false;
                    break;
                }
            }
            if (have) {
                return i;
            } else {
                if ((i + n.length) >= h.length) {
                    return -1;
                }else {
                    char c = h[i + n.length];
                    int index = -1;
                    for (int k = n.length-1;k>=0;k--) {
                        if (c == n[k]) {
                            index = k;
                            break;
                        }
                    }
                    if (index == -1) {
                        i = i+ n.length;
                    } else {
                        i = i + n.length - index - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(ImplementStr.class.newInstance()
                .sunday("mississippi", "issi"));
    }

}
