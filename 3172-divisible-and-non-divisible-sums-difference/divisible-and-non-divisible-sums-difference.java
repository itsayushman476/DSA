class Solution {
    public int differenceOfSums(int n, int m) {
        int total = 0;
        int divisibleSum = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
            if (i % m == 0) {
                divisibleSum += i;
            }
        }
        return total - 2 * divisibleSum;
    }
}