package leetcode.数组.反转字符串中的单词;

class Solution {
    public String reverseWords(String s) {
        String trim = s.trim();
        String[] str = trim.split("\\s+");
        int i = 0;
        int j = str.length - 1;
        while (i < j) {
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp.trim();
            i++;
            j--;
        }
        return String.join(" ", str);
    }

    public static void main(String[] args) {

        String s = "a good   example";
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));

    }
}
