package leetcode.滑动窗口.定长子串中元音的最大数目;

class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                max++;
            }
        }
        int pre = max;
        for (int i = k; i < s.length(); i++) {
            int cur = pre;
            if (isVowel(s.charAt(i - k))) {
                cur--;
            }
            if (isVowel(s.charAt(i))) {
                cur++;
            }
            max = Math.max(max, cur);
            pre = cur;
        }
        return max;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >=0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxVowels("tryhard",4));
    }
}
