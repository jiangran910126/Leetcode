public class Solution {
    public boolean search(int[] nums, int target) {
        int s=0,e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target==nums[m]) return true;
            if(nums[s]==nums[m]) s++;
            else if(nums[s]<nums[m]){
                if(target>=nums[s]&&target<nums[m]) e=m-1;
                else s=m+1;
            }
            else{
                if(target>nums[m]&&target<=nums[e]) s=m+1;
                else e=m-1;
            }
        }
        return false;
    }
}