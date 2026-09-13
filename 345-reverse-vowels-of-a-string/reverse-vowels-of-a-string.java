class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int[] pos = new int[s.length()];
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' ||
               arr[i]=='o' || arr[i]=='u' ||
               arr[i]=='A' || arr[i]=='E' || arr[i]=='I' ||
               arr[i]=='O' || arr[i]=='U') {
                pos[count] = i;
                count++;
            }
        }
        int i = 0;
        int j = count - 1;
        while(i < j) {
            char temp = arr[pos[i]];
            arr[pos[i]] = arr[pos[j]];
            arr[pos[j]] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}