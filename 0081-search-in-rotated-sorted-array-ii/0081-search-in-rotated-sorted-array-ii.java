class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates: shrink search space
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search left half
                } else {
                    left = mid + 1;  // Search right half
                }
            }
            // Right half is sorted
            else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;  // Search right half
                } else {
                    right = mid - 1; // Search left half
                }
            }
        }
        
        return false;
    }
}