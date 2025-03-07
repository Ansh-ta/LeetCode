class Solution {
    // Using Tortoise and Hare approach
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = nums[0];
        int fast = nums[0];

        // detect cycle
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast) break;
        }

        // find the entrance to the cycle
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}