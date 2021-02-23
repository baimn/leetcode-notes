class Solution {
    public int removeElement(int[] nums, int val) {
        return v1(nums, val);
    }

    //v1 wrong
    //Runtime:0ms,100% Memory:37.5MB,81%
    //老规矩，先尝试用双指针直接解此题
    //思路错误！从前往后的对数组元素进行互换不能解此题，eg.
    public int v1(int[] nums, int val) {
        int base = 0;
        int cursor = 0;
        int temp = 0;
        while (cursor < nums.length) {
            if (nums[base] == val) {//base遇到val就停止等待赋值
                if (nums[cursor] != val) {
                    temp = nums[base];
                    nums[base] = nums[cursor];
                    nums[cursor] = temp;
                    ++base;
                }
            } else {
                ++base;
            }
            ++cursor;
        }
        if (base == 0) {
            return base + ((nums.length > 0 && nums[0] != val) ? 1 : 0);
        } else {
            return base;
            // + (nums[0]!=val ? 1:0);
        }

    }
}