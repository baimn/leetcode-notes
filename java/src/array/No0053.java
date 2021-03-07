class Solution {
    public int maxSubArray(int[] nums) {
        return v2(nums);
    }

    //v1
    //Runtime：119ms,5.56%,Memory:38.9MB,71.63%
    //挨着数呗，也没啥好办法的话
    public int v1(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            int tick = 0;
            for (int j = i; j < nums.length; ++j) {
                tick += nums[j];
                if (tick > res) {
                    res = tick;
                }
            }
        }
        return res;
    }

    //v2
    //Runtime：0ms,100%,Memory:38.8MB,71.63%
    //O(n)解法，当累积当和cumu加上最新的nums[i],比nums[i]还要小 就刷新
    public int v2(int[] nums) {
        int cumu = nums[0];
        int peak = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (cumu <= 0) {
                cumu = nums[i];//restart
            } else {
                cumu += nums[i];//add one
            }
            peak = Math.max(peak, cumu);
        }
        return peak;
    }
}