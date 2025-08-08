package leetcode.滑动窗口.无重复字符的最长子串;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character>chars=new LinkedList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (chars.contains(c)) {
                chars.removeFirst();
            }
            chars.add(c);
            max = Math.max(max, chars.size());
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
