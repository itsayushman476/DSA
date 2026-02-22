class Solution {
    public int binaryGap(int n) {
        String bin = Integer.toBinaryString(n);
        int i = -1;       
        int maxGap = 0;
        for(int j = 0; j < bin.length(); j++){
            if(bin.charAt(j) == '1'){
                if(i != -1){
                    maxGap = Math.max(maxGap, j - i);
                }
                i = j;     
            }
        }
        return maxGap;
    }
}