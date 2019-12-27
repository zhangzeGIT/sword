package com.zhangze.string;

/**
 * Created by zhangze on 2019/9/29
 * 58/Length Of Last Word
 * 给定一个包含大小写的字符串和空格，返回字符串最后单词的长度
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        String[] ss = s.split(" ");
        int res = 0;
        for (int i = ss.length - 1;i>=0; i--) {
            res = ss[i].length();
            if (res!=0) {
                System.out.println(res);
                return res;
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) throws Exception{
        LengthOfLastWord.class.newInstance().lengthOfLastWord("Hello World");
    }

}
