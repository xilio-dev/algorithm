package leetcode.哈希表.有效的字母异位词;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution2().isAnagram("rat", "car"));
    }
}
