class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                freq[index]++;
                if (freq[index] > 2) {
                    break;
                }
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}