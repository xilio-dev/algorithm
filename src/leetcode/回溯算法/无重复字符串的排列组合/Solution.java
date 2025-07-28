package leetcode.回溯算法.无重复字符串的排列组合;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String[] permutation(String S) {
        Set<String> res = new HashSet<>();
        char[] words = S.toCharArray();
        StringBuilder current = new StringBuilder();
        backtrack(res, current, words);
        return res.toArray(new String[0]);
    }

    private void backtrack(Set<String> res, StringBuilder current, char[] words) {
        if (current.length() == words.length) {
            res.add(current.toString());
            return;
        }
        for (char word : words) {
            // 如果当前字符串中已经存在该字符，跳过
            if (current.indexOf(word + "") != -1) {
                continue;
            }
            //选择字符
            current.append(word);
            //递归回溯 子问题：选择下一个字符
            backtrack(res, current, words);
            //撤销选择的字符
            current.deleteCharAt(current.length() - 1);
        }
    }


    public static void main(String[] args) {
        String[] abcs = new Solution().permutation("abdc");
        System.out.println(Arrays.toString(abcs));
    }
}
