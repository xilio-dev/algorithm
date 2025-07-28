package leetcode.回溯算法.有重复字符串的排列组合;


import java.util.*;

//回溯
public class Solution {
    public String[] permutation(String S) {
        Set<String> res = new HashSet<>();
        char[] words = S.toCharArray();
        StringBuilder current = new StringBuilder();
        //用于标记字符是否被使用过
        boolean [] used = new boolean[words.length];
        backtrack(res, current,used, words);
        return res.toArray(new String[0]);
    }

    private void backtrack(Set<String> res, StringBuilder current, boolean[] used,char[] words) {
        if (current.length() == words.length) {
            res.add(current.toString());
            return;
        }
        for (int i=0;i<words.length;i++) {
            //如果字符已经被使用过了则跳过该字符
            if (used[i]){
                continue;
            }
            //选择字符
            current.append(words[i]);
            used[i] = true;
            //递归回溯 子问题：选择下一个字符
            backtrack(res, current,used, words);
            //撤销选择的字符
            current.deleteCharAt(current.length() - 1);
            //撤销字符使用标记
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        String[] abcs = new Solution().permutation("qqe");
        System.out.println(Arrays.toString(abcs));
    }
}
