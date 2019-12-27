package com.zhangze.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangze on 2019/10/21
 * 68、Text Justification：文本左右对齐
 * 给定一个单词数组和一个长度maxWidth，重新排版单词，使得每行恰好有maxWidth个字符，且左右两端对齐
 * 尽可能将单词放在同一行
 * 如果需要插入空格，左边的空格需要多余右边
 * 文本最后一行左对齐，且单词之间不插入额外空格
 *
 * 例子：-----------
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 *
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 *
 */
public class TextJustification {


    public List<String> fullJustify(String[] words, int maxWidth) {
        int[] wordLength = new int[words.length];
        for (int i = 0;i < words.length;i++) {
            wordLength[i] = words[i].length();
        }
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < wordLength.length;i++) {
            max = max + wordLength[i] + 1;
            if (max > maxWidth) {
                left = right;
                right = i - 1;
                int length = 0;
                for (int j = left; j <= right; j++) {
                    length += wordLength[j];
                }
                max = 0;
                int cha = maxWidth - length;
                
            }
        }
        return null;
    }


}
