class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] arr=new int[n+m];
        int k=0;
        for(int i=0;i<n;i++){
            arr[k++]=nums1[i];
        }
        for(int i=0;i<m;i++){
            arr[k++]=nums2[i];
        }
        Arrays.sort(arr);
        int size=n+m;
        if(size%2==1){
            return arr[size/2];
        }
        else{
            return (arr[size/2]+arr[size/2-1])/2.0;
        }  
    }
}