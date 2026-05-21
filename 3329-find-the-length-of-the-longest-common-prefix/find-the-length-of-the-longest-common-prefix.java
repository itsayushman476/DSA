import java.util.*;
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for (int num : arr1) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                set.add(prefix);
            }
        }
        int ans = 0;
        for (int num : arr2) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                if (set.contains(prefix)) {
                    ans = Math.max(ans, prefix.length());
                }
            }
        }
        return ans;
    }
}