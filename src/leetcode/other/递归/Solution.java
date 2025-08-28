package leetcode.other.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void ds(String s, int pos, String[] res) {
        if (pos == s.length()) {
            return;
        }
        res[pos] = s.charAt(pos) + "";
        ds(s, pos + 1, res);
        List<Integer>nums=new ArrayList<>();

        Integer[] array = nums.toArray( new Integer[0]);
        Arrays.sort(array);
    }

    public static void main(String[] args) {
        String[] res = new String[3];
        ds("123", 0, res);
        System.out.println(Arrays.toString(res));
    }
}
