class Solution {
    public int minOperations(String s) {
        int count1 = 0;
        int count2 = 0;
        int expected1 = 0;
        int expected2 = 1;
        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - '0';
            if(curr != expected1) count1++;
            if(curr != expected2) count2++;
            expected1 = 1 - expected1;
            expected2 = 1 - expected2;
        }
        return Math.min(count1, count2);
    }
}