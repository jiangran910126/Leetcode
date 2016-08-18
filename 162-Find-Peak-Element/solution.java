public class Solution {
    public int findPeakElement(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public int helper(int[] nums,int start,int end){
        if(start==end)
            return start;
        else if(start+1==end){
            if(nums[start]>nums[end]) return start;
            return end;
        }
        else{
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid-1]<nums[mid]&&nums[mid]<nums[mid+1]) return helper(nums,mid+1,end);
            else return helper(nums,start,mid-1);
        }
    }
}