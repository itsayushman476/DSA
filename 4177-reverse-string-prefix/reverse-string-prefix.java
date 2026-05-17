class Solution {
    public String reversePrefix(String s, int k) {
        char[] chr = s.toCharArray();
        int left = 0;
        int right = k - 1;
        while (left < right) {
            char temp = chr[left];
            chr[left] = chr[right];
            chr[right] = temp;
            left++;
            right--;
        }
        return new String(chr);
    }
}