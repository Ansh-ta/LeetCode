class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int val : nums){
            if(val == 1){
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(count, max);
    }
}