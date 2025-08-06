package leetcode.哈希表.有效的字母异位词;

class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] alpha = new char[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Solution3().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution3().isAnagram("rat", "car"));
    }
}
