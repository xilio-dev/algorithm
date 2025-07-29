package leetcode.回溯算法.电话号码的字母组合;

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        Map<Character, String> maps = new HashMap<>();
        maps.put('2', "abc");
        maps.put('3', "def");
        maps.put('4', "ghi");
        maps.put('5', "jkl");
        maps.put('6', "mno");
        maps.put('7', "pqrs");
        maps.put('8', "tuv");
        maps.put('9', "wxyz");
        backtrack(res, digits, new StringBuilder(), maps, 0);
        return res;
    }

    private void backtrack(List<String> res, String digits, StringBuilder comb, Map<Character, String> maps, int index) {
        //当index等于digits长度时，说明已经遍历完digits，将comb添加到返回结果集中
        if (index == digits.trim().length()) {
            res.add(comb.toString());
            return;
        } else {
            //从digits中取出一个数字，此处是核心点，通过回溯不断进行后续数字的不同选择
            char key = digits.charAt(index);
            //通过数字得到字母串
            String item = maps.get(key);
            for (int i = 0; i < item.length(); i++) {
                comb.append(item.charAt(i));
                backtrack(res, digits, comb, maps, index + 1);
                comb.deleteCharAt(index);
            }
        }

    }

    public static void main(String[] args) {
        List<String> letterCombinations = new Solution().letterCombinations("");
        System.out.println(letterCombinations);
    }
}
