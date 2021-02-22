class Solution {
    public int removeDuplicates(int[] nums) {
        return v1(nums);
    }

    //v1
    //Runtime:0ms，100% ？？，Memory:40.3MB，98.7%
    //通过快慢指针，使两个指针不同的时候计数+1
    public int v1(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int base = 0;
        int cursor = 0;
        while(cursor < nums.length){
            if(nums[base] == nums[cursor]){
                ++cursor;
            }else{
                nums[++base] = nums[cursor++];
            }
        }
        return base+1;