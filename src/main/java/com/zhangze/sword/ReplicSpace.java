package com.zhangze.sword;

/**
 * Created by zhangze on 2019/10/24
 * 5、替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplicSpace {

    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (char c : str.toString().toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) throws Exception{
        StringBuffer sb = new StringBuffer("We Are Happy.");
        String s = ReplicSpace.class.newInstance().replaceSpace(sb);
        System.out.println(s);
    }

}
