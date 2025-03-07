class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while( left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                // Target found, return index
                return mid;
            } else if(nums[mid] < target){
                // Search in the right half
                left = mid + 1;
            } else {
                // Search in the left half
                right = mid - 1;
            }
        }
        return -1;
    }
}